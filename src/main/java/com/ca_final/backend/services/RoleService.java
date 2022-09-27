package com.ca_final.backend.services;

import com.ca_final.backend.entity.Role;
import com.ca_final.backend.dao.RoleDao;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class RoleService {

    private RoleDao dao;

    public Role createNewRole(Role role) {
        return dao.save(role);
    }
}
