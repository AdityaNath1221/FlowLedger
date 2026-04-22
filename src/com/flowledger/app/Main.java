package com.flowledger.app;

import java.io.File;

public class Main{
    public static void main(String[] args) {
        File dir = new File("ledgers");
        if(!dir.exists()){
            dir.mkdir();
        }
        ConsoleUI console = new ConsoleUI();
        boolean running = true;
        while(running){
            running = console.start();
        }
    }
}