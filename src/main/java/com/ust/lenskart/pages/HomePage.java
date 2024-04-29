package com.ust.lenskart.pages;

import java.util.ArrayList;
import java.util.List;

import com.ust.lenskart.utils.DriverIsNotChanged;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.ust.lenskart.base.TestBase;
import com.ust.lenskart.utils.Helper;

public class HomePage extends TestBase {
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@FindBy(css = "input[placeholder='What are you looking for?']")
	public WebElement searchbox;

	@FindBy(xpath = "//div[@id='frame_color_id']/div[1]")
	public WebElement dropdown1;

	@FindBy(xpath = "//div[@id='frame_color_id']/div[2]/div/div[2]/label")
	public WebElement colour;

	@FindBy(xpath = "//div[@id='brandname_id']/div[1]")
	public WebElement dropdown2;

	@FindBy(xpath = "//div[@id='brandname_id']/div[2]/div/div[2]/label")
	public WebElement brand;

	@FindBy(xpath = "//div[@id='frame_size_id']/div[1]")
	public WebElement dropdown3;

	@FindBy(xpath = "//div[@id='frame_size_id']/div[2]/div/div[3]/label")
	public WebElement frameSize;

	@FindBy(xpath = "//div[@id='lenskart_price']/div[1]")
	public WebElement dropdown4;

	@FindBy(xpath = "//div[@id='lenskart_price']/div[2]/div/div[1]/label")
	public WebElement price;

	@FindBy(xpath = "//div[@id='gender_id']/div[1]")
	public WebElement dropdown5;

	@FindBy(xpath = "//div[@id='gender_id']/div[2]/div/div[1]/label")
	public WebElement gender;

	@FindBy(xpath = "//div[@id='glass_color_id']/div[1]")
	public WebElement dropdown6;

	@FindBy(xpath = "//div[@id='glass_color_id']/div[2]/div/div[1]/label")
	public WebElement glassColour;

	@FindBy(xpath = "//div[@id='frame_weight_group_id']/div[1]")
	public WebElement dropdown7;

	@FindBy(xpath = "//div[@id='frame_weight_group_id']/div[2]/div/div[1]/label")
	public WebElement frameWeight;

	@FindBy(xpath = "//div[@id='prescription_type_id']/div[1]")
	public WebElement dropdown8;

	@FindBy(xpath = "//div[@id='prescription_type_id']/div[2]/div/div[1]/label")
	public WebElement prescriptionType;

	@FindBy(xpath = "//div[@id='supported_powers_id']/div[1]")
	public WebElement dropdown9;

	@FindBy(xpath = "//div[@id='supported_powers_id']/div[2]/div/div[2]/label")
	public WebElement supportedPower;

	@FindBy(xpath = "//div[@id='material_id']/div[1]")
	public WebElement dropdown10;

	@FindBy(xpath = "//div[@id='material_id']/div[2]/div/div[1]/label")
	public WebElement material;

	@FindBy(xpath = "//div[@id='sub_brand_id']/div[1]")
	public WebElement dropdown11;

	@FindBy(xpath = "//div[@id='sub_brand_id']/div[2]/div/div[1]/label")
	public WebElement subBrand;

	@FindBy(xpath = "//div[@id='frame_width_id']/div[1]")
	public WebElement dropdown12;

	@FindBy(xpath = "//div[@id='frame_width_id']/div[2]/div/div[1]/label")
	public WebElement frameWidth;

	@FindBy(xpath = "//div[@id='product_type']/div[1]")
	public WebElement dropdown13;

	@FindBy(xpath = "//div[@id='product_type']/div[2]/div/div[1]/label")
	public WebElement productType;

	@FindBy(xpath = "//div[starts-with(@class,'SelectedFiltersStyles__ActiveFiltersContainer')]")
	public WebElement nofilters;

	@FindBy(tagName = "aside")
	public WebElement sidebar;

	@FindBy(linkText = "Eyewear")
	public WebElement eyewear;

	@FindBy(css = "label+select")
	public WebElement selectsort;

	@FindBy(xpath = "//span[starts-with(@class,'SelectedFiltersStyles__ResetFilters')]")
	public WebElement resetFilters;

	@FindBy(css = "span[class='SpecialPriceSpan--1mh26ry gDbhuM']")
	public List<WebElement> priceList;

	@FindBy(id = "lrd9")
	private WebElement storeLocator;

	@FindBy(linkText = "Locate a Store")
	private WebElement storeLink;

	@FindBy(css = ".ActionLinksContainer--5xj1y5.gKkoeY > div:last-child")
	private WebElement cartLink;

	@FindBy(xpath = "//div[@class='Buttons--15b7dyn jAmxXC']//span[text()='Remove']")
	private WebElement removeItem;

	@FindBy(xpath = "//div[starts-with(@class,'ActionLinksContainer')]/div[3]/span")
	public WebElement wishList;

	@FindBy(xpath = "//div[@id='wishlistView']")
	public WebElement wishListBox;

	@FindBy(xpath = "//div[starts-with(@class,'HeaderText')]/span")
	public WebElement wishListProductCount;

	@FindBy(css = "svg[class='wishlist-icon']")
	public List<WebElement> productWishList;

	@FindBy(xpath = "//h5[starts-with(@class,'BrandName')]")
	public List<WebElement> wishListProductTitle;

	@FindBy(xpath = "//p[starts-with(@class,'ProductTitle')]")
	public List<WebElement> productTitle;

	@FindBy(xpath = "//a[starts-with(@class,'Cross')]")
	public List<WebElement> cross;

	@FindBy(css = "iframe[name='spr-chat__box-frame']")
	public WebElement chatBotFrame;

	@FindBy(className = "spr-chat-box-anim-enter-done")
	public WebElement chatBotBox;

	@FindBy(id = "spr-chat__trigger-button")
	public WebElement chatBotButton;

	@FindBy(css = "button[label='New Conversation']")
	public WebElement chatBotNewConversation;

	@FindBy(css = "span[data-lucid-type='application/vnd.lucid.text']")
	public WebElement chatBotWelcomeText;

	@FindBy(css = "button[aria-label='More actions']")
	public WebElement moreActions;

	@FindBy(css = "div[data-testid='actionMenuList']>div")
	public WebElement newConversation;

	public HomePage enterSearchBox(String itemtext) {
		searchbox.sendKeys(itemtext, Keys.ENTER);
		delay(1);
		return this;
	}

	public HomePage setColour() {
		wait.until(ExpectedConditions.visibilityOf(dropdown1));
		dropdown1.click();
		delay(1);
		wait.until(ExpectedConditions.elementToBeClickable(colour));
		colour.click();
		dropdown1.click();
		return this;
	}

	public HomePage setBrand() {
		wait.until(ExpectedConditions.visibilityOf(dropdown2));
		dropdown2.click();
		delay(1);
		wait.until(ExpectedConditions.elementToBeClickable(brand));
		brand.click();
		delay(1);
		dropdown2.click();
		return this;
	}

	public HomePage setFrameSize() {
		wait.until(ExpectedConditions.visibilityOf(dropdown3));
		dropdown3.click();
		delay(1);
		wait.until(ExpectedConditions.elementToBeClickable(frameSize));
		frameSize.click();
		delay(1);
		dropdown3.click();
		return this;
	}

	public HomePage setPrice() {
		wait.until(ExpectedConditions.visibilityOf(dropdown4));
		dropdown4.click();
		delay(1);
		wait.until(ExpectedConditions.elementToBeClickable(price));
		price.click();
		delay(1);
		dropdown4.click();

		return this;
	}

	public HomePage setGender() {
		wait.until(ExpectedConditions.visibilityOf(dropdown5));
		dropdown5.click();
		delay(1);
		wait.until(ExpectedConditions.elementToBeClickable(gender));
		gender.click();
		delay(1);
		dropdown5.click();
		return this;
	}

	public HomePage setGlassColour() {
		wait.until(ExpectedConditions.visibilityOf(dropdown6));
		dropdown6.click();
		delay(1);
		wait.until(ExpectedConditions.elementToBeClickable(glassColour));
		glassColour.click();
		delay(1);
		dropdown6.click();
		return this;
	}

	public HomePage setFrameWeight() {
		wait.until(ExpectedConditions.visibilityOf(dropdown7));
		dropdown7.click();
		delay(1);
		wait.until(ExpectedConditions.elementToBeClickable(frameWeight));
		frameWeight.click();
		delay(1);
		dropdown7.click();
		return this;
	}

	public HomePage setPrescriptionType() {
		wait.until(ExpectedConditions.visibilityOf(dropdown8));
		dropdown8.click();
		delay(1);
		wait.until(ExpectedConditions.elementToBeClickable(prescriptionType));
		prescriptionType.click();
		delay(1);
		dropdown8.click();
		return this;
	}

	public HomePage setSupportedPower() {
		wait.until(ExpectedConditions.visibilityOf(dropdown9));
		dropdown9.click();
		delay(1);
		wait.until(ExpectedConditions.elementToBeClickable(supportedPower));
		supportedPower.click();
		delay(1);
		js.executeScript("window.scrollBy(0, 200);");
		delay(1);
		dropdown9.click();
		return this;
	}

	public HomePage setMaterial() {
		wait.until(ExpectedConditions.visibilityOf(dropdown10));
		dropdown10.click();
		delay(1);
		wait.until(ExpectedConditions.elementToBeClickable(material));
		material.click();
		delay(1);
		js.executeScript("window.scrollBy(0, 200);");
		delay(1);
		dropdown10.click();
		return this;
	}

	public HomePage setSubBrand() {
		wait.until(ExpectedConditions.visibilityOf(dropdown11));
		dropdown11.click();
		delay(1);
		wait.until(ExpectedConditions.elementToBeClickable(subBrand));
		subBrand.click();
		delay(1);
		js.executeScript("window.scrollBy(0, 300);");
		delay(1);
		dropdown11.click();
		return this;
	}

	public HomePage setFrameWidth() {
		wait.until(ExpectedConditions.visibilityOf(dropdown12));
		dropdown12.click();
		delay(1);
		js.executeScript("arguments[0].scrollTop = arguments[1];", sidebar, 800);
		wait.until(ExpectedConditions.elementToBeClickable(frameWidth));
		frameWidth.click();
		delay(1);
		js.executeScript("window.scrollBy(0, 200);");
		delay(1);
		dropdown1.click();
		return this;
	}

	public HomePage setProductType() {
		wait.until(ExpectedConditions.visibilityOf(dropdown13));
		dropdown13.click();
		delay(1);
		wait.until(ExpectedConditions.elementToBeClickable(productType));
		productType.click();
		delay(1);
		js.executeScript("window.scrollBy(0, 200);");
		delay(1);
		dropdown13.click();
		return this;
	}

	public HomePage resetFilters() {
		wait.until(ExpectedConditions.visibilityOf(resetFilters));
		resetFilters.click();
		return this;
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public boolean isFiltersDisplayed() {
		return nofilters.isDisplayed();
	}

	public void setSortLowToHigh() {
		Select drop = new Select(selectsort);
		drop.selectByVisibleText("Price: Low to High");
	}

	public void setSortHighToLow() {
		Select drop = new Select(selectsort);
		drop.selectByVisibleText("Price: High to Low");
	}

	public void showAllProducts() {
		js.executeScript("window.scrollBy(0, 500);");
		delay(2);
	}

	public boolean checkSortAsc() {
		int j = 0;
		for (int i = 0; i < priceList.size() - 1; i++) {
			j = i + 1;

			if (Integer.parseInt(priceList.get(i).getText().replace("₹", "").replaceAll(",", "")) > Integer
					.parseInt(priceList.get(j).getText().replace("₹", "").replaceAll(",", ""))) {
				return false;
			}
		}
		return true;
	}

	public boolean checkSortDesc() {
		int j = 0;
		for (int i = 0; i < priceList.size() - 1; i++) {
			j = i + 1;

			if (Integer.parseInt(priceList.get(i).getText().replace("₹", "").replaceAll(",", "")) < Integer
					.parseInt(priceList.get(j).getText().replace("₹", "").replaceAll(",", ""))) {
				return false;
			}
		}
		return true;
	}

	public HomePage hoverStoreLocator(WebDriver driver) {
		setWait(driver, 10).until(ExpectedConditions.visibilityOf(storeLocator));
		setActions(driver).moveToElement(storeLocator).build().perform();
		return this;
	}

	public HomePage clickStoreLink() {
		storeLink.click();
		delay(3);
		return this;
	}

	public CartPage cartLink(WebDriver driver) {
		cartLink.click();
		return PageFactory.initElements(driver, CartPage.class);
	}

	public HomePage clickWishList() {
		wishList.click();
		return this;
	}

	public boolean isWishListBoxVisible() {
		if (wishListBox.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public int getWishListProductCount() {
		String count = wishListProductCount.getText().replace("(", "").replace(")", "");
		return Integer.parseInt(count);
	}

	public HomePage addProductsToWishList(int num) {
		for (int i = 0; i < num; i++) {
			productWishList.get(0).click();
			delay(1);
		}
		return this;
	}

	public boolean checkProductTitle(int num) {
		List<WebElement> tempList = new ArrayList<WebElement>();
		for (int j = num - 1; j >= 0; j--) {
			tempList.add(wishListProductTitle.get(j));
		}
		for (int i = 0; i < num; i++) {
			if (!(productTitle.get(i).getText().equals(tempList.get(i).getText()))) {
				return false;
			}
		}
		return true;
	}

	public HomePage removeProductsFromWishList() {
		setActions(driver).moveToElement(wishListProductTitle.get(0)).perform();
		delay(1);
		setActions(driver).moveToElement(cross.get(0)).click().perform();
		delay(1);
		return this;
	}

	public HomePage clickChatBotIcon() {
		wait.until(ExpectedConditions.visibilityOf(chatBotButton));
		chatBotButton.click();
		return this;
	}

	public boolean isChatBotDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(chatBotBox));
		return chatBotBox.isDisplayed();
	}

	public HomePage startNewChat() {
		delay(2);
		driver.switchTo().frame(chatBotFrame);
		wait.until(ExpectedConditions.visibilityOf(chatBotNewConversation));
		chatBotNewConversation.click();
		return this;
	}

	public boolean checkChatBotWelcomeText() {
		wait.until(ExpectedConditions.visibilityOf(chatBotWelcomeText));
		return chatBotWelcomeText.getText().startsWith("Hello! Welcome to Lenskart");
	}

	public HomePage clickChatSuggestion(String option) {
		delay(2);
		Helper.clickSuggestion(option);
		return this;
	}

	public String getAssertionText(String assertionMessage) {
		delay(3);
		return Helper.checkAssertionText(assertionMessage);
	}

	public HomePage clickMoreActions() {
		delay(2);
		moreActions.click();
		return this;
	}

	public HomePage clickNewConversation() {
		wait.until(ExpectedConditions.visibilityOf(newConversation));
		newConversation.click();
		return this;
	}
}
