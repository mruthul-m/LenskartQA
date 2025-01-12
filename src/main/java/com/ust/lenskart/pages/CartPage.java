package com.ust.lenskart.pages;

import com.ust.lenskart.base.ReusableFunctions;
import com.ust.lenskart.utils.DriverIsNotChanged;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends ReusableFunctions {

    // Element locator for the empty cart message
    @FindBy(css = "div[data-cy='cart-not-found-desktop'] > div > div:first-child")
    private WebElement emptyCart;
    
    
    @FindBy(css = "button[data-testid='button-testid']")
    private WebElement shoppingText;

    @FindBy(css = "img[alt='lenskart-logo']")
    private WebElement homeLogo;
    
    @FindBy(xpath = "//div[@class='CartStyles__RemoveItemOverlay-sc-14bvp3n-27 bLIudg'][last()]//div//span[text()='Remove']")
    private WebElement removeBtn;
    
    @FindBy(xpath = "//div[text()='Yes, remove']")
    private WebElement acceptRemove;

    @FindBy(xpath = "//div[@class='CartStyles__RemoveItemOverlay-sc-14bvp3n-27 bLIudg'][last()]//div//div//div//div[1]/div[1]")
    private WebElement productAtCartHeading;
    
    
    public String getShoppingText() {
    	wait.until(ExpectedConditions.visibilityOf(shoppingText));
    	return shoppingText.getText();
    }
    
    public String getColor() {
    	wait.until(ExpectedConditions.visibilityOf(shoppingText));
    	return shoppingText.getAttribute("style");
    }
    // Method to get the text of the empty cart message
    public String getEmptyCartText(){
//        setWait(driver,10).until(ExpectedConditions.visibilityOf(emptyCart));
    	setImplicitWait(10);
        return emptyCart.getText();
    }

    // Method to switch the focus of the WebDriver to the new window
    public WebDriver windowSetup(String baseWindow){

        try {
            driver = changeWindow(driver,baseWindow);
        } catch (DriverIsNotChanged e) {
            throw new RuntimeException(e);
        }
        return driver;

    }
    

    // Method to get the model of the last item in the cart
    public String getModelFromCart() {
    	delay(5);
    	return productAtCartHeading.getText();
}

    public HomePage gotoHomePage() {
    	setWait(driver, 10).until(ExpectedConditions.visibilityOf(homeLogo)).click();
    	delay(3);
    	return PageFactory.initElements(driver, HomePage.class);
    }
    
    public void removeItemFromCart() {
    	setWait(driver, 10).until(ExpectedConditions.visibilityOf(removeBtn)).click();
    	wait.until(ExpectedConditions.visibilityOf(acceptRemove)).click();
    	delay(2);
    }
    
    public boolean ItemIsPresent() {
    	try {
			removeBtn.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

    }
}
