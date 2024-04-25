package com.ust.lenskart.testcases;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ust.lenskart.pages.HomePage;

public class TestResetFilters extends Hooks {
	HomePage homePage;

	@Test(priority = 0)
	public void testEnterSearchBox() {
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.enterSearchBox(testconfig.getValidSearchItem());
		assertEquals(testconfig.getSearchUrl(), homePage.getUrl());
	}

	@Test(priority = 1)
	public void testSetFilters() {
		homePage.setColour().setBrand().setFrameSize().setPrice().setGender().setGlassColour().setFrameWeight()
				.setPrescriptionType().setSupportedPower().setMaterial().setSubBrand().setFrameWidth().setProductType();
		assertTrue(homePage.isFiltersDisplayed());
	}

	@Test(priority = 2)
	public void testResetFilters() {
		homePage.resetFilters();
		assertFalse(homePage.isFiltersDisplayed());
	}
}
