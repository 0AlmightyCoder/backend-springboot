package com.spring.data_jpa.repositories;

import com.spring.data_jpa.entity.Category;
import com.spring.data_jpa.entity.Post;
import com.spring.data_jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
}
