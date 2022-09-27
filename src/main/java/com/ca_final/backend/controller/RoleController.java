package com.ca_final.backend.controller;

import com.ca_final.backend.entity.Role;
import com.ca_final.backend.services.RoleService;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
public class RoleController {

    private RoleService roleService;

    @PostMapping("/roles/new-role")
    public Role createNewRole(@RequestBody Role role) {
        return roleService.createNewRole(role);
    }
}
