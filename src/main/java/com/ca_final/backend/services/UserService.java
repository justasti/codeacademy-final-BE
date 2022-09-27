package com.ca_final.backend.services;

import com.ca_final.backend.dao.RoleDao;
import com.ca_final.backend.dao.UserDao;
import com.ca_final.backend.entity.Role;
import com.ca_final.backend.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserService {

    private UserDao userDao;
    private RoleDao roleDao;
    private PasswordEncoder passwordEncoder;

    public User registerNewUser(User user) {
        Role role = roleDao.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setPassword(getEncodedPassword(user.getPassword()));

        return userDao.save(user);
    }

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setName("Admin");
        adminRole.setDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setName("User");
        userRole.setDescription("Default role for newly created record");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUsername("admin123");
        adminUser.setPassword(getEncodedPassword("adminpass"));
        adminUser.setFirstName("admin");
        adminUser.setLastName("admin");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

        User user = new User();
        user.setUsername("justasti");
        user.setPassword(getEncodedPassword("labadiena1"));
        user.setFirstName("justas");
        user.setLastName("tirevicius");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userDao.save(user);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}