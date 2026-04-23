package com.flowledger.app;

import com.flowledger.models.Category;
import com.flowledger.models.Expense;
import com.flowledger.services.CategoryService;
import com.flowledger.services.ExpenseManager;
import com.flowledger.utility.InputHelper;
import java.time.LocalDate;
import java.util.ArrayList;

public class ConsoleUI{
    private ExpenseManager expenseManager;
    private CategoryService categoryService;

    public ConsoleUI(){
        categoryService = new CategoryService();
        expenseManager = new ExpenseManager(categoryService);
    }

    public boolean start(){
        System.out.print("\n===== Expense Tracker Console UI =====\n");
        ArrayList<Expense> expenses;
        double amount;
        LocalDate date;
        Category category;
        String description;
        int uID;
        while(true){
            System.out.print("\nChoice List:");
            System.out.print("\nEnter 1 to Add a new Expense.");
            System.out.print("\nEnter 2 to view all Expenses.");
            System.out.print("\nEnter 3 to delete an Expense.");
            System.out.print("\nEnter 4 to edit an Expense.");
            System.out.print("\nEnter 5 to view all categories.");
            System.out.print("\nEnter 6 to add new category.");
            System.out.print("\nEnter -1 to exit.\n");
            int choice = InputHelper.getChoice();

            switch(choice){
                case -1:
                    System.out.print("\n===== Exiting the Program =====\n");
                    InputHelper.close();
                    return false;

                case 1:
                    amount = InputHelper.getAmount();
                    category = InputHelper.getCategory(categoryService.getCategories());
                    date = InputHelper.getDate();
                    description = InputHelper.getDescription();
                    if(expenseManager.addExpense(amount, category, date, description)){
                        System.out.print("\n===== Expense added successfully =====\n");
                    }
                    else{
                        System.out.print("\n===== Expense could not be added =====\n");
                    }
                    break;

                case 2:
                    expenses = expenseManager.getAllExpense();
                    if(!expenses.isEmpty()){
                        System.out.print("\n===== EXPENSES =====\n");
                        for(Expense e: expenses){
                            System.out.print(e);
                        }
                        System.out.print("\n===== EXPENSES =====\n");
                    }
                    else{
                        System.out.print("\n===== No Expenses Found =====\n");
                    }
                    break;

                case 3:
                    expenses = expenseManager.getAllExpense();
                    if(!expenses.isEmpty()){
                        System.out.print("\n===== EXPENSES =====\n");
                        for(Expense e: expenses){
                            System.out.print(e);
                        }
                        System.out.print("\n===== EXPENSES =====\n");
                        uID = InputHelper.getID("\nEnter the ID of expense you want to delete: ");
                        if(expenseManager.deleteExpense(uID)){
                            System.out.print("\n===== Expense deleted successfully =====\n");
                        }
                        else{
                            System.out.print("\n===== Expense not found =====\n");
                        }
                    }
                    else{
                        System.out.print("\n===== No Expenses Found =====\n");
                    }
                    break;

                case 4:
                    expenses = expenseManager.getAllExpense();
                    if(!expenses.isEmpty()){
                        System.out.print("\n===== EXPENSES =====\n");
                        for(Expense e: expenses){
                            System.out.println(e);
                        }
                        System.out.print("\n===== EXPENSES =====\n");
                        uID = InputHelper.getID("\nEnter the ID of expense you want to edit: ");
                        if(expenseManager.exists(uID)){
                            amount = InputHelper.getAmount();
                            category = InputHelper.getCategory(categoryService.getCategories());
                            date = InputHelper.getDate();
                            description = InputHelper.getDescription();
                            if(expenseManager.editExpense(uID, amount, category, date, description)){
                                System.out.print("\n===== Expense edited successfully =====\n");
                            }
                        }
                        else{
                            System.out.print("\n===== Expense not found =====\n");
                        }
                    }
                    else{
                        System.out.print("\n===== No Expenses Found =====\n");
                    }
                    break;

                case 5:
                    ArrayList<Category> categories = categoryService.getCategories();
                    System.out.print("\n===== AVAILABLE CATEGORIES =====\n");
                    for(Category c: categories){
                        System.out.print("\n"+c.getName()+"\n");
                    }
                    System.out.print("\n===== AVAILABLE CATEGORIES =====\n");
                    break;

                case 6:
                    String newCategory = InputHelper.getNewCategory();
                    if(categoryService.createCategory(newCategory)==null){
                        System.out.print("\n===== Error: Category already exists =====\n");
                    }
                    break;

                default:
                    System.out.print("\n===== Error: Invalid choice =====\n");
                    break;
            }
        }
    }
}