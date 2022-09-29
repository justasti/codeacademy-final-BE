package com.ca_final.backend.services;

import com.ca_final.backend.dao.RoleDao;
import com.ca_final.backend.dao.UserDao;
import com.ca_final.backend.entity.Role;
import com.ca_final.backend.entity.User;
import com.ca_final.backend.entity.UserData;
import com.ca_final.backend.entity.UserWithRole;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserService {

    private UserDao userDao;
    private RoleDao roleDao;
    private PasswordEncoder passwordEncoder;

    public User createUser(User user) {
        Role role = roleDao.findById("user").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRoles(userRoles);
        user.setPassword(getEncodedPassword(user.getPassword()));

        return userDao.save(user);
    }

    public User updateUserRoles(UserData userdata) {
        User user = userDao.findById(userdata.getPersonalCode()).get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(new Role(userdata.getRoleName()));
        user.setRoles(userRoles);
        return userDao.save(user);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public Iterable<User> getAllUsers() {
        return userDao.findAll();
    }

    public Iterable<UserWithRole> getAllDoctors() { return userDao.getAllDoctors(); }

    public List<UserWithRole> getAllPatients() { return userDao.getAllPatients(); }

    public User getCurrentUser(String username) { return userDao.findById(username).get(); }

    public User getUserByPersonalCode(String personalCode) {
        return userDao.getByPersonalCode(personalCode);
    }
}