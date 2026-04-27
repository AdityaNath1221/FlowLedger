package com.flowledger.core.models;
import java.time.LocalDate;

public class Expense{
    private int ID;
    private double amount;
    private Category category;
    private LocalDate date;
    private String description;

    public Expense(int ID, double amount, Category category, LocalDate date, String description){
        this.ID = ID;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
    }

    public String toString(){
        return "\n===== ID#"+ID+" =====\n"+"\nAmount: "+amount+"\nCategory: "+category.getName()+"\nDate: "+date+"\nDescription: "+description+"\n";
    }

    public int getID(){
        return ID;
    }
    public double getAmount(){
        return amount;
    }
    public Category getCategory(){
        return category;
    }
    public LocalDate getDate(){
        return date;
    }
    public String getDescription(){
        return description;
    }

    public void setDetails(double amount, Category category, LocalDate date, String description){
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
    }
}