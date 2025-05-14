package com.budgetmanager.backend.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Budget {
    @Id
    private int id;
}
