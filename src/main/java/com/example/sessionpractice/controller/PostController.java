package com.example.sessionpractice.controller;

import com.example.sessionpractice.argmentresolver.LoginUser;
import com.example.sessionpractice.dto.PostRequestDto;
import com.example.sessionpractice.dto.PostResponseDto;
import com.example.sessionpractice.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/posts")
    public void createPost(@RequestBody PostRequestDto postRequestDto, @LoginUser Long userId) {
        System.out.println(userId);
        postService.createPost(postRequestDto, userId);

    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostResponseDto>> getAllPosts() {
        return ResponseEntity.ok().body(postService.getAllPost());
    }


}
