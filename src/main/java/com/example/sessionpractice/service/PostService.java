package com.example.sessionpractice.service;

import com.example.sessionpractice.domain.Post;
import com.example.sessionpractice.domain.User;
import com.example.sessionpractice.dto.PostRequestDto;
import com.example.sessionpractice.dto.PostResponseDto;
import com.example.sessionpractice.exception.CustomException;
import com.example.sessionpractice.repository.PostRepository;
import com.example.sessionpractice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public List<PostResponseDto> getAllPost() {
        List<PostResponseDto> postResponseDtos = new ArrayList<>();
        for (Post post : postRepository.findAll()) {
            User user = userRepository.findById(post.getUserId()).orElseThrow(() -> new CustomException("올바르지 않은 사용자입니다."));
            postResponseDtos.add(new PostResponseDto(post.getTitle(), post.getDescription(), user.getUserName()));
        }
        return postResponseDtos;
    }

    public Long createPost(PostRequestDto postRequestDto, Long userId) {
        Post post = new Post(postRequestDto.getTitle(), postRequestDto.getDescription(), userId);
        postRepository.save(post);
        return post.getId();

    }
}
