package com.flowledger.app;

import com.flowledger.models.Expense;
import com.flowledger.services.ExpenseManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUI{
    private static ExpenseManager expenseManager;
    private static Scanner sc;
    private static int ID = 1;
    private static Expense e;
    private static ArrayList<Expense> expenses;

    public ConsoleUI(){
        expenseManager = new ExpenseManager();
        sc = new Scanner(System.in);
    }

    private static Expense fetchExpenseDetails(){
        System.out.println();
        System.out.print("Enter the amount: ");
        double amount = Double.parseDouble(sc.nextLine());
        System.out.print("Enter the category: ");
        String category = sc.nextLine();
        System.out.print("Enter the date(YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(sc.nextLine());
        System.out.print("Enter the description: ");
        String description = sc.nextLine();
        System.out.println();
        Expense e = new Expense(ID, amount, category, date, description);
        ID++;
        return e;
    }

    public boolean start(){
        System.out.println("\n===== Expense Tracker Console UI =====\n");
        while(true){
            System.out.println();
            System.out.println("Enter 1 to Add a new Expense.");
            System.out.println("Enter 2 to view all Expenses.");
            System.out.println("Enter 3 to delete an Expense.");
            System.out.println("Enter 4 to edit an Expense.");
            System.out.println("Enter -1 to exit.");
            System.out.print("\nEnter Choice: ");
            String choice = sc.nextLine();

            switch(choice){
                case "-1":
                    return false;

                case "1":
                    e = fetchExpenseDetails();
                    expenseManager.addExpense(e);
                    break;

                case "2":
                    expenses = expenseManager.getAllExpense();
                    System.out.println("\n===== EXPENSES =====\n");
                    for(Expense e: expenses){
                        System.out.println(e);
                    }
                    break;

                case "3":
                    expenses = expenseManager.getAllExpense();
                    for(Expense e: expenses){
                        System.out.println(e);
                    }
                    System.out.print("\nEnter the ID of expense you want to delete: ");
                    int uID = Integer.parseInt(sc.nextLine());
                    expenseManager.deleteExpense(uID);
                    break;

                case "4":
                    expenses = expenseManager.getAllExpense();
                    for(Expense e: expenses){
                        System.out.println(e);
                    }
                    System.out.print("\nEnter the ID of expense you want to edit: ");
                    uID = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter the amount: ");
                    double amount = Double.parseDouble(sc.nextLine());
                    System.out.print("Enter the category: ");
                    String category = sc.nextLine();
                    System.out.print("Enter the date(YYYY-MM-DD): ");
                    LocalDate date = LocalDate.parse(sc.nextLine());
                    System.out.print("Enter the description: ");
                    String description = sc.nextLine();
                    System.out.println();
                    expenseManager.editExpense(uID, amount, category, date, description);
                    break;


                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}