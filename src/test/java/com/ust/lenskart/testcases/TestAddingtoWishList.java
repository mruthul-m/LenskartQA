package com.ust.lenskart.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ust.lenskart.pages.HomePage;

public class TestAddingtoWishList extends Hooks {
	HomePage homePage;
	
	@Test()
	public void testEnterSearchBox() {
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.enterSearchBox(testconfig.getValidSearchItem());
		assertEquals(testconfig.getSearchUrl(), homePage.getUrl());
}
	@Test(dependsOnMethods = "testEnterSearchBox")
	public void testAssingToWishList() {
		int num = Integer.parseInt(testconfig.getNumberOfProductsToBeWishListed());
		homePage.addProductsToWishList(num);
		assertTrue(homePage.checkProductTitle(num));
	}
}
