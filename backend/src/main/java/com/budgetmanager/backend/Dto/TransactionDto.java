package com.budgetmanager.backend.Dto;

import com.budgetmanager.backend.Models.Transaction;

import java.time.LocalDate;

public record TransactionDto () {

        private  static Double montant;
        private static  LocalDate date;
        private static  String description;
        private static String type;
        private static Long categoryId;


        public Double getMontant() {
            return montant;
        }

        public void setMontant(Double montant) {
            this.montant = montant;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Long getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Long categoryId) {
            this.categoryId = categoryId;
        }
    }


