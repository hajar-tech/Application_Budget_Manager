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
        return categoryRepository.findById(id).orElse(null);
    }

    public void deleteCategory(Long id) {
        Category existing = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        categoryRepository.delete(existing);
    }

    public Category updateCategory(Long id, Category updatedCategory) {
        Category category = getCategoryById(id);
        if (category != null) {
            // Mettre à jour les champs
            category.setName(updatedCategory.getName());
            category.setType(updatedCategory.getType());
            return categoryRepository.save(category);
        }

        else {
            throw new RuntimeException("Catégorie non trouvée avec l'ID : " + id);
        }
    }


}


//        Category existing = categoryRepository.findById(id).orElse(null);
//        if (existing != null) {
//            categoryRepository.delete(existing);
//            return "Category deleted successfully";
//        }
//             else {
//                 return "Category not found";
//        }




