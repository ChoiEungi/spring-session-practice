package com.example.sessionpractice.dto;

public class PostRequestDto {
    private final String title;
    private final String description;

    public PostRequestDto(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
