package stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ust.lenskart.pages.HomePage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginValid {
	
	WebDriver driver = Hooks.driver;
	HomePage homepage;
	
	@When("User clicks on signIn Link")
	public void user_clicks_on_sign_in_link() {
		homepage = PageFactory.initElements(driver, HomePage.class);
		homepage.clickSignInLink();
		assertEquals(true, homepage.isSignInFormDisplayed());
	    
	}
	@Then("User enters email and password and logins")
	public void user_enters_email_and_password_and_logins(DataTable dataTable) {
	    Map<String, String> loginCredential = dataTable.asMap();
	    homepage
	    		.setLoginEmail(loginCredential.get("email"))
	    		.clickLoginFormBtn()
	    		.setLoginPassword(loginCredential.get("password"))
	    		.clickLoginFormBtn();
	    
	   
	}
	@Then("{string} will be loggedIn to their homepage")
	public void will_be_logged_in_to_their_homepage(String userName) { 
	    assertEquals(true,homepage.getLoginUserName().contains(userName));
	}

}
