package com.ust.lenskart.pages;

import com.ust.lenskart.base.TestBase;
import com.ust.lenskart.utils.DriverIsNotChanged;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends TestBase {

    @FindBy(css = "div[data-cy='cart-not-found-desktop'] > div > div:first-child")
    private WebElement emptyCart;

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
}
