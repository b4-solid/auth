package id.ac.ui.cs.adprog.auth.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import id.ac.ui.cs.adprog.auth.models.UserModel;
import id.ac.ui.cs.adprog.auth.repository.UserRepository;
import id.ac.ui.cs.adprog.auth.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    //C(reate)
    @Override
    public UserModel addUser(UserModel User) {
        return repository.save(User);
    };

    //R(ead)
    @Override
    public List<UserModel> findAllUser() {
        return repository.findAll();
    };

    @Override
    public Optional<UserModel> findById(Long id) {
        return repository.findById(id);
    };

    //U(pdate)
    @Override
    public UserModel updateUser(UserModel User) {
        return repository.save(User);
    };

    //D(elete)
    public void deleteUser(Long id) {
        repository.deleteById(id);
    };
}