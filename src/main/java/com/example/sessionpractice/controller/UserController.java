package com.example.sessionpractice.controller;

import com.example.sessionpractice.domain.User;
import com.example.sessionpractice.dto.LoginRequestDto;
import com.example.sessionpractice.service.UserService;
import com.example.sessionpractice.utils.SessionConst;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "home for session test";
    }

    @GetMapping("/home")
    public String home2() {
        return "home2 for session test";
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok().body(userService.getAllUser());
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginRequestDto loginRequestDto, HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = userService.login(loginRequestDto.getUserLoginId(), loginRequestDto.getUserPassword());
        HttpSession session = request.getSession();   //세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성
        session.setAttribute(SessionConst.SESSION_ID, user);
        response.sendRedirect("/");
        return;
    }

    // registration -> CLIRunner을 통해 주입

}
