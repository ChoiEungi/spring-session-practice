package com.example.sessionpractice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userLoginId;

    private String userName;

    private String userPassword;

    public User(String userLoginId, String userName, String userPassword) {
        this.userLoginId = userLoginId;
        this.userName = userName;
        this.userPassword = userPassword;
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
}
