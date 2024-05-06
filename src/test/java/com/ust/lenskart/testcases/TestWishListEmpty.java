package com.ust.lenskart.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ust.lenskart.pages.HomePage;
import com.ust.lenskart.pages.SearchItemPage;

public class TestWishListEmpty extends Hooks {
	
	//declaring variable of type HomePage 
	HomePage homePage;
	
	//declaring variable of type SearchItemPage 
	SearchItemPage searchItemPage;

	//Tests entering specified string into searchbox and validates the url
	@Test()
	public void testEnterSearchBox() {
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.enterSearchBox(testconfig.getValidSearchItem());
		assertEquals(homePage.getUrl(),testconfig.getSearchUrl());
}
	
	//Tests clicking on wishlist button and validates the wishlist is empty
	@Test(dependsOnMethods = "testEnterSearchBox")
	public void testWishList() {
		searchItemPage = PageFactory.initElements(driver, SearchItemPage.class);
		assertEquals(searchItemPage.getSearchItemText(),testconfig.getValidSearchItem().toUpperCase());
		searchItemPage.clickWishList();
		assertTrue(searchItemPage.isWishListBoxVisible());
		assertEquals(searchItemPage.getWishListProductCount(),0);
	}
}
