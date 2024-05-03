package stepdefinitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ust.lenskart.pages.HomePage;

import io.cucumber.java.en.Then;

public class LoginInvalid {
	WebDriver driver = Hooks.driver;
	HomePage homepage = PageFactory.initElements(driver, HomePage.class);
	@Then("User enters wrong email {string}")
	public void user_enters_wrong_email(String email) {
	    homepage
	    	.setLoginEmail(email)
	    	.clickLoginFormBtn();
	}
	@Then("User get {string} as error")
	public void user_get_as_error(String error) {
	    assertEquals(error, homepage.getInvalidEmailError());
	}
}
