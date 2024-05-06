package stepdefinitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ust.lenskart.pages.HomePage;

import io.cucumber.java.en.Then;

// Step definition class for the invalid login scenario
public class LoginInvalid {
    // WebDriver instance obtained from the Hooks class
	WebDriver driver = Hooks.driver;
	// Instance of the HomePage class
	HomePage homepage = PageFactory.initElements(driver, HomePage.class);
	
	// Step to enter wrong email
	@Then("User enters wrong email {string}")
	public void user_enters_wrong_email(String email) {
	    // Set the wrong email in the login form and click login button
	    homepage
	    	.setLoginEmail(email)
	    	.clickLoginFormBtn();
	}
	
	// Step to verify error message for invalid email
	@Then("User get {string} as error")
	public void user_get_as_error(String error) {
	    // Assert that the displayed error message matches the expected error
	    assertEquals(error, homepage.getInvalidEmailError());
	}
}