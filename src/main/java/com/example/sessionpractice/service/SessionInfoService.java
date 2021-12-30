package com.example.sessionpractice.service;

import com.example.sessionpractice.domain.User;
import com.example.sessionpractice.utils.SessionConst;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class SessionInfoService {

    public User getUserBySession(HttpSession session) {
        User user = (User) session.getAttribute(SessionConst.SESSION_ID);
        return user;
    }
}
