package com.budgetmanager.backend.Services;

import com.budgetmanager.backend.Models.Transaction;
import com.budgetmanager.backend.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    public TransactionRepository transactionRepository;


    public Transaction AjouterTransaction(Transaction transaction){
        return transactionRepository.save(transaction);
    }

}
