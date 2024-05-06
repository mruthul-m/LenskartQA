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

// This class represents the Home page of the Lenskart application
public class HomePage extends TestBase {
	
    // JavaScript executor for executing JavaScript code in Selenium
    JavascriptExecutor js = (JavascriptExecutor) driver;

    // WebElement for the search box
    @FindBy(css = "input[placeholder='What are you looking for?']")
    public WebElement searchbox;

    // WebElement for the store locator
    @FindBy(id = "lrd9")
    private WebElement storeLocator;

    // WebElement for the store locator link
    @FindBy(linkText = "Locate a Store")
    private WebElement storeLink;

    // WebElement for the cart link
    @FindBy(css = ".ActionLinksContainer--5xj1y5.gKkoeY > div:last-child")
    private WebElement cartLink;

    // WebElement for removing an item from the cart
    @FindBy(xpath = "//div[@class='Buttons--15b7dyn jAmxXC']//span[text()='Remove']")
    private WebElement removeItem;

    // WebElement for the chatbot iframe
    @FindBy(css = "iframe[name='spr-chat__box-frame']")
    public WebElement chatBotFrame;

    // WebElement for the chatbot box
    @FindBy(className = "spr-chat-box-anim-enter-done")
    public WebElement chatBotBox;

    // WebElement for the chatbot button
    @FindBy(id = "spr-chat__trigger-button")
    public WebElement chatBotButton;

    // WebElement for starting a new chat conversation
    @FindBy(css = "button[label='New Conversation']")
    public WebElement chatBotNewConversation;

    // WebElement for the welcome text of the chatbot
    @FindBy(css = "span[data-lucid-type='application/vnd.lucid.text']")
    public WebElement chatBotWelcomeText;

    // WebElement for more actions dropdown
    @FindBy(css = "button[aria-label='More actions']")
    public WebElement moreActions;

    // WebElement for selecting new conversation from more actions
    @FindBy(css = "div[data-testid='actionMenuList']>div")
    public WebElement newConversation;
    
    // WebElement for the sign-up link
    @FindBy(xpath = "//span[text()='Sign Up']")
    private WebElement signUpLink;
    
    // WebElement for the sign-up form
    @FindBy(css = "#sign-up-form")
    private WebElement signUpForm;
    
    // WebElement for the first name field in the sign-up form
    @FindBy(css = "input[placeholder='First Name*']")
    private WebElement fname;
    
    // WebElement for the last name field in the sign-up form
    @FindBy(css = "input[placeholder='Last Name']")
    private WebElement lname;
    
    // WebElement for the mobile number field in the sign-up form
    @FindBy(css = "input[placeholder='Mobile*']")
    private WebElement mobile;
    
    // WebElement for the email field in the sign-up form
    @FindBy(css = "input[placeholder='Email*']")
    private WebElement email;
    
    // WebElement for the password field in the sign-up form
    @FindBy(css = "input[placeholder='Password*']")
    private WebElement password;
    
    // WebElement for the create account button in the sign-up form
    @FindBy(xpath = "//button[text()='Create an Account']")
    private WebElement createBtn;
    
    // WebElement for the WhatsApp updates checkbox in the sign-up form
    @FindBy(css = "#whatsapp-updates")
    private WebElement waCheckbox;
    
    // WebElement for the sign-in link
    @FindBy(xpath = "//span[text()='Sign In']")
    private WebElement SignInLink;
    
    // WebElement for the sign-in form
    @FindBy(css = "#sign-in-form")
    private WebElement signInForm;
    
    // WebElement for the email/phone field in the sign-in form
    @FindBy(css = "input[name='emailOrPhone']")
    private WebElement loginEmail;
    
    // WebElement for the password field in the sign-in form
    @FindBy(css = "input[placeholder='Enter Password']")
    private WebElement loginPassword;
    
    // WebElement for the sign-in button in the sign-in form
    @FindBy(css = "button[id='remove-button']")
    private WebElement signInBtn;
    
    // WebElement for displaying the logged in username
    @FindBy(css = ".ActionLinksContainer--5xj1y5.gKkoeY > div:nth-child(2)")
    private WebElement loginUserName;
    
    // WebElement for displaying invalid email error
    @FindBy(css = "div[subtext]")
    private WebElement invalidEmailError;
    
    // WebElement for displaying email exists error
    @FindBy(css = ".ErrorField--6thwyh.ihTbJV")
    private WebElement emailExistsError;
    
    // WebElement for the create account button in the sign-in form
    @FindBy(css = "#remove-button")
    private WebElement createAccountBtn;

    // Method to enter text in the search box and perform search
    public HomePage enterSearchBox(String itemtext) {
        searchbox.sendKeys(itemtext, Keys.ENTER);
        delay(1);
        return this;
    }

    // Method to get the URL of the current page
    public String getUrl() {
        delay(1);
        return driver.getCurrentUrl();
    }
    
    // Method to hover over the store locator
    public HomePage hoverStoreLocator(WebDriver driver) {
        setWait(driver, 10).until(ExpectedConditions.visibilityOf(storeLocator));
        setActions(driver).moveToElement(storeLocator).build().perform();
        return this;
    }

    // Method to click on the store locator link
    public HomePage clickStoreLink() {
        storeLink.click();
        delay(3);
        return this;
    }

    // Method to click on the cart link and navigate to the Cart page
    public CartPage cartLink(WebDriver driver){
        cartLink.click();
        return PageFactory.initElements(driver, CartPage.class);
    }

    // Method to click on the chatbot icon
    public HomePage clickChatBotIcon() {
        wait.until(ExpectedConditions.visibilityOf(chatBotButton));
        chatBotButton.click();
        return this;
    }

    // Method to check if the chatbot is displayed
    public boolean isChatBotDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(chatBotBox));
        return chatBotBox.isDisplayed();
    }

    // Method to start a new chat conversation
    public HomePage startNewChat() {
        delay(2);
        driver.switchTo().frame(chatBotFrame);
        wait.until(ExpectedConditions.visibilityOf(chatBotNewConversation));
        chatBotNewConversation.click();
        return this;
    }

    // Method to check the welcome text of the chatbot
    public boolean checkChatBotWelcomeText() {
        wait.until(ExpectedConditions.visibilityOf(chatBotWelcomeText));
        return chatBotWelcomeText.getText().startsWith("Hello! Welcome to Lenskart");
    }

    // Method to click on a suggestion in the chatbot
    public HomePage clickChatSuggestion(String option) {
        delay(2);
        Helper.clickSuggestion(option);
        return this;
    }

    // Method to get assertion text
    public String getAssertionText(String assertionMessage) {
        delay(3);
        return Helper.checkAssertionText(assertionMessage);
    }

    // Method to click on more actions dropdown
    public HomePage clickMoreActions() {
        delay(2);
        moreActions.click();
        return this;
    }

    // Method to click on new conversation from more actions dropdown
    public HomePage clickNewConversation() {
        wait.until(ExpectedConditions.visibilityOf(newConversation));
        newConversation.click();
        return this;
    }
    
    // Method to click on the sign-up link
    public HomePage clickSignUp() {
        wait.until(ExpectedConditions.visibilityOf(signUpLink)).click();
        return this;
    }
    
    // Method to check if the sign-up form is displayed
    public boolean signUpFormDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(signUpForm)).isDisplayed();
    }
    
    // Method to set first name in the sign-up form
    public HomePage setFname(String fname) {
        wait.until(ExpectedConditions.visibilityOf(this.fname)).sendKeys(fname);
        return this;
    }
    
    // Method to set last name in the sign-up form
    public HomePage setLname(String lname) {
        wait.until(ExpectedConditions.visibilityOf(this.lname)).sendKeys(lname);
        return this;
    }
    
    // Method to set mobile number in the sign-up form
    public HomePage setMobile(String num) {
        wait.until(ExpectedConditions.visibilityOf(mobile)).sendKeys(num);
        return this;
    }
    
    // Method to set email in the sign-up form
    public HomePage setEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(this.email)).sendKeys(email);
        return this;
    }
    
    // Method to set password in the sign-up form
    public HomePage setPassword(String passwd) {
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(passwd);
        return this;
    }
    
    // Method to click on create account button in the sign-up form
    public HomePage clickCreateBtn() {
        wait.until(ExpectedConditions.visibilityOf(createBtn)).click();
        return this;
    }
    
    // Method to uncheck WhatsApp updates checkbox in the sign-up form
    public HomePage unCheckWaBox() {
        wait.until(ExpectedConditions.visibilityOf(waCheckbox)).click();
        return this;
    }
    
    // Method to get first name from the sign-up form
    public String getFname() {
        return this.fname.getAttribute("value");
    }
    
    // Method to get last name from the sign-up form
    public String getLname() {
        return this.lname.getAttribute("value");                    
    }
    
    // Method to get email from the sign-up form
    public String getEmail() {
        return this.email.getAttribute("value");
    }
    
    // Method to get password from the sign-up form
    public String getPassword() {
        return this.password.getAttribute("value");
    }
    
    // Method to get mobile number from the sign-up form
    public String getMobileNo() {
        return this.mobile.getAttribute("value");                
    }
    
    // Method to click on sign-in link
    public HomePage clickSignInLink() {
        wait.until(ExpectedConditions.visibilityOf(SignInLink)).click();
        return this;
    }
    
    // Method to check if sign-in form is displayed
    public boolean isSignInFormDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(signInForm)).isDisplayed();
    }
    
    // Method to set email in the sign-in form
    public HomePage setLoginEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(loginEmail)).sendKeys(email);
        return this;
    }
    
    // Method to set password in the sign-in form
    public HomePage setLoginPassword(String passwd) {
        wait.until(ExpectedConditions.visibilityOf(loginPassword)).sendKeys(passwd);
        return this;
    }
    
    // Method to click on sign-in button in the sign-in form
    public HomePage clickLoginFormBtn() {
        wait.until(ExpectedConditions.visibilityOf(signInBtn)).click();
        return this;
    }
    
    // Method to get the logged in username
    public String getLoginUserName() {
        delay(3);
        return wait.until(ExpectedConditions.visibilityOf(loginUserName)).getText();
    }
    
    // Method to get invalid email error message
    public String getInvalidEmailError() {
        delay(3);
        return wait.until(ExpectedConditions.visibilityOf(invalidEmailError)).getText();
    }
    
    // Method to get email exists error message
    public String getEmailExistsError() {
        delay(2);
        return wait.until(ExpectedConditions.visibilityOf(emailExistsError)).getText();
    }
    
    // Method to click on create account button in the sign-in form
    public HomePage clickCreateAccountBtn() {
        wait.until(ExpectedConditions.visibilityOf(createAccountBtn)).click();
        return this;
    }
}