package com.spring.data_jpa.repositories;

import com.spring.data_jpa.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
