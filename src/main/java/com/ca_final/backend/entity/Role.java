package com.ca_final.backend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role {

    @Id
    private String roleName;
    private String roleDescription;


}
