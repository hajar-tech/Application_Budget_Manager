package com.budgetmanager.backend.Services;

import com.budgetmanager.backend.Dto.BudgetDto;
import com.budgetmanager.backend.Dto.BudgetResponseDto;
import com.budgetmanager.backend.Dto.CategoryDto;
import com.budgetmanager.backend.Models.Budget;
import com.budgetmanager.backend.Models.Category;
import com.budgetmanager.backend.Repositories.BudgetRepository;
import com.budgetmanager.backend.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BudgetService {

    final BudgetRepository budgetRepository;

   final CategoryRepository categoryRepository;
    @Autowired
    public BudgetService(BudgetRepository budgetRepository , CategoryRepository categoryRepository ) {
        this.budgetRepository = budgetRepository;
        this.categoryRepository = categoryRepository;

    }


    public Budget addBudget(BudgetDto budgetDto) {
        Optional<Category> optionalCategory = categoryRepository.findById(budgetDto.idCategory());

        if (optionalCategory.isEmpty()) {
            throw new IllegalArgumentException("Category not found with id: " + budgetDto.idCategory());
        }

        Budget budget = new Budget(
                budgetDto.limitBudget(),
                budgetDto.startDate(),
                budgetDto.endDate(),
                optionalCategory.get()
        );

        return budgetRepository.save(budget);
    }



    public List<BudgetResponseDto> getAllBudgets() {
        return budgetRepository.findAll().stream().map(budget -> {
            Category category = budget.getCategory();
            return new BudgetResponseDto(

                    budget.getLimitBudget(),
                    budget.getStartDate(),
                    budget.getEndDate(),
                    new CategoryDto(
                            category.getName(),
                            category.getType()
                    )

            );
        }).collect(Collectors.toList());
    }


}
