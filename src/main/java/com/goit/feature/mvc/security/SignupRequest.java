package com.goit.feature.mvc.security;

import lombok.Data;

@Data
public class SignupRequest {
    private String username;
    private String password;
    private String role;
}
