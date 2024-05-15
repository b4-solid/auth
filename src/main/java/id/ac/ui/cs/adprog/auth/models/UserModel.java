package id.ac.ui.cs.adprog.auth.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "users")
public class UserModel {

    @Id // tambahin ini kalo PK
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "username")
    @NotNull
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