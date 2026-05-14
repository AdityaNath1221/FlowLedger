package com.flowledger.ui.console;

import com.flowledger.core.models.Category;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputHelper {
    private final Scanner sc;

    public InputHelper(){
        sc = new Scanner(System.in);
    }

    public void close(){
        sc.close();
    }

    public int getChoice(){
        while(true){
            System.out.print("\nEnter choice: ");
            if(sc.hasNextInt()){
                int ch = sc.nextInt();
                sc.nextLine();
                return ch;
            }
            else{
                System.out.print("\n===== Error: Invalid number =====\n");
                sc.nextLine();
            }
        }
    }

    public int getID(String msg){
        while(true){
            System.out.print(msg);
            if(sc.hasNextInt()){
                int ID = sc.nextInt();
                sc.nextLine();
                if(ID>0){
                    return ID;
                }
                else{
                    System.out.print("\n===== Error: Invalid ID =====\n");
                }
            }
            else{
                System.out.print("\n===== Error: Invalid number =====\n");
                sc.nextLine();
            }
        }
    }

    public double getAmount(){
        while(true){
            System.out.print("\nEnter the amount: ");
            String input = sc.nextLine().trim();
            if(input.isEmpty()){
                System.out.print("\n===== Error: Amount blank =====\n");
            }
            else{
                try{
                    double amount = Double.parseDouble(input);
                    if(amount>0){
                        return amount;
                    }
                    else{
                        System.out.print("\n===== Error: Invalid amount =====\n");
                    }
                }catch(NumberFormatException e){
                    System.out.print("\n===== Error: Invalid decimal number =====\n");
                }
            }
        }
    }

    public Category getCategory(ArrayList<Category> categories){
        while(true){
            System.out.print("\n===== AVAILABLE CATEGORIES =====\n");
            for(Category c: categories){
                System.out.print("\n"+c.getName());
            }
            System.out.print("\n\nEnter the category: ");
            String category = sc.nextLine();
            if(!category.trim().isEmpty() && (category.split(" ").length == 1)){
                category = category.substring(0,1).toUpperCase() + category.substring(1).toLowerCase();
                for(Category c: categories){
                    if(c.getName().equals(category)){
                        return c;
                    }
                }
                System.out.print("\n===== Error: Invalid category =====\n");
            }
            else{
                System.out.print("\n===== Error: Category blank =====\n");
            }
        }
    }

    public String getNewCategory(){
        while(true){
            System.out.print("\nEnter the name of new category: ");
            String category = sc.nextLine();
            if(!category.trim().isEmpty()){
                return category;
            }
            else{
                System.out.print("\n===== Error: Category blank =====\n");
            }
        }
    }

    public String getDescription(){
        while(true){
            System.out.print("\nEnter the description: ");
            String description = sc.nextLine();
            if(!description.trim().isEmpty()){
                return description;
            }
            else{
                System.out.print("\n===== Note: Description is blank =====\n");
                return description;
            }
        }
    }

    public LocalDate getDate(){
        DateTimeFormatter[] formats = new DateTimeFormatter[] {
            DateTimeFormatter.ofPattern("d-M-yyyy"),
            DateTimeFormatter.ofPattern("d-M-yy"),
            DateTimeFormatter.ofPattern("d/M/yyyy"),
            DateTimeFormatter.ofPattern("d/M/yy"),
            DateTimeFormatter.ofPattern("yyyy-M-d"),
            DateTimeFormatter.ofPattern("yy-M-d")
        };
        while(true){
            System.out.print("\nEnter the date (Leave blank for current date): ");
            String input = sc.nextLine();

            if(input.trim().isEmpty()){
                return LocalDate.now();
            }
            else{
                for(DateTimeFormatter format: formats){
                    try{
                        return LocalDate.parse(input, format);
                    }
                    catch(DateTimeParseException ignored){}
                }

                System.out.print("\n===== Error: Invalid Date Format =====\n");
            }
        }
    }
}
