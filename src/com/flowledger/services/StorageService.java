package com.flowledger.services;

import com.flowledger.models.Expense;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class StorageService {
    private final String filePath = "ledgers/ledger.csv";
    private File ledger;

    public StorageService(){
        File dir = new File("ledgers");
        if(!dir.exists()){
            dir.mkdir();
        }
        ledger = new File(filePath);
        if(!ledger.exists()){
            try{
                ledger.createNewFile();
            }
            catch(IOException e){
                System.out.print("\n===== Error: File could not be created =====\n");
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
                String[] data = scanner.nextLine().split(",");
                if(data.length==5){
                    int ID = Integer.parseInt(data[0]);
                    double amount = Double.parseDouble(data[1]);
                    String category = data[2];
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

    public boolean setExpenses(ArrayList<Expense> expenses){
        try{
            FileWriter file = new FileWriter(ledger);
            for(Expense e: expenses){
                int ID = e.getID();
                double amount = e.getAmount();
                String category = e.getCategory();
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
}
