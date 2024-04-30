package com.ust.lenskart.pages;

import com.ust.lenskart.base.TestBase;
import com.ust.lenskart.utils.DriverIsNotChanged;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends TestBase {

    @FindBy(css = "div[data-cy='cart-not-found-desktop'] > div > div:first-child")
    private WebElement emptyCart;
    
    @FindBy(css = "img[alt='lenskart-logo']")
    private WebElement homeLogo;
    
    @FindBy(xpath = "//div[@class='CartStyles__RemoveItemOverlay-sc-14bvp3n-27 bLIudg'][last()]//div//span[text()='Remove']")
    private WebElement removeBtn;
    
    @FindBy(css = ".PopUpConfirm--1ykjvo8.gvkMrH")
    private WebElement acceptRemove;

    public String getEmptyCartText(){
        setWait(driver,10).until(ExpectedConditions.visibilityOf(emptyCart));
        return emptyCart.getText();
    }

    public WebDriver windowSetup(String baseWindow){

        try {
            driver = changeWindow(driver,baseWindow);
        } catch (DriverIsNotChanged e) {
            throw new RuntimeException(e);
        }
        return driver;

    }
    
    public HomePage gotoHomePage() {
    	setWait(driver, 10).until(ExpectedConditions.visibilityOf(homeLogo)).click();
    	delay(3);
    	return PageFactory.initElements(driver, HomePage.class);
    }
    
    public void removeItemFromCart() {
    	setWait(driver, 10).until(ExpectedConditions.visibilityOf(removeBtn)).click();
    	acceptRemove.click();
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
