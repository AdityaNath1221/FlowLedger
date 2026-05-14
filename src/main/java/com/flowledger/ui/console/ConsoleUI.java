package com.flowledger.ui.console;

import com.flowledger.core.controllers.AnalyticsController;
import com.flowledger.core.controllers.CategoryController;
import com.flowledger.core.controllers.ExpenseController;
import com.flowledger.core.models.Category;
import com.flowledger.core.models.Expense;

import java.time.LocalDate;
import java.util.ArrayList;

public class ConsoleUI{
    private final ExpenseController expenseController;
    private final CategoryController categoryController;
    private final AnalyticsController analyticsController;
    private final InputHelper inputHelper;

    public ConsoleUI(ExpenseController expenseController, CategoryController categoryController, AnalyticsController analyticsController){
        this.expenseController = expenseController;
        this.categoryController = categoryController;
        this.analyticsController = analyticsController;
        inputHelper = new InputHelper();
    }

    public boolean start(){
        System.out.print("\n===== Expense Tracker Console UI =====\n");
        double amount;
        LocalDate date;
        Category category;
        String description;
        int uID;
        while(true){
            ArrayList<Expense> expenses = expenseController.getAllExpenses();
            System.out.print("\nChoice List:");
            System.out.print("\nEnter 1 to Add a new Expense.");
            System.out.print("\nEnter 2 to view all Expenses.");
            System.out.print("\nEnter 3 to delete an Expense.");
            System.out.print("\nEnter 4 to edit an Expense.");
            System.out.print("\nEnter 5 to view all categories.");
            System.out.print("\nEnter 6 to add new category.");
            System.out.print("\nEnter 7 to get total spending.");
            System.out.print("\nEnter -1 to exit.\n");
            int choice = inputHelper.getChoice();

            switch(choice){
                case -1:
                    System.out.print("\n===== Exiting the Program =====\n");
                    inputHelper.close();
                    return false;

                case 1:
                    amount = inputHelper.getAmount();
                    category = inputHelper.getCategory(categoryController.getAllCategories());
                    date = inputHelper.getDate();
                    description = inputHelper.getDescription();
                    if(expenseController.addExpense(amount, category, date, description)){
                        System.out.print("\n===== Expense added successfully =====\n");
                    }
                    else{
                        System.out.print("\n===== Expense could not be added =====\n");
                    }
                    break;

                case 2:
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
                    if(!expenses.isEmpty()){
                        System.out.print("\n===== EXPENSES =====\n");
                        for(Expense e: expenses){
                            System.out.print(e);
                        }
                        System.out.print("\n===== EXPENSES =====\n");
                        uID = inputHelper.getID("\nEnter the ID of expense you want to delete: ");
                        if(expenseController.deleteExpense(uID)){
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
                    if(!expenses.isEmpty()){
                        System.out.print("\n===== EXPENSES =====\n");
                        for(Expense e: expenses){
                            System.out.println(e);
                        }
                        System.out.print("\n===== EXPENSES =====\n");
                        uID = inputHelper.getID("\nEnter the ID of expense you want to edit: ");
                        if(expenseController.exist(uID)){
                            amount = inputHelper.getAmount();
                            category = inputHelper.getCategory(categoryController.getAllCategories());
                            date = inputHelper.getDate();
                            description = inputHelper.getDescription();
                            if(expenseController.editExpense(uID, amount, category, date, description)){
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
                    ArrayList<Category> categories = categoryController.getAllCategories();
                    System.out.print("\n===== AVAILABLE CATEGORIES =====\n");
                    for(Category c: categories){
                        System.out.print("\n"+c.getName());
                    }
                    System.out.println();
                    System.out.print("\n===== AVAILABLE CATEGORIES =====\n");
                    break;

                case 6:
                    String newCategory = inputHelper.getNewCategory();
                    if(categoryController.createCategory(newCategory)){
                        System.out.print("\n===== Error: Category already exists =====\n");
                    }
                    break;

                case 7:
                    if(expenses.isEmpty()){
                        System.out.print("\n===== No Expenses Found =====\n");
                    }
                    else{
                        double totalAmount = analyticsController.getTotalSpending(expenses);
                        System.out.print("\nTotal Spending: "+totalAmount+"\n");
                    }
                    break;

                default:
                    System.out.print("\n===== Error: Invalid choice =====\n");
                    break;
            }
        }
    }
}