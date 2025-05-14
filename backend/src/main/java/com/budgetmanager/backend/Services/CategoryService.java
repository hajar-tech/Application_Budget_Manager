package com.budgetmanager.backend.Services;

import com.budgetmanager.backend.Models.Category;
import com.budgetmanager.backend.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }


}
