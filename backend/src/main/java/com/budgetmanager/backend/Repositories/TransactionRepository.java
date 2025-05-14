package com.budgetmanager.backend.Repositories;

import com.budgetmanager.backend.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
