package com.example.sessionpractice.service;

import com.example.sessionpractice.domain.User;
import com.example.sessionpractice.domain.UserRole;
import com.example.sessionpractice.dto.RegistrationDto;
import com.example.sessionpractice.exception.CustomException;
import com.example.sessionpractice.repository.UserRepository;
import org.springframework.stereotype.Service;

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

    public Long createUser(RegistrationDto registrationDto) {
        // 일반적으로 Dto는 Controller과 Client 계층에서 사용하고, VO를 사용해 Controller, Service,Repo 사용
        User user = new User(registrationDto.getUserLoginId(), registrationDto.getUserName(), registrationDto.getUserPassword(), UserRole.USER);
        userRepository.save(user);
        return user.getId();
    }

    public Long createUser(User user) {
        userRepository.save(user);
        return user.getId();
    }

    public User login(String userLoginId, String userPassword) {
        User user = userRepository.findUserByUserLoginId(userLoginId).orElseThrow(() -> new CustomException("존재 하지 않은 사용자입니다."));
        if (!user.isValidPassword(userLoginId, userPassword)) {
            throw new CustomException("아이디나 비밀번호가 일치하지 않습니다.");
        }
        return user;
    }

}
