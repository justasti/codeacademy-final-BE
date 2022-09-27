package com.example.jwt.services;

import com.example.jwt.dao.RoleDao;
import com.example.jwt.entity.Role;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleDao dao;

    public Role createNewRole(Role role) {
        return dao.save(role);
    }
}
