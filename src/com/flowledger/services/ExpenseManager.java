package com.flowledger.services;

import com.flowledger.models.Expense;
import com.flowledger.utility.InputHelper;
import java.time.LocalDate;
import java.util.ArrayList;

public class ExpenseManager{
    private ArrayList<Expense> expenses;
    private StorageService storageService;
    private int lastID = 1;

    public ExpenseManager(){
        storageService = new StorageService();
        expenses = storageService.getExpenses();
        lastID = expenses.getLast().getID();
    }

    private Expense fetchExpenseDetails(){
        double amount = InputHelper.getAmount();
        String category = InputHelper.getCategory();
        LocalDate date = InputHelper.getDate();
        String description = InputHelper.getDescription();
        lastID++;
        Expense e = new Expense(lastID, amount, category, date, description);
        return e;
    }

    public boolean exists(int ID){
        for(Expense e: expenses){
            if(e.getID()==ID){
                return true;
            }
        }
        return false;
    }

    public boolean addExpense(){
        Expense e = fetchExpenseDetails();
        boolean flag = expenses.add(e);
        if(!storageService.setExpenses(expenses)){
            System.out.print("\n===== Error: Could not write to file =====\n");
        }
        return flag;
    }

    public ArrayList<Expense> getAllExpense(){
        return expenses;
    }

    public boolean editExpense(int ID, double amount, String category, LocalDate date, String description){
        for(Expense e: expenses){
            if(e.getID() == ID){
                e.setDetails(amount, category, date, description);
                if(!storageService.setExpenses(expenses)){
                    System.out.print("\n===== Error: Could not write to file =====\n");
                }
                return true;
            }
        }
        return false;
    }

    public boolean deleteExpense(int ID){
        boolean flag = expenses.removeIf(e -> e.getID() == ID);
        if(flag){
            if(!storageService.setExpenses(expenses)){
                System.out.print("\n===== Error: Could not write to file =====\n");
            }
        }
        return flag;
    }
}