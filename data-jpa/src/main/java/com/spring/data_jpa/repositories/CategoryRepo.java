package com.spring.data_jpa.repositories;

import com.spring.data_jpa.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
