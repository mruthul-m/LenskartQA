package stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ust.lenskart.pages.HomePage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

// Step definition class for the login feature
public class LoginValid {
	
    // WebDriver instance obtained from the Hooks class
	WebDriver driver = Hooks.driver;
	// Instance of the HomePage class
	HomePage homepage;
	
	// Step to click on the sign-in link
	@When("User clicks on signIn Link")
	public void user_clicks_on_sign_in_link() {
	    // Initialize the HomePage object using PageFactory
		homepage = PageFactory.initElements(driver, HomePage.class);
		// Click on the sign-in link
		homepage.clickSignInLink();
		// Assert that the sign-in form is displayed
		assertEquals(true, homepage.isSignInFormDisplayed());   
	}
	
	// Step to enter email and password and login
	@Then("User enters email and password and logins")
	public void user_enters_email_and_password_and_logins(DataTable dataTable) {
	    // Get login credentials as a map from DataTable
	    Map<String, String> loginCredential = dataTable.asMap();
	    // Perform login actions
	    homepage
	        .setLoginEmail(loginCredential.get("email"))
	        .clickLoginFormBtn()
	        .setLoginPassword(loginCredential.get("password"))
	        .clickLoginFormBtn();  
	}
	
	// Step to verify successful login
	@Then("{string} will be loggedIn to their homepage")
	public void will_be_logged_in_to_their_homepage(String userName) { 
	    // Assert that the username is displayed on the homepage
	    assertEquals(true,homepage.getLoginUserName().contains(userName));
	}
}