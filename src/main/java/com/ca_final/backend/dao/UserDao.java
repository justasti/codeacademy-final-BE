package com.ca_final.backend.dao;

import com.ca_final.backend.entity.User;
import com.ca_final.backend.entity.UserWithRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends CrudRepository<User, String> {

    @Query(value = "SELECT first_name AS firstName, last_name AS lastName, role_id AS roleName FROM users u INNER JOIN user_roles ur ON u.personal_code = ur.personal_code WHERE ur.role_id='doctor'", nativeQuery = true)
    Iterable<UserWithRole> getAllDoctors();

    @Query(value = "SELECT first_name AS firstName, last_name AS lastName, role_id AS roleName FROM users u INNER JOIN user_roles ur ON u.personal_code = ur.personal_code WHERE ur.role_id='user'", nativeQuery = true)
    List<UserWithRole> getAllPatients();
}