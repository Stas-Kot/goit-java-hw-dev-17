package com.goit.feature.mvc.security;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
