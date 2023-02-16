package com.goit.feature.mvc.security.jwt;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class JwtResponse {
    private final String token;
    private String type = "Bearer";
    private final Long id;
    private final String username;
    private final String role;
}
