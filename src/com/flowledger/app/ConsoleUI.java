package com.flowledger.app;

import com.flowledger.services.ExpenseManager;
import com.flowledger.models.Expense;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.lang.NumberFormatException;

public class ConsoleUI{
    private static ExpenseManager expenseManager;
    private static Scanner sc;
    private static int ID = 1;

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
        return e;
    }

    public boolean start(){
        System.out.println("\n===== Expense Tracker Console UI =====\n");
        while(true){
            System.out.println();
            System.out.println("Enter 1 to Add a new Expense.");
            System.out.println("Enter 2 to view all Expenses.");
            System.out.println("Enter -1 to exit.");
            System.out.print("\nEnter Choice: ");
            String choice = sc.nextLine();

            switch(choice){
                case "-1":
                    return false;

                case "1":
                    Expense e = fetchExpenseDetails();
                    expenseManager.addExpense(e);
                    break;

                case "2":
                    ArrayList<String> expenses = expenseManager.getAllExpense();
                    System.out.println("\n===== EXPENSES =====\n");
                    for(String expense: expenses){
                        String[] arr = expense.split("\\|");
                        System.out.print("\nAmount: "+arr[0]+"\n");
                        System.out.print("\nCategory: "+arr[1]+"\n");
                        System.out.print("\nDate: "+arr[2]+"\n");
                        System.out.print("\nDescription: "+arr[3]+"\n");
                    }
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}