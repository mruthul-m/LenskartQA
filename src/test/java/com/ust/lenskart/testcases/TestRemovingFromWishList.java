package com.ust.lenskart.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ust.lenskart.pages.HomePage;

public class TestRemovingFromWishList extends Hooks{
	HomePage homePage;

	@Test(priority=0)
	public void testEnterSearchBox() {
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.enterSearchBox(testconfig.getValidSearchItem());
		assertEquals(testconfig.getSearchUrl(), homePage.getUrl());
}
	@Test(priority=1,dependsOnMethods = "testEnterSearchBox")
	public void testAddingToWishList() {
		int num = Integer.parseInt(testconfig.getNumberOfProductsToBeWishListed());
		homePage.addProductsToWishList(num);
		assertTrue(homePage.checkProductTitle(num));
	}
	@Test(priority=2,dependsOnMethods = "testAddingToWishList")
    public void testWishList() {
		delay(1);
		int num = Integer.parseInt(testconfig.getNumberOfProductsToBeWishListed());
        for(int i =1;i<=num;i++) {
		homePage.removeProductsFromWishList();
        }
        assertEquals(homePage.getWishListProductCount(),0);
    }
}
