package com.spring.data_jpa.controller;

import com.spring.data_jpa.payload.categorydto.CreateCategoryDto;
import com.spring.data_jpa.payload.categorydto.GetCategoryDto;
import com.spring.data_jpa.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    // save category to database
    @PostMapping("/create-category")
    public ResponseEntity<CreateCategoryDto> saveCategory(@RequestBody CreateCategoryDto createCategoryDto) {
        this.categoryService.createCategory(createCategoryDto);
        return new ResponseEntity<>(createCategoryDto, HttpStatus.CREATED);
    }

    // get category from database by id
    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<GetCategoryDto> fetchById(@PathVariable("id") Integer id) {
        GetCategoryDto getCategory = this.categoryService.getById(id);
        return ResponseEntity.ok(getCategory);
    }

    // get all categories from database
    @GetMapping("/get-all")
    public ResponseEntity<List<GetCategoryDto>> getAll() {
        List<GetCategoryDto> categoryList = this.categoryService.getAll();
        return ResponseEntity.ok(categoryList);
    }

    // update category by id
    @PutMapping("/update-category/{id}")
    public ResponseEntity<CreateCategoryDto> modifyCategory(@RequestBody CreateCategoryDto createCategoryDto, @PathVariable("id") Integer id) {
        CreateCategoryDto categoryDto = this.categoryService.updateCategory(createCategoryDto, id);
        return new ResponseEntity<>(categoryDto, HttpStatus.CREATED);
    }

    // delete a category by id
    @DeleteMapping("/delete-category/{id}")
    public ResponseEntity<GetCategoryDto> removeCategory(@PathVariable("id") Integer id) {
        GetCategoryDto getCategory = this.categoryService.getById(id);
        this.categoryService.deleteCategory(id);
        return ResponseEntity.ok(getCategory);
    }
}
