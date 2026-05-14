package com.flowledger.core.storage;

import com.flowledger.core.models.Category;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CategoryStorageService implements StorageService<Category>{
    private final String filePath = "data/categories/categories.csv";
    private File category;

    public CategoryStorageService(){
        File dir = new File("data/categories");
        if(!dir.exists()){
            dir.mkdirs();
        }
        category = new File(filePath);
        if(!category.exists()){
            try{
                category.createNewFile();
            }
            catch(IOException e){
                System.out.print("\n===== Error: Category file could not be created =====\n");
            }
        }
    }

    public ArrayList<Category> fetchData(){
        ArrayList<Category> categories = new ArrayList<Category>();
        try(Scanner scanner = new Scanner(category)){
            while(scanner.hasNextLine()){
                String[] data = scanner.nextLine().split(",");
                for(String s: data){
                    s = s.replace("\"","");
                    Category c = new Category(s);
                    categories.add(c);
                }
            }
        }catch(FileNotFoundException e){
            System.out.print("\n===== Error: File not found =====\n");
        }

        return categories;
    }

    public boolean saveData(ArrayList<Category> data){
        try{
            FileWriter file = new FileWriter(category);
            String line = "";
            for(Category c: data){
                String name = c.getName();
                line = line+"\""+name+"\""+",";
            }
            if(!line.isEmpty()){
                line = line.substring(0, line.length() - 1);
            }
            file.write(line);
            file.close();
            return true;
        }catch(IOException ex){
            System.out.print("\n===== Error: Could not write to file =====\n");
        }
        return false;
    }
}
