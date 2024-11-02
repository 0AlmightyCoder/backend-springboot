package com.spring.data_jpa.service;

import com.spring.data_jpa.payload.categorydto.CreateCategoryDto;
import com.spring.data_jpa.payload.categorydto.GetCategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    // save category to database
    CreateCategoryDto createCategory(CreateCategoryDto createCategoryDto);

    // get category from database by id
    GetCategoryDto getById(Integer id);

    // get all categories from database
    List<GetCategoryDto> getAll();

    // update category from database with id
    CreateCategoryDto updateCategory(CreateCategoryDto createCategoryDto, Integer id);

    // delete category from database
    void deleteCategory(Integer id);
}
