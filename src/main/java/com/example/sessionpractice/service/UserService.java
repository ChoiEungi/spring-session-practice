package com.example.sessionpractice.service;

import com.example.sessionpractice.domain.User;
import com.example.sessionpractice.dto.LoginRequestDto;
import com.example.sessionpractice.dto.RegistrationDto;
import com.example.sessionpractice.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public Long createUser(RegistrationDto registrationDto){
        // 일반적으로 Dto는 Controller과 Client 계층에서 사용하고, VO를 사용해 Controller, Service,Repo 사용
        User user = new User(registrationDto.getUserLoginId(), registrationDto.getUserName(), registrationDto.getUserPassword());
        userRepository.save(user);
        return user.getId();
    }

    public User login(String userLoginId, String userPassword) {
        User user = userRepository.findUserByUserLoginId(userLoginId).orElseThrow(IllegalArgumentException::new);
        if (!user.isValidPassword(userLoginId, userPassword)) {
            throw new IllegalArgumentException("");
        }
        return user;
    }

}
