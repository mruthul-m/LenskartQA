package com.ust.lenskart.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ust.lenskart.pages.HomePage;
import com.ust.lenskart.pages.SearchItemPage;

public class TestAddingtoWishList extends Hooks {
	
	//declaring variable of type HomePage 
	HomePage homePage;

	//declaring variable of type SearchItemPage 
	SearchItemPage searchItemPage;

	//Tests whether the driver is navigating to the specified url
	@Test()
	public void testEnterSearchBox() {
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.enterSearchBox(testconfig.getValidSearchItem());
		assertEquals(homePage.getUrl(),testconfig.getSearchUrl());
}
	//Tests adding products to wishlist and whether the correct items are getting added or not
	@Test(dependsOnMethods = "testEnterSearchBox")
	public void testAddingToWishList() {
		searchItemPage = PageFactory.initElements(driver, SearchItemPage.class);
		assertEquals(searchItemPage.getSearchItemText(),testconfig.getValidSearchItem().toUpperCase());
		int num = Integer.parseInt(testconfig.getNumberOfProductsToBeWishListed());
		searchItemPage.addProductsToWishList(num);
		assertTrue(searchItemPage.checkProductTitle(num));
	}
}
