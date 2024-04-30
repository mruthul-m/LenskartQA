package com.ust.lenskart.pages;




import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ust.lenskart.base.TestBase;
import com.ust.lenskart.utils.Helper;

public class HomePage extends TestBase {
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@FindBy(css = "input[placeholder='What are you looking for?']")
	public WebElement searchbox;

	@FindBy(id = "lrd9")
	private WebElement storeLocator;

	@FindBy(linkText = "Locate a Store")
	private WebElement storeLink;

	@FindBy(css = ".ActionLinksContainer--5xj1y5.gKkoeY > div:last-child")
	private WebElement cartLink;

	@FindBy(xpath = "//div[@class='Buttons--15b7dyn jAmxXC']//span[text()='Remove']")
	private WebElement removeItem;

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


	public String getUrl() {
		return driver.getCurrentUrl();
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

	public CartPage cartLink(WebDriver driver){
		

		cartLink.click();
		return PageFactory.initElements(driver, CartPage.class);
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
