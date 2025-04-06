package com.example.bugtracker.dto;

import lombok.Data;

@Data
public class LoginResponse {
    private Long id;
    private String username;
    private String role;
    private boolean success;
    private String message;
}