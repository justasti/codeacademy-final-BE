package com.ca_final.backend.dao;

import com.ca_final.backend.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, String> {}