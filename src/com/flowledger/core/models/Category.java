package com.flowledger.core.models;

public class Category {
    private String categoryName;

    public Category(String name){
        categoryName = name;
    }

    public String getName(){
        return categoryName;
    }
}
