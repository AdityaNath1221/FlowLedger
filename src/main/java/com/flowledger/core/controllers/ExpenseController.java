package com.flowledger.core.controllers;

import com.flowledger.core.models.Category;
import com.flowledger.core.models.Expense;
import com.flowledger.core.services.ExpenseService;

import java.time.LocalDate;
import java.util.ArrayList;

public class ExpenseController {
    private final ExpenseService expenseService;
    public ExpenseController(ExpenseService service){
        expenseService = service;
    }

    public boolean addExpense(double amount, Category category, LocalDate date, String description) {
        boolean status = expenseService.addExpense(amount, category, date, description);
        if(status){
            return true;
        }
        return false;
    }

    public ArrayList<Expense> getAllExpenses() {
        return expenseService.getAllExpense();
    }

    public boolean deleteExpense(int uID) {
        return expenseService.deleteExpense(uID);
    }

    public boolean editExpense(int uID, double amount, Category category, LocalDate date, String description) {
        return expenseService.editExpense(uID, amount, category, date, description);
    }

    public boolean exist(int ID) {
        return expenseService.exists(ID);
    }
}
