package com.ust.lenskart.utils;

import org.aeonbits.owner.Config;


/**
 * This interface defines the configuration properties used by the Lenskart QA test automation framework.
 * 
 * The configuration values are loaded from a file named `config.properties` located in the classpath.
 */
@Config.Sources("classpath:config/config.properties")
public interface TestConfig extends Config {

	/**
	 * Retrieves the browser name to be used for test execution.
	 * 
	 *  - Default value: "edge" (If not specified in the config file)
	 * @return The browser name as a String.
	 */
	@Key("BROWSER")
	@DefaultValue("edge")
	String getBrowser();
	
	/**
	 * Retrieves the base URL of the Lenskart website.
	 * 
	 * @return The base URL as a String.
	 */
	@Key("BASE_URL")
	String getUrl();
	
	@Key("NUMBER_OF_PRODUCTS_TO_BE_WISHLISTED")
	String getNumberOfProductsToBeWishListed();
	
	@Key("VALID_SEARCH_ITEM")
	String getValidSearchItem();
	
	@Key("INVALID_SEARCH_MESSAGE")
	String getInvalidSearchMessage();
	
	@Key("SEARCH_URL")
	String getSearchUrl();

	@Key("SHEET_NAME")
	String getSheetName();

	@Key("INVALID_SEARCH_ITEM")
	String getInvalidSearchItem();
	
}
