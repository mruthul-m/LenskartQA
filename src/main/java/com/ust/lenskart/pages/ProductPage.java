package com.ust.lenskart.pages;

import com.ust.lenskart.base.ReusableFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

// This class represents the Product page of the Lenskart application
public class ProductPage extends ReusableFunctions {

	// WebElement for the first item on the product listing page
	@FindBy(css = ".ListingStyles__RowWrapper-sc-hgixc8-0.jyCwsY:first-child > div:first-child")
	private WebElement firstItem;

	// Method to select the first product from the product listing
	public void selectProduct() {
		// Introduce a delay to ensure page stability
		delay(2);
		// Wait until the first item is visible
		setWait(driver, 10).until(ExpectedConditions.visibilityOf(firstItem));
		// Click on the first item
		firstItem.click();
	}
}