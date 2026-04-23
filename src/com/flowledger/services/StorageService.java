package com.flowledger.services;

import com.flowledger.models.Expense;
import com.flowledger.models.Category;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

//Can be made into an interface.

public class StorageService {
    private final String ledgerFilePath = "data/ledgers/ledger.csv";
    private final String categoryFilePath = "data/categories/categories.csv";
    private File ledger;
    private File category;

    public StorageService(){
        File ledgerDir = new File("data/ledgers");
        File categoryDir = new File("data/categories");
        if(!ledgerDir.exists()){
            ledgerDir.mkdirs();
        }
        ledger = new File(ledgerFilePath);
        if(!ledger.exists()){
            try{
                ledger.createNewFile();
            }
            catch(IOException e){
                System.out.print("\n===== Error: Ledger file could not be created =====\n");
            }
        }
        if(!categoryDir.exists()){
            categoryDir.mkdirs();
        }
        category = new File(categoryFilePath);
        if(!category.exists()){
            try{
                category.createNewFile();
            }
            catch(IOException e){
                System.out.print("\n===== Error: Category file could not be created =====\n");
            }
        }
    }

    private LocalDate convertStrToDate(String input){
        DateTimeFormatter[] formats = new DateTimeFormatter[] {
            DateTimeFormatter.ofPattern("d-M-yyyy"),
            DateTimeFormatter.ofPattern("d-M-yy"),
            DateTimeFormatter.ofPattern("d/M/yyyy"),
            DateTimeFormatter.ofPattern("d/M/yy"),
            DateTimeFormatter.ofPattern("yyyy-M-d"),
            DateTimeFormatter.ofPattern("yy-M-d")
        };
        LocalDate date = LocalDate.now();
        for(DateTimeFormatter format: formats){
            try{
                date = LocalDate.parse(input, format);
                return date;
            }
            catch(DateTimeParseException ignored){}
        }
        return date;
    }

    public ArrayList<Expense> getExpenses(){
        ArrayList<Expense> expenses = new ArrayList<Expense>();
        Expense expense;
        try(Scanner scanner = new Scanner(ledger)){
            while(scanner.hasNextLine()){
                String[] data = scanner.nextLine().split(",", 5);
                if(data.length==5){
                    int ID = Integer.parseInt(data[0]);
                    double amount = Double.parseDouble(data[1]);
                    Category category = new Category(data[2]);
                    LocalDate date = convertStrToDate(data[3]);
                    String description = data[4].replace("\"","");
                    expense = new Expense(ID, amount, category, date, description);
                    expenses.add(expense);
                }
            }
        }catch(FileNotFoundException e){
            System.out.print("\n===== Error: File not found =====\n");
        }

        return expenses;
    }

    public boolean saveExpenses(ArrayList<Expense> expenses){
        try{
            FileWriter file = new FileWriter(ledger);
            for(Expense e: expenses){
                int ID = e.getID();
                double amount = e.getAmount();
                String category = e.getCategory().getName();
                LocalDate date = e.getDate();
                String description = e.getDescription();
                String line = ID+","+amount+","+category+","+date+",\""+description+"\"\n";
                file.write(line);
            }
            file.close();
            return true;
        }catch(IOException ex){
            System.out.print("\n===== Error: Could not write to file =====\n");
        }
        return false;
    }

    public ArrayList<Category> getCategories(){
        ArrayList<Category> categories = new ArrayList<Category>();
        try(Scanner scanner = new Scanner(category)){
            while(scanner.hasNextLine()){
                String[] data = scanner.nextLine().split(",");
                for(String s: data){
                    s = s.replace("\"","");
                    Category c = new Category(s);
                    categories.add(c);
                }
            }
        }catch(FileNotFoundException e){
            System.out.print("\n===== Error: File not found =====\n");
        }

        return categories;
    }

    public boolean saveCategories(ArrayList<Category> categories){
        try{
            FileWriter file = new FileWriter(category);
            String line = "";
            for(Category c: categories){
                String name = c.getName();
                line = line+"\""+name+"\""+",";
            }
            if(line.length() > 0){
                line = line.substring(0, line.length() - 1);
            }
            file.write(line);
            file.close();
            return true;
        }catch(IOException ex){
            System.out.print("\n===== Error: Could not write to file =====\n");
        }
        return false;
    }
}
