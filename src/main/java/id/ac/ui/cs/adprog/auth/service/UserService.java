package id.ac.ui.cs.adprog.auth.service;

import java.util.Optional;
import id.ac.ui.cs.adprog.auth.models.UserModel;

public interface UserService {

    //C(reate)
    UserModel addUser(String username,  String password, String repassword);

    //R(ead)
    Optional<UserModel> validateUser(String username, String passwordHash);

    //U(pdate)
    UserModel updateUser(UserModel User);
}