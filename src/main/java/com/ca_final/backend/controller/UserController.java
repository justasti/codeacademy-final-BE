package com.ca_final.backend.controller;

import com.ca_final.backend.entity.User;
import com.ca_final.backend.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users/new")
    public User addNewUser(@RequestBody User user) {

        return this.userService.addNewUser(user);
    }
}
