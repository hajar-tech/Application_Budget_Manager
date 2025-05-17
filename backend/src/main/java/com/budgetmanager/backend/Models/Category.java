package com.budgetmanager.backend.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type; // income or expense

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Budget> budgets;

    public Category() {}

    public Category(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Category(String name, String type, List<Transaction> transactions, List<Budget> budgets) {
        this.name = name;
        this.type = type;
        this.transactions = transactions;
        this.budgets = budgets;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public List<Transaction> getTransactions() { return transactions; }
    public void setTransactions(List<Transaction> transactions) { this.transactions = transactions; }

    public List<Budget> getBudgets() { return budgets; }
    public void setBudgets(List<Budget> budgets) { this.budgets = budgets; }
}
