package com.ust.lenskart.pages;

import com.ust.lenskart.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends TestBase {

    @FindBy(css = ".ListingStyles__RowWrapper-sc-hgixc8-0.jyCwsY:first-child > div:first-child")
    private WebElement firstItem;

    public void selectProduct(){
        delay(2);
        setWait(driver,10).until(ExpectedConditions.visibilityOf(firstItem));
        firstItem.click();


    }
}
