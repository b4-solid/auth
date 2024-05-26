package id.ac.ui.cs.adprog.auth.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import id.ac.ui.cs.adprog.auth.models.UserModel;
import id.ac.ui.cs.adprog.auth.repository.UserRepository;
import id.ac.ui.cs.adprog.auth.service.UserService;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    //C(reate)
    @Override
    public UserModel addUser(String username,  String password, String repassword) {

        String passwordHash = processPassword(password, repassword);
        UserModel User = new UserModel(username, passwordHash, false);

        if (repository.existsById(User.getUsername())) {
            throw new IllegalArgumentException("User already exists");
        }

        return repository.save(User);
    };

    @Override
    public Optional<UserModel> validateUser(String username, String passwordHash) {
        Optional<UserModel> user = repository.findById(username);

        if (user.isPresent() && user.get().getPasswordHash().equals(passwordHash)) {
            return user;
        } else {
            return Optional.empty();
        }
    };

    //U(pdate)
    @Override
    public UserModel updateUser(UserModel User) {
        return repository.save(User);
    };

    private String processPassword(String password, String repassword) {

        if (!password.equals(repassword)) {
            throw new IllegalArgumentException("Passwords do not match");
        }

        String pattern = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{8,20}$";

        if (!password.matches(pattern)) {
            throw new IllegalArgumentException("Unacceptable password format");
        }

        try {
            MessageDigest digester = MessageDigest.getInstance("SHA-256");
            StringBuilder builder = new StringBuilder();
            byte[] hash = digester.digest(password.getBytes());

            for (byte b : hash) {
                builder.append(String.format("%02x", b));
            }

            return builder.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("Failed to hash password");
        }
    }
}