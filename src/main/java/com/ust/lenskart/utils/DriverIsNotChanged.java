package com.ust.lenskart.utils;

// Custom exception class for indicating that the WebDriver could not be changed to a different window
public class DriverIsNotChanged extends Exception {
    
    // Constructor with a message parameter
    public DriverIsNotChanged(String str) {
        super(str);
    }
}

