package com.flowledger.core.controllers;

import com.flowledger.core.models.Category;
import com.flowledger.core.services.CategoryService;

import java.util.ArrayList;

public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService service){
        categoryService = service;
    }

    public ArrayList<Category> getAllCategories() {
        return categoryService.getCategories();
    }

    public boolean createCategory(String categoryName) {
        if(categoryService.getOrCreate(categoryName) == null){
            return false;
        }
        return true;
    }
}
