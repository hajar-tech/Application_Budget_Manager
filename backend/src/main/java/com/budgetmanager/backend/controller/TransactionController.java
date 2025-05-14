package com.budgetmanager.backend.controller;

import com.budgetmanager.backend.Models.Transaction;
import com.budgetmanager.backend.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public Transaction AjouterTransaction(@RequestBody Transaction transaction){
        return transactionService.AjouterTransaction(transaction);
    }
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }
}
