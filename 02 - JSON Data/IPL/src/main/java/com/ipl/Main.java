package com.ipl;

import com.ipl.inputhandler.InputHandler;

public class Main {
    public static void main(String[] args) {
        InputHandler.json("src/main/java/com/ipl/content/ipl.json");
        InputHandler.csv("src/main/java/com/ipl/content/ipl.csv");
    }
}