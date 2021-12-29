package com.example.sessionpractice;

import com.example.sessionpractice.domain.User;
import com.example.sessionpractice.dto.PostRequestDto;
import com.example.sessionpractice.dto.RegistrationDto;
import com.example.sessionpractice.service.PostService;
import com.example.sessionpractice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SessionPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SessionPracticeApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService, PostService postService) {
        return args -> {
            Long userId1 = userService.createUser(new RegistrationDto("abc", "eungi", "123"));
            Long userId2 = userService.createUser(new RegistrationDto("def","eungi2","123!"));
            postService.createPost(new PostRequestDto("title1", "content1"), userId1);
            postService.createPost(new PostRequestDto("title2", "content2"), userId1);
            postService.createPost(new PostRequestDto("title3", "content2 by user2"), userId2);
        };
    }

}
