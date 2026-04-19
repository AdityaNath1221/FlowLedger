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
}