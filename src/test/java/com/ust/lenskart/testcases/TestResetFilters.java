package com.ust.lenskart.testcases;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ust.lenskart.pages.HomePage;
import com.ust.lenskart.pages.SearchItemPage;

public class TestResetFilters extends Hooks {
	HomePage homePage;
	SearchItemPage searchItemPage;

	@Test(priority = 0)
	public void testEnterSearchBox() {
		homePage = PageFactory.initElements(driver, HomePage.class).enterSearchBox(testconfig.getValidSearchItem());
		assertEquals(homePage.getUrl(), testconfig.getSearchUrl());
	}

	@Test(priority = 1, dependsOnMethods = "testEnterSearchBox")
	public void testSetFilters() {

		searchItemPage = PageFactory.initElements(driver, SearchItemPage.class);

		assertEquals(searchItemPage.getSearchItemText(), testconfig.getValidSearchItem().toUpperCase());
		searchItemPage.setFrameType().setFrameShape().setColour().setBrand().setFrameSize().setPrice().setGender()

		.setGlassColour().setFrameWeight().setPrescriptionType().setMaterial().setFrameWidth().setProductType();

		assertTrue(searchItemPage.isFiltersDisplayed());
		assertTrue(searchItemPage.validateFilters());

	}

	@Test(priority = 2)
	public void testResetFilters() {
		searchItemPage.resetFilters();
		assertFalse(searchItemPage.isFiltersDisplayed());
	}
}
