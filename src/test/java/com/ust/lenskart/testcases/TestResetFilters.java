package com.ust.lenskart.testcases;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ust.lenskart.pages.HomePage;
import com.ust.lenskart.pages.SearchItemPage;

public class TestResetFilters extends Hooks {
	
	//declaring variable of type HomePage 
	HomePage homePage;
	
	//declaring variable of type SearchItemPage 
	SearchItemPage searchItemPage;

	//Tests entering specified string into searchbox and validates the url
	@Test(priority = 0)
	public void testEnterSearchBox() {
		homePage = PageFactory.initElements(driver, HomePage.class).enterSearchBox(testconfig.getValidSearchItem());
		assertEquals(homePage.getUrl(), testconfig.getSearchUrl());
	}

	//Tests setting filters and validates the filters
	@Test(priority = 1, dependsOnMethods = "testEnterSearchBox")
	public void testSetFilters() {

		searchItemPage = PageFactory.initElements(driver, SearchItemPage.class);

		assertEquals(searchItemPage.getSearchItemText(), testconfig.getValidSearchItem().toUpperCase());
		searchItemPage.setFrameType().setFrameShape().setColour().setBrand().setFrameSize().setPrice().setGender()

		.setGlassColour().setFrameWeight().setPrescriptionType().setMaterial().setFrameWidth().setProductType();

		assertTrue(searchItemPage.isFiltersDisplayed());
		assertTrue(searchItemPage.validateFilters());

	}

	//Tests if the filters are displayed after clicking reset filters
	@Test(priority = 2)
	public void testResetFilters() {
		searchItemPage.resetFilters();
		assertFalse(searchItemPage.isFiltersDisplayed());
	}
}
