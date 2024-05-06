package com.ust.lenskart.utils;

import org.aeonbits.owner.Config;


//Interface for Test Configuration properties.
@Config.Sources("classpath:config/config.properties")
public interface TestConfig extends Config {

    //Gets the browser to be used for the tests.	
    @Key("BROWSER")
    //Default: "edge"   
    @DefaultValue("edge")
    String getBrowser();
    
    //Gets the base URL of the Lenskart website.
    @Key("BASE_URL")
    String getUrl();
    
    //Gets the number of products to add to the wishlist during tests.
    @Key("NUMBER_OF_PRODUCTS_TO_BE_WISHLISTED")
    String getNumberOfProductsToBeWishListed();
    
    //Gets a valid search item for Lenskart products (e.g., "sunglasses").
    @Key("VALID_SEARCH_ITEM")
    String getValidSearchItem();
    
    //Gets the expected message when performing an invalid search.
    @Key("INVALID_SEARCH_MESSAGE")
    String getInvalidSearchMessage();
    
    //Gets the URL used for search functionality. 
    @Key("SEARCH_URL")
    String getSearchUrl();

    //Gets the name of the spreadsheet containing test data.  
    @Key("SHEET_NAME")
    String getSheetName();

    //Gets an invalid search item for Lenskart products.
    @Key("INVALID_SEARCH_ITEM")
    String getInvalidSearchItem();
}
