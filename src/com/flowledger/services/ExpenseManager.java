package com.flowledger.services;

import com.flowledger.models.Expense;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class ExpenseManager{
    ArrayList<Expense> expenses = new ArrayList<Expense>();

    public void addExpense(Expense e){
        expenses.add(e);
    }

    public ArrayList<String> getAllExpense(){
        ArrayList<String> allExpenses = new ArrayList<String>();
        for(Expense e: expenses){
            allExpenses.add(e.getExpenseDetails());
        }
        return allExpenses;
    }

    public void editExpense(){
        System.out.println("\nEdit Expense\n");
    }

    public void deleteExpense(){
        System.out.println("\nDelete Expense\n");
    }
}