package com.example.sessionpractice.dto;

public class PostResponseDto {
    private final String title;
    private final String description;
    private final String userName;

    public PostResponseDto(String title, String description, String userName) {
        this.title = title;
        this.description = description;
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUserName() {
        return userName;
    }
}
