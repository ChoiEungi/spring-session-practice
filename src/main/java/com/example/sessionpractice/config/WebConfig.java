package com.example.sessionpractice.config;

import com.example.sessionpractice.argmentresolver.LoginUserArgumentResolver;
import com.example.sessionpractice.interceptor.AuthorizationCheckInterceptor;
import com.example.sessionpractice.interceptor.LoginCheckInterceptor;
import com.example.sessionpractice.utils.PathStrings;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new LoginUserArgumentResolver());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCheckInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns(PathStrings.NO_AUTHORITIES_PATHS);

        registry.addInterceptor(new AuthorizationCheckInterceptor())
                .order(2)
                .addPathPatterns(PathStrings.USER_AUTHORITIES_PATHS)
                .excludePathPatterns(PathStrings.NO_AUTHORITIES_PATHS);
    }
}
