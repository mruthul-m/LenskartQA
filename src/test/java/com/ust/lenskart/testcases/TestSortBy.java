package com.ust.lenskart.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ust.lenskart.pages.HomePage;
import com.ust.lenskart.pages.SearchItemPage;

public class TestSortBy extends Hooks {
	
	//declaring variable of type HomePage 
	HomePage homePage;
	
	//declaring variable of type SearchItemPage 
	SearchItemPage searchItemPage;

	//Tests entering specified string into searchbox and validates the url
	@Test(priority = 0)
	public void testEnterSearchBox() {
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.enterSearchBox(testconfig.getValidSearchItem());
		assertEquals(homePage.getUrl(),testconfig.getSearchUrl());
	}
	
	//Tests clicking on sort by low to high and validates the sort order
	@Test(priority = 1)
	public void TsetSortByLowToHigh() {
		searchItemPage = PageFactory.initElements(driver, SearchItemPage.class);
		assertEquals(searchItemPage.getSearchItemText(),testconfig.getValidSearchItem().toUpperCase());
		searchItemPage.setSortLowToHigh();
		delay(2);
		searchItemPage.showAllProducts();
		assertTrue(searchItemPage.checkSortAsc());
	}
	
	//Tests clicking on sort by high to low and validates the sort order
	@Test(priority = 2)
	public void TsetSortByHighToLow() {
		searchItemPage.setSortHighToLow();
		delay(2);
		searchItemPage.showAllProducts();
		assertTrue(searchItemPage.checkSortDesc());
	}
}
