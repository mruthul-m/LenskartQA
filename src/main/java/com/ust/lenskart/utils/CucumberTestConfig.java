package com.ust.lenskart.utils;

import org.aeonbits.owner.Config;

// This interface defines methods to access configuration properties for Cucumber tests
@Config.Sources("classpath:config/cucumberconfig.properties")
public interface CucumberTestConfig extends Config {

    // Method to get the booking user name
    @Key("BOOKING_NAME")
    @DefaultValue("Kishore")
    String userName();

    // Method to get the booking number
    @Key("BOOKING_NUMBER")
    @DefaultValue("7890234122")
    String getNumber();

    // Method to get the product name
    @Key("PRODUCT")
    String getProductName();

    // Method to get the base URL
    @Key("BASE_URL")
    String getUrl();

}
