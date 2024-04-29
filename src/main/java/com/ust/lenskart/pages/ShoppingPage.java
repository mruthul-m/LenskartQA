package com.ust.lenskart.pages;

import com.ust.lenskart.base.TestBase;
import com.ust.lenskart.utils.DriverIsNotChanged;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingPage extends TestBase {

    public ShoppingPage(WebDriver driver,String base){
        try {
            PageFactory.initElements(changeWindow(driver,base),this);
        } catch (DriverIsNotChanged e) {
            throw new RuntimeException(e);
        }
    }
    @FindBy(css = "div[data-cy='pdp-select-lens-button-desktop'] > button:first-child")
    private WebElement buyNow;

    @FindBy(css = ".BasicDetailsWrapper--1hhncu9 > h1")
    private WebElement productName;

    public void clickBuyNow(){
        setWait(driver,10).until(ExpectedConditions.visibilityOf(buyNow));
        buyNow.click();
    }

    public String getProductName(){
        setWait(driver,10).until(ExpectedConditions.visibilityOf(productName));
        return productName.getText();
    }

}