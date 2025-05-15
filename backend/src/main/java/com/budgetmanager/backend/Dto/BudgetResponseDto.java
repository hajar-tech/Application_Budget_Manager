package com.budgetmanager.backend.Dto;

import com.budgetmanager.backend.Models.Category;

import java.sql.Date;

public record BudgetResponseDto(
        int limitBudget,
        Date startDate,
        Date endDate,
        CategoryDto category
) {
}
