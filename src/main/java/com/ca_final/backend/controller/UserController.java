package com.ca_final.backend.controller;

import com.ca_final.backend.entity.User;
import com.ca_final.backend.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users/new")
    public User addNewUser(@RequestBody User user) {

        return this.userService.addNewUser(user);
    }

    @GetMapping("/forAdmin")
    public String forAdmin() {
        return "This URL is only accessible to admin";
    }

    @GetMapping("/forUser")
    public String forUser() {
        return "This URL is only accessible to user";
    }
}
