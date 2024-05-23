package id.ac.ui.cs.adprog.auth.controller;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import id.ac.ui.cs.adprog.auth.models.UserModel;
import id.ac.ui.cs.adprog.auth.service.UserService;

@RestController
@RequestMapping("")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public HashMap<String, String> register(@RequestBody HashMap<String, String> credentials) {
        HashMap<String, String> response = new HashMap<>();

        try {
            userService.addUser(credentials.get("username"), credentials.get("password"), credentials.get("repassword"));
            response.put("status", "success");
        } catch (IllegalArgumentException e) {
            response.put("status", "failed");
            response.put("reason", e.getMessage());
        }

        return response;
    }

    @PostMapping("/login")
    public HashMap<String, String> login(@RequestBody HashMap<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        Optional<UserModel> user = userService.validateUser(username, password);
        HashMap<String, String> response = new HashMap<>();

        if (user.isPresent()) {
            response.put("status", "success");
            response.put("username", user.get().getUsername());
            response.put("admin", user.get().isAdmin() ? "true" : "false");
        } else {
            response.put("status", "failed");
            response.put("reason", "Incorrect username or password");
        }

        return response;
    }
}
