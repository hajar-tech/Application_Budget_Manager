package com.budgetmanager.backend.controller;

import com.budgetmanager.backend.Models.Budget;
import com.budgetmanager.backend.Services.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/budgets")
@RestController
public class BudgetController {

    final BudgetService budgetService;

    @Autowired
    public BudgetController( @RequestBody BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @PostMapping("/AddBudget")
    public String addBudget(Budget budget) {
        budgetService.addBudget(budget);
        return ("your budget is added successfully");
    }
}
