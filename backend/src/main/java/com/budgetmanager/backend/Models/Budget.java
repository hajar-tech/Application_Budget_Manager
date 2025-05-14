package com.budgetmanager.backend.Models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int limitBudget;
    private Date startDate;
    private Date endDate;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;




}
