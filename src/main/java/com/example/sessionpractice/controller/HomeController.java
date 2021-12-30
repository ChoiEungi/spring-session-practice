package com.example.sessionpractice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home for session test";
    }

    @GetMapping("/home")
    public String noLogin() {
        return "로그인하지 않았습니다.";
    }

    @GetMapping("/no-auth")
    public String noAuth() {
        return "권한이 없습니다.";
    }
}
