package com.ust.lenskart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ust.lenskart.base.TestBase;

public class StorePage extends TestBase{

	
	@FindBy(css = "input[placeholder='Search by state/pincode/Locality']")
	private WebElement storeSearchBox;
	
	@FindBy(css = "input[placeholder='Search by state/pincode/Locality']+div>div:first-child")
	private WebElement city;
	
	@FindBy(xpath = "//div/child::a/following-sibling::div[contains(@id,'store-card-')]")
	private List<WebElement> shops;
	
	@FindBy(xpath = "//div[@class='index_subcontainer__vOgEh']/div[contains(@id,'store-card')][1]/div/div[2]/div[5]/button")
	private WebElement bookAppointment;
	
	@FindBy(css = "input[type='number']")
	private WebElement numberBox;
	
	@FindBy(css = "input[type='text']")
	private WebElement nameBox;
	
	@FindBy(className = "Details_next__ttIpv")
	private WebElement bookingBtn;
	
	@FindBy(xpath = "//div[@class='Schedule_allShift___NPxw']/div[not(contains(@style, 'cursor: not-allowed'))][1]")
	private WebElement shiftSlot;
	
	@FindBy(css = ".Schedule_next__mYWLO")
	private WebElement slotBookingBtn;

	@FindBy(xpath = "//div[text()='Appointment Confirmed']")
	private WebElement confirmation;
	
	public boolean isSearchBoxVisible() {
		delay(1);
		return storeSearchBox.isDisplayed();
	}
	
	public StorePage setCity(String city) {
		storeSearchBox.sendKeys(city);
		return this;
	}
	
	public StorePage clickCity() {
		
		delay(2);
		city.click();
		return this;
	}
	
	public List<String> getShopText() {
		
		delay(2);
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
	
	public StorePage clickBookAppointment() {
		delay(3);
		bookAppointment.click();
		return this;
	}
	
	public StorePage setDetails(String num, String name) {
		delay(2);
		numberBox.sendKeys(num);
		nameBox.sendKeys(name);
		
		return this;
	}
	
	public StorePage clickBooking() {
		bookingBtn.click();
		return this;
	}
	
	public StorePage selectShift() {
		delay(3);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", shiftSlot);
		shiftSlot.click();
		slotBookingBtn.click();
		return this;
	}
	
	public String getConfirmationText() {
		return
		setWait(driver, 10).until(ExpectedConditions.visibilityOf(confirmation)).getText();
	}
}
