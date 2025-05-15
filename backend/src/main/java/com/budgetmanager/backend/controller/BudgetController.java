package com.budgetmanager.backend.controller;

import com.budgetmanager.backend.Dto.BudgetDto;
import com.budgetmanager.backend.Dto.BudgetResponseDto;
import com.budgetmanager.backend.Dto.CategoryDto;
import com.budgetmanager.backend.Models.Budget;
import com.budgetmanager.backend.Models.Category;
import com.budgetmanager.backend.Repositories.BudgetRepository;
import com.budgetmanager.backend.Services.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/v1/budgets")
@RestController
public class BudgetController {

    final BudgetRepository budgetRepository;
    final BudgetService budgetService;

    @Autowired
    public BudgetController( @RequestBody BudgetService budgetService , BudgetRepository budgetRepository) {
        this.budgetService = budgetService;
        this.budgetRepository = budgetRepository;
    }

    @PostMapping("/AddBudget")
    public ResponseEntity<Budget> createBudget(@RequestBody BudgetDto budgetDto) {
        Budget createdBudget = budgetService.addBudget(budgetDto);
        return ResponseEntity.ok(createdBudget);
    }


    @GetMapping("/GetBudgets")
    public List<BudgetResponseDto> getAllBudgets() {
        return budgetRepository.findAll().stream()
                .map(budget -> {
                    Category cat = budget.getCategory();
                    return new BudgetResponseDto(
                            budget.getLimitBudget(),
                            budget.getStartDate(),
                            budget.getEndDate(),
                            new CategoryDto(cat.getName(), cat.getType())
                    );
                })
                .collect(Collectors.toList());
    }
}
