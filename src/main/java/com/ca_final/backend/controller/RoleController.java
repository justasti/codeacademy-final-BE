package com.example.jwt.controller;

import com.example.jwt.entity.Role;
import com.example.jwt.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/roles/new-role")
    public Role createNewRole(@RequestBody Role role) {
        return roleService.createNewRole(role);
    }
}
