package com.example.sessionpractice.service;

import com.example.sessionpractice.domain.User;
import com.example.sessionpractice.dto.LoginRequestDto;
import com.example.sessionpractice.dto.RegistrationDto;
import com.example.sessionpractice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(RegistrationDto registrationDto){
        User user = new User(registrationDto.getUserLoginId(), registrationDto.getUserName(), registrationDto.getUserPassword());
        userRepository.save(user);
    }

    public User login(LoginRequestDto loginRequestDto) {
        User user = userRepository.findUserByUserLoginId(loginRequestDto.getUserLoginId()).orElseThrow(IllegalArgumentException::new);
        if (!user.isValidPassword(loginRequestDto.getUserLoginId(), loginRequestDto.getUserPassword())) {
            throw new IllegalArgumentException("");
        }
        return user;
    }

}
