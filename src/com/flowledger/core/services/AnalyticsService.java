package com.flowledger.core.services;

import com.flowledger.core.models.Expense;

import java.util.ArrayList;

public class AnalyticsService {
    public double getTotalSpending(ArrayList<Expense> expenses){
        double totalAmount = 0;
        for(Expense e: expenses){
            totalAmount+=e.getAmount();
        }
        return totalAmount;
    }
}
