package com.ust.lenskart.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ust.lenskart.pages.HomePage;

public class TestSortBy extends Hooks {
	HomePage homePage;

	@Test(priority = 0)
	public void testEnterSearchBox() {
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.enterSearchBox(testconfig.getValidSearchItem());
		assertEquals(testconfig.getSearchUrl(), homePage.getUrl());
	}
	
	@Test(priority = 1)
	public void TsetSortByLowToHigh() {
		homePage.setSortLowToHigh();
		delay(2);
		for(int i =0;i<25;i++) {
		homePage.showAllProducts();
		}
		delay(5);
		assertTrue(homePage.checkSortAsc());
	}
	@Test(priority = 2)
	public void TsetSortByHighToLow() {
		homePage.setSortHighToLow();
		delay(2);
		for(int i =0;i<25;i++) {
		homePage.showAllProducts();
		}
		delay(5);
		assertTrue(homePage.checkSortDesc());
	}
}
