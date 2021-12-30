package com.example.sessionpractice.argmentresolver;

import com.example.sessionpractice.domain.User;
import com.example.sessionpractice.exception.CustomException;
import com.example.sessionpractice.utils.SessionConst;
import org.hibernate.Session;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean hasAnnotation = parameter.hasParameterAnnotation(LoginUser.class);
        boolean hasUserType = Long.class.isAssignableFrom(parameter.getParameterType());
        return hasAnnotation && hasUserType;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        HttpSession session = request.getSession(false);
        if (session == null) {
            throw new CustomException("세션이 존재하지 않습니다.");
        }
        User user = (User) session.getAttribute(SessionConst.SESSION_ID);
        return user.getId();
    }
}
