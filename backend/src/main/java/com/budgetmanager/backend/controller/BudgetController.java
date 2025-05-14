package com.budgetmanager.backend.controller;

import com.budgetmanager.backend.Models.Budget;
import com.budgetmanager.backend.Services.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("/api/v1/budgets")
public class BudgetController {

    final BudgetService budgetService;

    @Autowired
    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    public String addBudget(Budget budget) {
        budgetService.addBudget(budget);
        return ("your budget is added successfully");
    }
}
