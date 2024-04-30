package com.ust.lenskart.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ust.lenskart.pages.HomePage;
import com.ust.lenskart.pages.SearchItemPage;

public class TestSortBy extends Hooks {
	HomePage homePage;
	SearchItemPage searchItemPage;

	@Test(priority = 0)
	public void testEnterSearchBox() {
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.enterSearchBox(testconfig.getValidSearchItem());
		assertEquals(homePage.getUrl(),testconfig.getSearchUrl());
	}
	
	@Test(priority = 1)
	public void TsetSortByLowToHigh() {
		searchItemPage = PageFactory.initElements(driver, SearchItemPage.class);
		assertEquals(searchItemPage.getSearchItemText(),testconfig.getValidSearchItem().toUpperCase());
		searchItemPage.setSortLowToHigh();
		delay(2);
		for(int i =0;i<25;i++) {
			searchItemPage.showAllProducts();
		}
		delay(5);
		assertTrue(searchItemPage.checkSortAsc());
	}
	@Test(priority = 2)
	public void TsetSortByHighToLow() {
		searchItemPage.setSortHighToLow();
		delay(2);
		for(int i =0;i<25;i++) {
		searchItemPage.showAllProducts();
		}
		delay(5);
		assertTrue(searchItemPage.checkSortDesc());
	}
}
