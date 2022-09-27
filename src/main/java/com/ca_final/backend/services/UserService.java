package com.ca_final.backend.services;

import com.ca_final.backend.dao.UserDao;
import com.ca_final.backend.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserDao userDao;

    public User addNewUser(User user) {

        return userDao.save(user);
    }
}
