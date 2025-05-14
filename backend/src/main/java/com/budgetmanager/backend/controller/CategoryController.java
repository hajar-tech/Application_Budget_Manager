package com.budgetmanager.backend.controller;

import com.budgetmanager.backend.Models.Category;
import com.budgetmanager.backend.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }


    @GetMapping
    public List<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }


}
