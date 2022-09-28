package com.ca_final.backend.controller;

import com.ca_final.backend.entity.User;
import com.ca_final.backend.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @PostMapping("/new")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }
//    @GetMapping("/forAdmin")
//    @PreAuthorize("hasRole('Admin')")
//    public String forAdmin(){
//        return "This URL is only accessible to the admin";
//    }
//
//    @GetMapping("/forUser")
//    @PreAuthorize("hasRole('Admin') || hasRole('User')")
//    public String forUser(){
//        return "This URL is only accessible to the user";
//    }
}