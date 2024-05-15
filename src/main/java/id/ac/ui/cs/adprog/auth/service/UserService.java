package id.ac.ui.cs.adprog.auth.service;

import java.util.List;
import java.util.Optional;

import id.ac.ui.cs.adprog.auth.models.UserModel;

public interface UserService {

    //C(reate)
    UserModel addUser(UserModel User);

    //R(ead)
    List<UserModel> findAllUser();
    Optional<UserModel> findById(Long id);

    //U(pdate)
    UserModel updateUser(UserModel User);

    //D(elete)
    void deleteUser(Long id);
}