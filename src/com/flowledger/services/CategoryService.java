package com.flowledger.services;

import com.flowledger.models.Category;
import java.util.ArrayList;

public class CategoryService {
    private ArrayList<Category> categories;
    private StorageService storageService;

    public CategoryService(){
        storageService = new StorageService();
        categories = storageService.getCategories();
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
            storageService.saveCategories(categories);
            return c;
        }
        else{
            return null;
        }
    }


}