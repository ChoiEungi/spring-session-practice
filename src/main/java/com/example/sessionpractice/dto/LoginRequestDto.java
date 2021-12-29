package com.example.sessionpractice.dto;

public class LoginRequestDto {
    private final String userLoginId;
    private final String userPassword;

    public LoginRequestDto(String userId, String userPassword) {
        this.userLoginId = userId;
        this.userPassword = userPassword;
    }

    public String getUserLoginId() {
        return userLoginId;
    }

    public String getUserPassword() {
        return userPassword;
    }
}
