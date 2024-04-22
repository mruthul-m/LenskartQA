package com.ust.lenskart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ust.lenskart.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(id = "lrd9")
	private WebElement storeLocator;
	
	@FindBy(linkText = "Locate a Store")
	private WebElement storeLink;
	
	public HomePage hoverStoreLocator(WebDriver driver) {		
		setWait(driver, 10).until(ExpectedConditions.visibilityOf(storeLocator));
		setActions(driver).moveToElement(storeLocator).build().perform();
		return this;
	}
	
	public HomePage clickStoreLink() {
		storeLink.click();
		delay(3000);
		return this;
	}

}
