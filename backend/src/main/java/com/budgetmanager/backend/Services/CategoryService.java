package com.budgetmanager.backend.Services;


import com.budgetmanager.backend.Models.Category;
import com.budgetmanager.backend.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService {
    final CategoryRepository categoryRepository;
    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category getCategoryById(long id) {
        return  categoryRepository.findById(id).orElse(null);
    }

    public void deleteCategory(Long id) {
        Category existing = categoryRepository.findById(id).orElse(null);
        if (existing != null) {
            categoryRepository.delete(existing);
        }
             else {
                 System.out.println("Category not found");
        }


    }
}
