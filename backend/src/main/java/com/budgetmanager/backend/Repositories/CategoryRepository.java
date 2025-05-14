package com.budgetmanager.backend.Repositories;

import com.budgetmanager.backend.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
