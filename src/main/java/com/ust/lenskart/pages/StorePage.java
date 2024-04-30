package com.ust.lenskart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ust.lenskart.base.TestBase;

// Page class representing the store page
public class StorePage extends TestBase{

	// WebElement representing the store search box
	@FindBy(css = "input[placeholder='Search by state/pincode/Locality']")
	private WebElement storeSearchBox;
	
	// WebElement representing the city dropdown
	@FindBy(css = "input[placeholder='Search by state/pincode/Locality']+div>div:first-child")
	private WebElement city;
	
	// List of WebElements representing the shops
	@FindBy(xpath = "//div/child::a/following-sibling::div[contains(@id,'store-card-')]")
	private List<WebElement> shops;
	
	// WebElement representing the "Book Appointment" button
	@FindBy(xpath = "//div[@class='index_subcontainer__vOgEh']/div[contains(@id,'store-card')][1]/div/div[2]/div[4]/button")
	private WebElement bookAppointment;
	
	// WebElement representing the number input box
	@FindBy(css = "input[type='number']")
	private WebElement numberBox;
	
	// WebElement representing the name input box
	@FindBy(css = "input[type='text']")
	private WebElement nameBox;
	
	// WebElement representing the booking button
	@FindBy(className = "Details_next__ttIpv")
	private WebElement bookingBtn;
	
	// WebElement representing the first available shift slot
	@FindBy(xpath = "//div[@class='Schedule_allShift___NPxw']/div[not(contains(@style, 'cursor: not-allowed'))][1]")
	private WebElement shiftSlot;
	
	// WebElement representing the button to book the slot
	@FindBy(css = ".Schedule_next__mYWLO")
	private WebElement slotBookingBtn;

	// WebElement representing the confirmation message
	@FindBy(xpath = "//div[text()='Appointment Confirmed']")
	private WebElement confirmation;
	
	// Method to check if the search box is visible
	public boolean isSearchBoxVisible() {
		delay(1);
		return storeSearchBox.isDisplayed();
	}
	
	// Method to set the city in the search box
	public StorePage setCity(String city) {
		storeSearchBox.sendKeys(city);
		return this;
	}
	
	// Method to click the city from the dropdown
	public StorePage clickCity() {
		delay(2);
		city.click();
		return this;
	}
	
	// Method to get the text of all the shops
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
	
	// Method to click the "Book Appointment" button
	public StorePage clickBookAppointment() {
		delay(3);
		bookAppointment.click();
		return this;
	}
	
	// Method to set details for the appointment booking
	public StorePage setDetails(String num, String name) {
		delay(2);
		setWait(driver,10).until(ExpectedConditions.visibilityOf(numberBox));
		numberBox.sendKeys(num);
		nameBox.sendKeys(name);
		return this;
	}
	
	// Method to click the booking button
	public StorePage clickBooking() {
		bookingBtn.click();
		return this;
	}
	
	// Method to select the first available shift
	public StorePage selectShift() {
		delay(3);
		setWait(driver,10).until(ExpectedConditions.visibilityOf(shiftSlot));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", shiftSlot);
		shiftSlot.click();
		slotBookingBtn.click();
		return this;
	}
	
	// Method to get the confirmation message
	public String getConfirmationText() {
		return setWait(driver, 10).until(ExpectedConditions.visibilityOf(confirmation)).getText();
	}
}
