package com.ca_final.backend.services;

import com.ca_final.backend.entity.Role;
import com.ca_final.backend.dao.RoleDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleDao dao;

    public Role createNewRole(Role role) {
        return dao.save(role);
    }
}
