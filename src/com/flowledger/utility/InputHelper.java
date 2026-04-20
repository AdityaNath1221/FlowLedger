package com.flowledger.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputHelper {
    private static final Scanner sc = new Scanner(System.in);

    public static int getChoice(){
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

    public static int getID(String msg, int max){
        while(true){
            System.out.print(msg);
            if(sc.hasNextInt()){
                int ID = sc.nextInt();
                sc.nextLine();
                if(ID>0&&ID<=max){
                    return ID;
                }
                else{
                    System.out.print("\n===== Error: Invalid ID =====\n");
                }
            }
            else{
                System.out.print("\n===== Error: Invalid number =====\n");
            }
        }
    }

    public static double getAmount(){
        while(true){
            System.out.print("\nEnter the amount: ");
            if(sc.hasNextDouble()){
                double amount = sc.nextDouble();
                sc.nextLine();
                if(amount>0){
                    return amount;
                }
                else{
                    System.out.print("\n===== Error: Invalid amount =====\n");
                }
            }
            else{
                System.out.print("\n===== Error: Invalid decimal number =====\n");
                sc.nextLine();
            }
        }
    }

    public static String getCategory(){
        while(true){
            System.out.print("\nEnter the category: ");
            String category = sc.nextLine();
            if(!category.trim().isEmpty()){
                return category;
            }
            else{
                System.out.print("\n===== Error: Category blank =====\n");
            }
        }
    }

    public static String getDescription(){
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

    public static LocalDate getDate(){
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
