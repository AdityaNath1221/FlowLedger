package com.flowledger.services;

import java.io.File;
import java.io.IOException;

public class StorageService {
    private final String filePath = "ledgers/ledger.csv";
    private File ledger;

    public StorageService(){
        ledger = new File(filePath);
        if(!ledger.exists()){
            try{
                ledger.createNewFile();
            }
            catch(IOException e){
                System.out.print("\n===== Error: File could not be created =====\n");
            }
        }
    }
}
