package com.ust.lenskart.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ust.lenskart.pages.HomePage;
import com.ust.lenskart.pages.SearchItemPage;

public class TestAddingtoWishList extends Hooks {
	HomePage homePage;
	SearchItemPage searchItemPage;
	
	@Test()
	public void testEnterSearchBox() {
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.enterSearchBox(testconfig.getValidSearchItem());
		assertEquals(homePage.getUrl(),testconfig.getSearchUrl());
}
	@Test(dependsOnMethods = "testEnterSearchBox")
	public void testAssingToWishList() {
		searchItemPage = PageFactory.initElements(driver, SearchItemPage.class);
		assertEquals(searchItemPage.getSearchItemText(),testconfig.getValidSearchItem().toUpperCase());
		int num = Integer.parseInt(testconfig.getNumberOfProductsToBeWishListed());
		searchItemPage.addProductsToWishList(num);
		assertTrue(searchItemPage.checkProductTitle(num));
	}
}
