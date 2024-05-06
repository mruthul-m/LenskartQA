package com.ust.lenskart.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ust.lenskart.pages.HomePage;
import com.ust.lenskart.pages.SearchItemPage;

public class TestItemSearch extends Hooks {
	
	//declaring variable of type HomePage 
	HomePage homePage;
	
	//declaring variable of type SearchItemPage 
	SearchItemPage searchItemPage;
	
	
	//Tests entering specified string into searchbox and validates the url
	@Test(priority =0)
	public void testEnterSearchBox() {
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.enterSearchBox(testconfig.getValidSearchItem());
		assertEquals(homePage.getUrl(),testconfig.getSearchUrl());
	}
	
	//Tests entering invalid string into searchbox and validates the search text and the error message
	@Test(priority =1)
	public void testInvalidSearchItem() {
        homePage.enterSearchBox(testconfig.getInvalidSearchItem());
		searchItemPage = PageFactory.initElements(driver, SearchItemPage.class);
        assertEquals(searchItemPage.getSearchItemText(),testconfig.getInvalidSearchItem().toUpperCase());
        assertEquals(searchItemPage.getinvalidSearchItemText(),testconfig.getInvalidSearchMessage());
    }
}
