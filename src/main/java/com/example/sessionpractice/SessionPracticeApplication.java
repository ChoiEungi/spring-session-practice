package com.example.sessionpractice;

import com.example.sessionpractice.dto.RegistrationDto;
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
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.createUser(new RegistrationDto("abc","eungi","123"));
        };
    }

}
