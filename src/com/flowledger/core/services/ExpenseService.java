package com.flowledger.core.services;

import com.flowledger.core.models.Category;
import com.flowledger.core.models.Expense;
import com.flowledger.core.storage.ExpenseStorageService;

import java.time.LocalDate;
import java.util.ArrayList;

public class ExpenseService {
    private ArrayList<Expense> expenses;
    private ArrayList<Category> categories;
    private ExpenseStorageService storageService;
    private CategoryService categoryService;
    private int lastID;

    public ExpenseService(CategoryService categoryService, ExpenseStorageService storageService){
        this.storageService = storageService;
        this.categoryService = categoryService;
        expenses = storageService.fetchData();
//        categories = categoryService.getCategories();
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

    public boolean addExpense(double amount, Category category, LocalDate date, String description){
        lastID++;
        Expense e = new Expense(lastID, amount, category, date, description);
        boolean flag = expenses.add(e);
        if(!storageService.saveData(expenses)){
            System.out.print("\n===== Error: Could not write to file =====\n");
        }
        return flag;
    }

    public ArrayList<Expense> getAllExpense(){
        return expenses;
    }

    public boolean editExpense(int ID, double amount, Category category, LocalDate date, String description){
        for(Expense e: expenses){
            if(e.getID() == ID){
                e.setDetails(amount, category, date, description);
                if(!storageService.saveData(expenses)){
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
            if(!storageService.saveData(expenses)){
                System.out.print("\n===== Error: Could not write to file =====\n");
            }
        }
        return flag;
    }
}