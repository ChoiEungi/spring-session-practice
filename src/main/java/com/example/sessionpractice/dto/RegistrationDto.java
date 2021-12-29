package com.example.sessionpractice.dto;

public class RegistrationDto {
    private final String userLoginId;
    private final String userName;
    private final String userPassword;

    public RegistrationDto(String userLoginId, String userName, String userPassword) {
        this.userLoginId = userLoginId;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserLoginId() {
        return userLoginId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }
}
