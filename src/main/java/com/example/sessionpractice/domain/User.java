package com.example.sessionpractice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class User {
    public static final String USER_ID_STRING = "id";
    public static final String USER_NAME_STRING = "userName";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userLoginId;

    private String userName;

    private String userPassword;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    public User(String userLoginId, String userName, String userPassword, UserRole userRole) {
        this.userLoginId = userLoginId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRole = userRole;
    }

    public User() {

    }

    public boolean isValidPassword(String userLoginId, String userPassword) {
        return this.userLoginId.equals(userLoginId) && this.userPassword.equals(userPassword);
    }

    public Long getId() {
        return id;
    }

    public String getUserLoginId() {
        return userLoginId;
    }

    public String getUserName() {
        return userName;
    }

    public UserRole getUserRole() {
        return userRole;
    }
}
