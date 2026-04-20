package com.flowledger.services;

import com.flowledger.models.Expense;

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

public class ExpenseManager{
    ArrayList<Expense> expenses;

    public ExpenseManager(){
        expenses = new ArrayList<Expense>();
    }

    public void addExpense(Expense e){
        expenses.add(e);
    }

    public ArrayList<Expense> getAllExpense(){
        return expenses;
    }

    public boolean editExpense(int ID, double amount, String category, LocalDate date, String description){
        for(Expense e: expenses){
            if(e.getID() == ID){
                e.setDetails(amount, category, date, description);
                return true;
            }
        }
        return false;
    }

    public boolean deleteExpense(int ID){
        return expenses.removeIf(e -> e.getID() == ID);
    }
}