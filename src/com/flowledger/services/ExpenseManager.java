package com.flowledger.services;

import com.flowledger.models.Expense;
import java.time.LocalDate;
import java.util.ArrayList;

public class ExpenseManager{
    private ArrayList<Expense> expenses;
    private StorageService storageService;
    private int lastID;

    public ExpenseManager(){
        storageService = new StorageService();
        expenses = storageService.getExpenses();
        lastID = 0;
        if(expenses.size()>0){
            for(Expense e: expenses){
                if(e.getID() > lastID){
                    lastID = e.getID();
                }
            }
        }
        else{
            lastID = 0;
        }
    }

    public boolean exists(int ID){
        for(Expense e: expenses){
            if(e.getID()==ID){
                return true;
            }
        }
        return false;
    }

    public boolean addExpense(double amount, String category, LocalDate date, String description){
        lastID++;
        Expense e = new Expense(lastID, amount, category, date, description);
        boolean flag = expenses.add(e);
        if(!storageService.saveExpenses(expenses)){
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
                if(!storageService.saveExpenses(expenses)){
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
            if(!storageService.saveExpenses(expenses)){
                System.out.print("\n===== Error: Could not write to file =====\n");
            }
        }
        return flag;
    }
}