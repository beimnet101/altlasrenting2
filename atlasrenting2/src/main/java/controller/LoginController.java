package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.LoginRequest;
import model.Role;
import service.LoginService;

@RestController
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        Long roleId = loginRequest.getRoleID();
        String roleName = loginRequest.getRoleName();

        User user = loginService.authenticate(username, password, roleId, roleName);

        if (user != null) {
            // Perform actions based on the user's role
            return  " login successful";
        }

        // Handle invalid login or role not found
        return "Invalid login credentials";
    }
}