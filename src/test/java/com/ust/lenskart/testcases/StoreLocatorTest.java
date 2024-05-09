package com.ust.lenskart.testcases;

import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


import com.ust.lenskart.pages.HomePage;
import com.ust.lenskart.pages.StorePage;


public class StoreLocatorTest extends Hooks{
	
	HomePage homepage;
	String parentWindow;
	
	@Test
	public void gotoLocator() {
		homepage = PageFactory.initElements(driver, HomePage.class);
		homepage.hoverStoreLocator(driver)
				.clickStoreLink();
		String url = driver.getCurrentUrl();
		assertTrue(url.equals("https://www.lenskart.com/stores"));
				
	}
	
	@Test(dependsOnMethods = "gotoLocator")
	public void searchCity() {
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if (! window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
		List<String> places= PageFactory.initElements(driver, StorePage.class)
				.setCity("Thiruvananthapuram, Kerala, India").clickCity().getShopText();
		
		
		
		List<String> locations = Arrays.asList(
				"Murinjapalam", "Ulloor", "Paruthipara", "KP Road",
				"Sreekariyam","General Hospital Trivandrum","Sasthamangalam","Vazhuthacaud",
				"Mall of Travancore","MG Road Trivandrum","Lulu Mall","Karamana","Kazhakootam",
				"Pappanamcode");
		assertTrue(places.stream()
				  .allMatch(element -> locations.contains(element)));

	}

}
