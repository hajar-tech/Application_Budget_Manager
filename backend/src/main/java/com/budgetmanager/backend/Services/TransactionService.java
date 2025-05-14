package com.budgetmanager.backend.Services;

import com.budgetmanager.backend.Models.Transaction;
import com.budgetmanager.backend.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

@Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;

    }

    public Transaction AjouterTransaction(Transaction transaction) {

        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public Transaction updateTransaction(Long id, Transaction updatedTransaction) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);

        if (optionalTransaction.isEmpty()) {
            System.out.println("Transaction with ID " + id + " not found");
            return null;
        }

        Transaction transaction = optionalTransaction.get();
        transaction.setMontant(updatedTransaction.getMontant());
        transaction.setDate(updatedTransaction.getDate());
        transaction.setDescription(updatedTransaction.getDescription());
        transaction.setType(updatedTransaction.getType());
        transaction.setCategory(updatedTransaction.getCategory());

        return transactionRepository.save(transaction);
    }

    public boolean deleteTransaction(Long id) {
        if (transactionRepository.existsById(id)) {
            transactionRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
