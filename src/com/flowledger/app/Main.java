package com.flowledger.app;

import com.flowledger.core.controllers.AnalyticsController;
import com.flowledger.core.controllers.CategoryController;
import com.flowledger.core.controllers.ExpenseController;
import com.flowledger.core.services.AnalyticsService;
import com.flowledger.core.services.CategoryService;
import com.flowledger.core.services.ExpenseService;
import com.flowledger.core.storage.CategoryStorageService;
import com.flowledger.core.storage.ExpenseStorageService;
import com.flowledger.ui.console.ConsoleUI;

public class Main{
    private final CategoryStorageService categoryStorageService;
    private final ExpenseStorageService expenseStorageService;
    private final CategoryService categoryService;
    private final ExpenseService expenseService;
    private final AnalyticsService analyticsService;
    private final ExpenseController expenseController;
    private final CategoryController categoryController;
    private final AnalyticsController analyticsController;

    public Main(){
        categoryStorageService = new CategoryStorageService();
        expenseStorageService = new ExpenseStorageService();
        categoryService = new CategoryService(categoryStorageService);
        expenseService = new ExpenseService(categoryService, expenseStorageService);
        analyticsService = new AnalyticsService();
        expenseController = new ExpenseController(expenseService);
        categoryController = new CategoryController(categoryService);
        analyticsController = new AnalyticsController(analyticsService);
    }

    public void run(){
        ConsoleUI console = new ConsoleUI(this.expenseController, this.categoryController, this.analyticsController);
        while(console.start());
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }
}