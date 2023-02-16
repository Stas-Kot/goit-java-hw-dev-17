package com.goit.feature.mvc.security;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@RequiredArgsConstructor
//@Component
public class MessageResponse {
    private final String message;
}
