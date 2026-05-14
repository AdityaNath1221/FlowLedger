package com.flowledger.core.controllers;

import com.flowledger.core.models.Expense;
import com.flowledger.core.services.AnalyticsService;

import java.util.ArrayList;

public class AnalyticsController {
    private final AnalyticsService analyticsService;

    public AnalyticsController(AnalyticsService service){
        analyticsService = service;
    }

    public double getTotalSpending(ArrayList<Expense> expenses) {
        return analyticsService.getTotalSpending(expenses);
    }
}
