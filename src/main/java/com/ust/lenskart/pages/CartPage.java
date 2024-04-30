package com.ust.lenskart.pages;

import com.ust.lenskart.base.TestBase;
import com.ust.lenskart.utils.DriverIsNotChanged;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends TestBase {

    // Element locator for the empty cart message
    @FindBy(css = "div[data-cy='cart-not-found-desktop'] > div > div:first-child")
    private WebElement emptyCart;
    
    // Element locator for the remove button of the last item in the cart
    @FindBy(xpath = "//div[@class='CartStyles__RemoveItemOverlay-sc-14bvp3n-27 bLIudg'][last()]//div//span[text()='Remove']")
    private WebElement removeBtn;
    
    // Element locator for the heading of the last item in the cart
    @FindBy(xpath = "//div[@class='CartStyles__RemoveItemOverlay-sc-14bvp3n-27 bLIudg'][last()]//div//div[@class='ItemTitle--h71f3c fzTWih']")
    private WebElement productAtCartHeading;

    // Method to get the text of the empty cart message
    public String getEmptyCartText(){
        setWait(driver,10).until(ExpectedConditions.visibilityOf(emptyCart));
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
}
