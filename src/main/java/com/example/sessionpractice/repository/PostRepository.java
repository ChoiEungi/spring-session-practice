package com.example.sessionpractice.repository;

import com.example.sessionpractice.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<List<Post>> findAllByUserId(Long userId);
}
