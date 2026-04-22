package com.flowledger.app;

public class Main{
    public static void main(String[] args) {
        ConsoleUI console = new ConsoleUI();
        boolean running = true;
        while(running){
            running = console.start();
        }
    }
}