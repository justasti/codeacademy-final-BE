package com.ca_final.backend.controller;

import com.ca_final.backend.entity.Role;
import com.ca_final.backend.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/roles/new")
    public Role createNewRole(@RequestBody Role role) {
        System.out.println("role" + role.getRoleName() + " " + role.getRoleDescription());
        System.out.println("trying controller");
        return roleService.createNewRole(role);
    }
}
