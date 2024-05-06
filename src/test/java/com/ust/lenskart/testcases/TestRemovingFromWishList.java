package com.ust.lenskart.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ust.lenskart.pages.HomePage;
import com.ust.lenskart.pages.SearchItemPage;

public class TestRemovingFromWishList extends Hooks{
	HomePage homePage;
	SearchItemPage searchItemPage;

	@Test(priority=0)
	public void testEnterSearchBox() {
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.enterSearchBox(testconfig.getValidSearchItem());
		assertEquals(homePage.getUrl(),testconfig.getSearchUrl());
}
	@Test(priority=1,dependsOnMethods = "testEnterSearchBox")
	public void testAddingToWishList() {
		searchItemPage = PageFactory.initElements(driver, SearchItemPage.class);
		assertEquals(searchItemPage.getSearchItemText(),testconfig.getValidSearchItem().toUpperCase());
		int num = Integer.parseInt(testconfig.getNumberOfProductsToBeWishListed());
		searchItemPage.addProductsToWishList(num);
		assertTrue(searchItemPage.checkProductTitle(num));
	}
	@Test(priority=2,dependsOnMethods = "testAddingToWishList")
    public void testWishList() {
		int num = Integer.parseInt(testconfig.getNumberOfProductsToBeWishListed());
        searchItemPage.removeProductsFromWishList(num);
        assertEquals(searchItemPage.getWishListProductCount(),0);
    }
	@Test(priority=3,dependsOnMethods = "testEnterSearchBox")
	public void testAddingToWishListAgain() {
		int num = Integer.parseInt(testconfig.getNumberOfProductsToBeWishListed());

		assertEquals(searchItemPage.getSearchItemText(),testconfig.getValidSearchItem().toUpperCase());
		searchItemPage.addProductsToWishList(num);
		assertTrue(searchItemPage.checkProductTitle(num));
	}
	@Test(priority=4,dependsOnMethods = "testAddingToWishListAgain")
    public void testWishListAgain() {
		searchItemPage.clickClearList();
		assertEquals(searchItemPage.getWishListProductCount(),0);
	}
}
