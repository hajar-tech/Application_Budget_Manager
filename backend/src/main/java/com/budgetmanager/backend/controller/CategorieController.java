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

    private final CategoryService categoryService;

    @Autowired
    public CategorieController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/DisplayCategory")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/AddCategory")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable long id) {
        return categoryService.getCategoryById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCategoryById(@PathVariable long id) {
        try {
            categoryService.deleteCategory(id);
            return "Category deleted successfully";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        try {
            Category updatedCategory = categoryService.updateCategory(id, category);
            return ResponseEntity.ok(updatedCategory);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
