package com.flowledger.services;

import com.flowledger.models.Expense;
import java.time.LocalDate;
import java.util.ArrayList;

public class ExpenseManager{
    private ArrayList<Expense> expenses;
    private StorageService storageService;

    public ExpenseManager(){
        storageService = new StorageService();
        expenses = storageService.getExpenses();
    }

    public boolean addExpense(Expense e){
        boolean flag = expenses.add(e);
        storageService.setExpenses(expenses);
        return flag;
    }

    public ArrayList<Expense> getAllExpense(){
        return expenses;
    }

    public boolean editExpense(int ID, double amount, String category, LocalDate date, String description){
        for(Expense e: expenses){
            if(e.getID() == ID){
                e.setDetails(amount, category, date, description);
                storageService.setExpenses(expenses);
                return true;
            }
        }
        return false;
    }

    public boolean deleteExpense(int ID){
        boolean flag = expenses.removeIf(e -> e.getID() == ID);
        storageService.setExpenses(expenses);
        return flag;
    }
}