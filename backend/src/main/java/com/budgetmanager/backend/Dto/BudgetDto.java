package com.budgetmanager.backend.Dto;

import java.sql.Date;

public record BudgetDto (
        int limitBudget,
         Date startDate,
         Date endDate,
        long idCategory)
{


}
