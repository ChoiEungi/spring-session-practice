package com.example.sessionpractice.service;

import com.example.sessionpractice.domain.User;
import com.example.sessionpractice.domain.UserRole;
import com.example.sessionpractice.utils.SessionConst;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;

import javax.servlet.http.HttpSession;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SessionInfoServiceTest {

    @Autowired
    private SessionInfoService sessionInfoService;

    @Test
    public void sessionTest() {
        User user = new User("abc", "eungi", "123!", UserRole.USER);
        HttpSession session = new MockHttpSession();
        session.setAttribute(SessionConst.SESSION_ID, user);
        User userBySession = sessionInfoService.getUserBySession(session);
        assertThat(userBySession.getId()).isEqualTo(user.getId());
        assertThat(userBySession.getUserLoginId()).isEqualTo(user.getUserLoginId());
        assertThat(userBySession.getUserName()).isEqualTo(user.getUserName());
    }
}
