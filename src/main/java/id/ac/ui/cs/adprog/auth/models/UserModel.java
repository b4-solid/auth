package id.ac.ui.cs.adprog.auth.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Setter
@Getter
@Entity
@Table(name = "users")
public class UserModel {

    @Id // tambahin ini kalo PK
    @Column(name = "username")
    private String username;

    @Column(name = "passwordHash")
    @NotNull
    private String passwordHash;

    @Column(name = "isAdmin")
    private boolean isAdmin;


    public UserModel(String username, String passwordHash, boolean isAdmin) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.isAdmin = isAdmin;
    }

    public UserModel() {

    }
}