package com.ust.lenskart.pages;


//All necessary imports

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ust.lenskart.base.TestBase;
import com.ust.lenskart.utils.Helper;

// This class represents the Home page of the Lenskart application
public class HomePage extends TestBase {

	
	//initializes a JavascriptExecutor object named js
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	//identifies the searchbox webelement
	@FindBy(css = "input[placeholder='What are you looking for?']")
	public WebElement searchbox;

	//identifies the storelocator tab webelement
	@FindBy(id = "lrd9")
	private WebElement storeLocator;
	
	//identifies the Locate a store anchor tag
	@FindBy(linkText = "Locate a Store")
	private WebElement storeLink;

	
	@FindBy(css = ".ActionLinksContainer--5xj1y5.gKkoeY > div:last-child")
	private WebElement cartLink;

	@FindBy(xpath = "//div[@class='Buttons--15b7dyn jAmxXC']//span[text()='Remove']")
	private WebElement removeItem;

	//identfies frame tag for the chatbot tab
	@FindBy(css = "iframe[name='spr-chat__box-frame']")
	public WebElement chatBotFrame;
	
	//identifies chatbot box
	@FindBy(className = "spr-chat-box-anim-enter-done")
	public WebElement chatBotBox;

	//identifies chatbot button
	@FindBy(id = "spr-chat__trigger-button")
	public WebElement chatBotButton;

	//identifies new conversation button
	@FindBy(css = "button[label='New Conversation']")
	public WebElement chatBotNewConversation;

	//identifies welcome text
	@FindBy(css = "span[data-lucid-type='application/vnd.lucid.text']")
	public WebElement chatBotWelcomeText;

	//identifies more actions button
	@FindBy(css = "button[aria-label='More actions']")
	public WebElement moreActions;

	//identifies new conversation from dropdown
	@FindBy(css = "div[data-testid='actionMenuList']>div")
	public WebElement newConversation;
	
	//identifies 
	@FindBy(xpath = "//span[text()='Sign Up']")
	private WebElement signUpLink;
	
	@FindBy(css = "#sign-up-form")
	private WebElement signUpForm;
	
	@FindBy(css = "input[placeholder='First Name*']")
	private WebElement fname;
	
	@FindBy(css = "input[placeholder='Last Name']")
	private WebElement lname;
	
	@FindBy(css = "input[placeholder='Mobile*']")
	private WebElement mobile;
	
	@FindBy(css = "input[placeholder='Email*']")
	private WebElement email;
	
	@FindBy(css = "input[placeholder='Password*']")
	private WebElement password;
	
	@FindBy(xpath = "//button[text()='Create an Account']")
	private WebElement createBtn;
	
	@FindBy(css = "#whatsapp-updates")
	private WebElement waCheckbox;
	
	@FindBy(xpath = "//span[text()='Sign In']")
	private WebElement SignInLink;
	
	
	@FindBy(css = "#sign-in-form")
	private WebElement signInForm;
	
	@FindBy(css = "input[name='emailOrPhone']")
	private WebElement loginEmail;
	
	@FindBy(css = "input[placeholder='Enter Password']")
	private WebElement loginPassword;
	
	@FindBy(css = "button[id='remove-button']")
	private WebElement signInBtn;
	
	@FindBy(css = ".ActionLinksContainer--5xj1y5.gKkoeY > div:nth-child(2)")
	private WebElement loginUserName;
	
	@FindBy(css = "div[subtext]")
	private WebElement invalidEmailError;
	
	@FindBy(css = ".ErrorField--6thwyh.ihTbJV")
	private WebElement emailExistsError;
	
	@FindBy(css = "#remove-button")
	private WebElement createAccountBtn;

	//enters the necessary text into the searchbox inputfield
	public HomePage enterSearchBox(String itemtext) {
		searchbox.sendKeys(itemtext, Keys.ENTER);
		delay(1);
		return this;
	}

	//method to return the current url as string
	public String getUrl() {
		delay(1);
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

	//method that clicks chatbot button
	public HomePage clickChatBotIcon() {
		wait.until(ExpectedConditions.visibilityOf(chatBotButton));
		chatBotButton.click();
		return this;
	}
	//method to check whether chatbot box is displayed or not
	public boolean isChatBotDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(chatBotBox));
		return chatBotBox.isDisplayed();
	}
	//method to switch to new frame and to start new conversation
	public HomePage startNewChat() {
		delay(2);
		driver.switchTo().frame(chatBotFrame);
		wait.until(ExpectedConditions.visibilityOf(chatBotNewConversation));
		chatBotNewConversation.click();
		return this;
	}
	//method to check whether the welcome text starts with the specified string
	public boolean checkChatBotWelcomeText() {
		wait.until(ExpectedConditions.visibilityOf(chatBotWelcomeText));
		return chatBotWelcomeText.getText().startsWith("Hello! Welcome to Lenskart");
	}
	//method to click chatbot suggestions
	public HomePage clickChatSuggestion(String option) {
		delay(2);
		Helper.clickSuggestion(option);
		return this;
	}
	//method that returns the string displayed for assertion
	public String getAssertionText(String assertionMessage) {
		delay(3);
		return Helper.checkAssertionText(assertionMessage);
	}
	//method to click more actions button
	public HomePage clickMoreActions() {
		delay(2);
		moreActions.click();
		return this;
	}
	//method to click new conversation from dropdown
	public HomePage clickNewConversation() {
		wait.until(ExpectedConditions.visibilityOf(newConversation));
		newConversation.click();
		return this;
	}
	
	public HomePage clickSignUp() {
		wait.until(ExpectedConditions.visibilityOf(signUpLink)).click();
		return this;
	}
	
	public boolean signUpFormDisplayed() {
		return
		wait.until(ExpectedConditions.visibilityOf(signUpForm)).isDisplayed();
	}
	
	public HomePage setFname(String fname) {
		wait.until(ExpectedConditions.visibilityOf(this.fname)).sendKeys(fname);
		return this;
	}
	
	public HomePage setLname(String lname) {
		wait.until(ExpectedConditions.visibilityOf(this.lname)).sendKeys(lname);
		return this;
	}
	
	public HomePage setMobile(String num) {
		wait.until(ExpectedConditions.visibilityOf(mobile)).sendKeys(num);
		return this;
	}
	
	public HomePage setEmail(String email) {
		wait.until(ExpectedConditions.visibilityOf(this.email)).sendKeys(email);
		return this;
	}
	
	public HomePage setPassword(String passwd) {
		wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(passwd);
		return this;
	}
	
	public HomePage clickCreateBtn() {
		wait.until(ExpectedConditions.visibilityOf(createBtn)).click();
		return this;
	}
	
	public HomePage unCheckWaBox() {
		wait.until(ExpectedConditions.visibilityOf(waCheckbox)).click();
		return this;
	}
	
	public String getFname() {
		return this.fname.getAttribute("value");
	}
	
	public String getLname() {
		return this.lname.getAttribute("value");					
	}
	
	public String getEmail() {
		return this.email.getAttribute("value");
	}
	
	public String getPassword() {
		return this.password.getAttribute("value");
	}
	
	public String getMobileNo() {
		return this.mobile.getAttribute("value");				
	}
	
	public HomePage clickSignInLink() {
		wait.until(ExpectedConditions.visibilityOf(SignInLink)).click();
		return this;
	}
	
	public boolean isSignInFormDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(signInForm)).isDisplayed();
	}
	
	public HomePage setLoginEmail(String email) {
		wait.until(ExpectedConditions.visibilityOf(loginEmail)).sendKeys(email);
		return this;
	}
	
	
	
	public HomePage setLoginPassword(String passwd) {
		wait.until(ExpectedConditions.visibilityOf(loginPassword)).sendKeys(passwd);
		return this;
	}
	
	public HomePage clickLoginFormBtn() {
		wait.until(ExpectedConditions.visibilityOf(signInBtn)).click();
		return this;
	}
	
	public String getLoginUserName() {
		delay(3);
		return
				wait.until(ExpectedConditions.visibilityOf(loginUserName)).getText();
	}
	
	public String getInvalidEmailError() {
		delay(3);
		return wait.until(ExpectedConditions.visibilityOf(invalidEmailError)).getText();
	}
	
	public String getEmailExistsError() {
		delay(2);
		return wait.until(ExpectedConditions.visibilityOf(emailExistsError)).getText();
	}
	
	public HomePage clickCreateAccountBtn() {
		wait.until(ExpectedConditions.visibilityOf(createAccountBtn)).click();
		return this;
	}

}

