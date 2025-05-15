package com.budgetmanager.backend.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.sql.Date;


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
    @JsonBackReference(value = "budget-category")
    private Category category;


     //constructors

    public Budget() {}

    public Budget(int limitBudget, Date startDate, Date endDate, Category category) {
        this.limitBudget = limitBudget;
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
    }

    //getters && setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLimitBudget() {
        return limitBudget;
    }

    public void setLimitBudget(int limitBudget) {
        this.limitBudget = limitBudget;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
