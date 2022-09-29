package com.ca_final.backend.controller;

import com.ca_final.backend.entity.User;
import com.ca_final.backend.entity.UserWithRole;
import com.ca_final.backend.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private UserService userService;

    @PostMapping("/new")
    public User createUser(@RequestBody User user) {
        System.out.println(user.getPersonalCode() + " " + user.getEmail() + " " + user.getFirstName());
        return userService.createUser(user);
    }

    @GetMapping
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/doctors")
    public Iterable<UserWithRole> getAllDoctors() { return userService.getAllDoctors(); }

    @GetMapping("/patients")
    public List<UserWithRole> getAllPatients() { return userService.getAllPatients(); }

    @GetMapping("/current")
    @ResponseBody
    public User getCurrentUser(Authentication authentication) {
        String name = authentication.getName();
        return userService.getCurrentUser(name);
    }

    @GetMapping("/{personalCode}")
    public User getUserByPersonalCode(@PathVariable String personalCode) {
        return userService.getUserByPersonalCode(personalCode);
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