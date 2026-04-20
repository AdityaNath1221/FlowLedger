package com.flowledger.models;
import java.time.LocalDate;

public class Expense{
    private int ID;
    private double amount;
    private String category;
    private LocalDate date;
    private String description;

    public Expense(int ID, double amount, String category, LocalDate date, String description){
        this.ID = ID;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
    }

    // public String getExpenseDetails(){
    //     String details = this.amount + "|" + this.category + "|" + this.date + "|" + this.description;
    //     return details;
    // }

    public String toString(){
        String str = "\n===== ID#"+ID+" =====\n"+"\nAmount: "+amount+"\n\nCategory: "+category+"\n\nDate: "+date+"\n\nDescription: "+description;
        return str;
    }

    public int getID(){
        return ID;
    }

    public void setDetails(double amount, String category, LocalDate date, String description){
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
    }
}