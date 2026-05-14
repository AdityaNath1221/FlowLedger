package com.flowledger.core.services;

import com.flowledger.core.models.Category;
import com.flowledger.core.storage.CategoryStorageService;

import java.util.ArrayList;

public class CategoryService {
    private ArrayList<Category> categories;
    private CategoryStorageService storageService;

    public CategoryService(CategoryStorageService service){
        storageService = service;
        categories = storageService.fetchData();
        if(categories.size()==0){
            createCategory("Food");
            createCategory("Healthcare");
            createCategory("Travel");
            createCategory("Entertainment");
            createCategory("Maintenance");
        }
    }

    private String normalize(String name){
        name = name.trim().toLowerCase();
        String normalized = name.substring(0,1).toUpperCase() + name.substring(1);
        return normalized;
    }

    public ArrayList<Category> getCategories(){
        return categories;
    }

    public Category findByName(String name){
        for(Category c: categories){
            if(c.getName().equals(normalize(name))){
                return c;
            }
        }
        return null;
    }

    public Category getOrCreate(String name){
        Category category = findByName(name);
        if(category==null){
            Category c = createCategory(name);
            return c;
        }
        else{
            return category;
        }
    }

    public boolean exists(String name){
        // name = name.lowercass
        for(Category c: categories){
            if(c.getName().toLowerCase().equals(name.toLowerCase())){
                return true;
            }
        }
        return false;
    }

    public Category createCategory(String name){
        if(!exists(name)){
            name = normalize(name);
            Category c = new Category(name);
            categories.add(c);
            storageService.saveData(categories);
            return c;
        }
        else{
            return null;
        }
    }


}