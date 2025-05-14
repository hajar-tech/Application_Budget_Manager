package com.budgetmanager.backend.Services;

import com.budgetmanager.backend.Dto.TransactionDto;
import com.budgetmanager.backend.Models.Category;
import com.budgetmanager.backend.Models.Transaction;
import com.budgetmanager.backend.Repositories.CategoryRepository;
import com.budgetmanager.backend.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;
@Autowired
    public TransactionService(TransactionRepository transactionRepository, CategoryRepository categoryRepository) {
        this.transactionRepository = transactionRepository;
        this.categoryRepository = categoryRepository;
    }

    public Transaction addTransaction(TransactionDto dto) {
        Optional<Category> categoryOptional = categoryRepository.findById(dto.getCategoryId());

        if (categoryOptional.isEmpty()) {
            throw new RuntimeException("Category not found with ID: " + dto.getCategoryId());
        }

        Category category = categoryOptional.get();

        Transaction transaction = new Transaction();
        transaction.setMontant(dto.getMontant());
        transaction.setDate(dto.getDate());
        transaction.setDescription(dto.getDescription());
        transaction.setType(dto.getType());
        transaction.setCategory(category);

        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public boolean deleteTransaction(Long id) {
        if (transactionRepository.existsById(id)) {
            transactionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
