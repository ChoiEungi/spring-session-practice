package com.example.sessionpractice.interceptor;

import com.example.sessionpractice.domain.User;
import com.example.sessionpractice.domain.UserRole;
import com.example.sessionpractice.utils.AuthorityMethods;
import com.example.sessionpractice.utils.SessionConst;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthorizationCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute(SessionConst.SESSION_ID);
        UserRole userRole = user.getUserRole();
        request.setAttribute(User.USER_ID_STRING, user.getId());
        request.setAttribute(User.USER_NAME_STRING, user.getUserName());

        if (userRole.equals(UserRole.USER) && request.getMethod().equals(HttpMethod.GET.name())) {
            return true;
        }

        for (String method : AuthorityMethods.adminMethods) {
            if (userRole.equals(UserRole.ADMIN) && request.getMethod().equals(method)) {
                return true;
            }
        }

        response.sendRedirect("/no-auth");
        return false;

    }
}
