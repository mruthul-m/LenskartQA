package com.ust.lenskart.utils;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:cucumberconfig.properties")
public interface CucumberTestConfig extends Config{

    @Key("USER_NAME")
    @DefaultValue("Kishore")
    String userName();

    @Key("USER_NUMBER")
    @DefaultValue("7890234122")
    String getNumber();

    @Key("PRODUCT")
    String getProductName();

}
