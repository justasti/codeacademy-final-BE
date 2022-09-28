package com.ca_final.backend.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtRequest {

    private String personalCode;
    private String password;
}
