package com.ca_final.backend.controller;

import com.ca_final.backend.entity.Role;
import com.ca_final.backend.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class RoleController {

    private RoleService roleService;

    @PostMapping({"/createNewRole"})
    public Role createNewRole(@RequestBody Role role) {
        return roleService.createNewRole(role);
    }
}
