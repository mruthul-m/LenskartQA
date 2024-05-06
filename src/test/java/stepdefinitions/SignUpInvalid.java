package stepdefinitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ust.lenskart.pages.HomePage;

import io.cucumber.java.en.Then;

// Step definition class for the invalid sign-up scenario
public class SignUpInvalid {
    // WebDriver instance obtained from the Hooks class
	WebDriver driver = Hooks.driver;
	// Instance of the HomePage class
	HomePage homepage;
	
	// Step to verify error message for invalid sign-up
	@Then("User gets {string} as error")
	public void user_gets_as_error(String error) {
	    // Initialize the HomePage object using PageFactory
	    homepage = PageFactory.initElements(driver, HomePage.class);
	    // Assert that the displayed error message contains the expected error
	    assertEquals(true, homepage.getEmailExistsError().contains(error));
	}
}