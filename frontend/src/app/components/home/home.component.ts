import { Component, OnInit } from '@angular/core';

import { BudgetService } from "../../service/budget.service";

import { CategoryService, Category } from '../../service/category.service';
import { TransactionService, Transaction } from '../../service/transaction.service';
import {Budget} from '../../service/budget.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  imports: [CommonModule],
})
export class HomeComponent implements OnInit {

  budgets: Budget[] = [];
  categories: Category[] = [];
  transactions: Transaction[] = [];

  constructor(
    private budgetService: BudgetService,
    private categoryService: CategoryService,
    private transactionService: TransactionService
  ) {}

  ngOnInit(): void {
    this.loadBudgets();
    this.loadCategories();
    this.loadTransactions();
  }

  loadBudgets() {
    this.budgetService.getBudget().subscribe((data) => {
      this.budgets = data;
    });
  }

  loadCategories() {
    this.categoryService.getCategory().subscribe((data) => {
      this.categories = data;
    });
  }

  loadTransactions() {
    this.transactionService.getTransactions().subscribe((data) => {
      this.transactions = data;
    });
  }
}
