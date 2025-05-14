package com.budgetmanager.backend.Services;

import com.budgetmanager.backend.Models.Budget;
import com.budgetmanager.backend.Repositories.BudgetRepository;
import com.budgetmanager.backend.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetService {

    final BudgetRepository budgetRepository;


    @Autowired
    public BudgetService(BudgetRepository budgetRepository  ) {
        this.budgetRepository = budgetRepository;

    }

    public void addBudget(Budget budget) {
       budgetRepository.save(budget);

    }
}
