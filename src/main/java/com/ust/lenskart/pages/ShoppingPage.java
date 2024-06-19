package com.ust.lenskart.pages;

import com.ust.lenskart.base.ReusableFunctions;
import com.ust.lenskart.utils.DriverIsNotChanged;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

// Page class representing the shopping page
public class ShoppingPage extends ReusableFunctions {

    // Constructor to initialize the page
    public ShoppingPage(WebDriver driver, String base) {
        try {
            // Initialize page elements after switching to the shopping page window
            PageFactory.initElements(changeWindow(driver, base), this);
        } catch (DriverIsNotChanged e) {
            // Throw a runtime exception if window switch fails
            throw new RuntimeException(e);
        }
    }
    
    // WebElement representing the "Buy Now" button
    @FindBy(css = "div[data-cy='pdp-select-lens-button-desktop'] > button:first-child")
    private WebElement buyNow;
    
    // WebElement representing the model number
    @FindBy(xpath = "//span[text()='Model No.']/following::span[1]")
    private WebElement modelNo;

    // Method to click the "Buy Now" button
    public void clickBuyNow(){
        // Wait for the "Buy Now" button to be visible and then click it
        setWait(driver,10).until(ExpectedConditions.visibilityOf(buyNow));
        buyNow.click();
    }

    // Method to get the model number
    public String getModelNo() {
        // Add a delay to ensure the model number is loaded
    	delay(2);
    	// Return the text of the model number WebElement
    	return modelNo.getText();
    }
}
