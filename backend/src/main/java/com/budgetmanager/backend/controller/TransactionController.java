package com.budgetmanager.backend.controller;

import com.budgetmanager.backend.Models.Transaction;
import com.budgetmanager.backend.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public Transaction AjouterTransaction(@RequestBody Transaction transaction){
        return transactionService.AjouterTransaction(transaction);
    }
}
