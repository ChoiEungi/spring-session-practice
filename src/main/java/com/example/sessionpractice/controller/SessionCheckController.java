package com.example.sessionpractice.controller;

import com.example.sessionpractice.domain.User;
import com.example.sessionpractice.exception.CustomException;
import com.example.sessionpractice.service.SessionInfoService;
import com.example.sessionpractice.utils.SessionConst;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class SessionCheckController {

    private final SessionInfoService sessionInfoService;

    public SessionCheckController(SessionInfoService sessionInfoService) {
        this.sessionInfoService = sessionInfoService;
    }

    @GetMapping("/session-info")
    public User getSession(HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession(false);
        if(session == null) {
            throw new CustomException("존재하지 않는 세션입니다.");
        }
        return sessionInfoService.getUserBySession(session);
    }
}
