package com.ust.lenskart.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ust.lenskart.pages.HomePage;
import com.ust.lenskart.pages.SearchItemPage;

public class TestRemovingFromWishList extends Hooks{
	
	//declaring variable of type HomePage 
	HomePage homePage;
	
	//declaring variable of type SearchItemPage 
	SearchItemPage searchItemPage;

	//Tests entering specified string into searchbox and validates the url
	@Test(priority=0)
	public void testEnterSearchBox() {
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.enterSearchBox(testconfig.getValidSearchItem());
		assertEquals(homePage.getUrl(),testconfig.getSearchUrl());
}
	//Tests adding products to wishlist and whether the correct items are getting added or not
	@Test(priority=1,dependsOnMethods = "testEnterSearchBox")
	public void testAddingToWishList() {
		searchItemPage = PageFactory.initElements(driver, SearchItemPage.class);
		assertEquals(searchItemPage.getSearchItemText(),testconfig.getValidSearchItem().toUpperCase());
		int num = Integer.parseInt(testconfig.getNumberOfProductsToBeWishListed());
		searchItemPage.addProductsToWishList(num);
		assertTrue(searchItemPage.checkProductTitle(num));
	}
	
	//Tests removing products from wishlist one by one and whether the product count in the wishlist finally is 0
	@Test(priority=2,dependsOnMethods = "testAddingToWishList")
    public void testWishList() {
		int num = Integer.parseInt(testconfig.getNumberOfProductsToBeWishListed());
        searchItemPage.removeProductsFromWishList(num);
        assertEquals(searchItemPage.getWishListProductCount(),0);
    }
	
	//Tests adding products to wishlist and whether the correct items are getting added or not
	@Test(priority=3,dependsOnMethods = "testEnterSearchBox")
	public void testAddingToWishListAgain() {
		int num = Integer.parseInt(testconfig.getNumberOfProductsToBeWishListed());
		assertEquals(searchItemPage.getSearchItemText(),testconfig.getValidSearchItem().toUpperCase());
		searchItemPage.addProductsToWishList(num);
		assertTrue(searchItemPage.checkProductTitle(num));
	}
	
	//Tests removing products from wishlist all at once and whether the product count in the wishlist is 0
	@Test(priority=4,dependsOnMethods = "testAddingToWishListAgain")
    public void testWishListAgain() {
		searchItemPage.clickClearList();
		assertEquals(searchItemPage.getWishListProductCount(),0);
	}
}
