package com.spring.data_jpa.service.Impl;

import com.spring.data_jpa.entity.Category;
import com.spring.data_jpa.exceptions.RecordNotFoundException;
import com.spring.data_jpa.payload.categorydto.CreateCategoryDto;
import com.spring.data_jpa.payload.categorydto.GetCategoryDto;
import com.spring.data_jpa.repositories.CategoryRepo;
import com.spring.data_jpa.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public CreateCategoryDto createCategory(CreateCategoryDto createCategoryDto) {

        // convert CreateCategoryDto to category.class
        Category createCategory = this.modelMapper.map(createCategoryDto, Category.class);

        // save category to database
        Category savedCategory = this.categoryRepo.save(createCategory);

        return this.modelMapper.map(savedCategory, CreateCategoryDto.class);
    }

    @Override
    public GetCategoryDto getById(Integer id) {
        // fetch category by id
        Category category = this.categoryRepo.findById(id).
                orElseThrow(()-> new RecordNotFoundException("Category", "Category Id", id));

        // map this category to GetCategoryDto
        return this.modelMapper.map(category, GetCategoryDto.class);
    }

    @Override
    public List<GetCategoryDto> getAll() {
        List<Category> listCategories = this.categoryRepo.findAll();
//        return List.of();
        return listCategories.stream().map((categoriesList)-> this.modelMapper.map(categoriesList, GetCategoryDto.class)).collect(Collectors.toList());
    }

    @Override
    public CreateCategoryDto updateCategory(CreateCategoryDto createCategoryDto, Integer id) {
        // find category which is going to be updated
        Category updateCategory = this.categoryRepo.findById(id).
                orElseThrow(()-> new RecordNotFoundException("Category", "Category Id", id));

        // update above category
        updateCategory.setCategoryName(createCategoryDto.getCategoryName());

        // save updated category to database
        Category saveUpdate = this.categoryRepo.save(updateCategory);

        // map updateCategory and return it
        return this.modelMapper.map(saveUpdate, CreateCategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer id) {
        // first verify that category is present or not
        Category deleteCategory = this.categoryRepo.findById(id).
                orElseThrow(()-> new RecordNotFoundException("Category", "Category Id", id));
        this.categoryRepo.deleteById(id);
    }
}
