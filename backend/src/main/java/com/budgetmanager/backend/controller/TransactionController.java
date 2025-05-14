package com.budgetmanager.backend.controller;

import com.budgetmanager.backend.Dto.TransactionDto;
import com.budgetmanager.backend.Models.Transaction;
import com.budgetmanager.backend.Services.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Transaction> addTransaction(@RequestBody TransactionDto transactionDto) {
        Transaction created = transactionService.addTransaction(transactionDto);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
        Transaction transaction = transactionService.getTransactionById(id);
        return transaction != null ? ResponseEntity.ok(transaction) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        return transactionService.deleteTransaction(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}
