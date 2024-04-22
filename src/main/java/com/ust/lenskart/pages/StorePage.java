package com.ust.lenskart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ust.lenskart.base.TestBase;

public class StorePage extends TestBase{

	
	@FindBy(css = "input[placeholder='Search by state/pincode/Locality']")
	private WebElement storeSearchBox;
	
	@FindBy(css = "input[placeholder='Search by state/pincode/Locality']+div>div:first-child")
	private WebElement tvm;
	
	@FindBy(xpath = "//div/child::a/following-sibling::div[contains(@id,'store-card-')]")
	private List<WebElement> shops;
	
	public StorePage setCity() {
		storeSearchBox.sendKeys("Thiruvananthapuram, Kerala, India");
		return this;
	}
	
	public StorePage clickCity() {
		delay(2000);
		tvm.click();
		return this;
	}
	
	public List<String> getShopText() {
		delay(2000);
		List<String> places = new ArrayList<String>();
		for (WebElement shop : shops) {
			if (shop.getText().split("\n")[1].equals("Open Now")) {
				places.add(shop.getText().split("\n")[2]);
				continue;
			}
			places.add(shop.getText().split("\n")[1]);
		}
		
		return places;
		
	}
}
