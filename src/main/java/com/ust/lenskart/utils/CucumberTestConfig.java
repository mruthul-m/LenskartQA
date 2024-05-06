package com.ust.lenskart.utils;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/cucumberconfig.properties")
public interface CucumberTestConfig extends Config{

    @Key("BOOKING_NAME")
    @DefaultValue("Kishore")
    String userName();

    @Key("BOOKING_NUMBER")
    @DefaultValue("7890234122")
    String getNumber();

    @Key("PRODUCT")
    String getProductName();
    
    @Key("BASE_URL")
    String getUrl();

}
