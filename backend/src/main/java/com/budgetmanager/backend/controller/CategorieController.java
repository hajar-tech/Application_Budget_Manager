package com.budgetmanager.backend.controller;


import com.budgetmanager.backend.Models.Category;
import com.budgetmanager.backend.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategorieController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/DisplayCategory")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
    @PostMapping("/AddCategory")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

}
