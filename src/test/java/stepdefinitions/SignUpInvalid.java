package stepdefinitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ust.lenskart.pages.HomePage;

import io.cucumber.java.en.Then;

public class SignUpInvalid {
	WebDriver driver = Hooks.driver;
	HomePage homepage;
	
	@Then("User gets {string} as error")
	public void user_gets_as_error(String error) {
	    homepage = PageFactory.initElements(driver, HomePage.class);
	    assertEquals(true, homepage.getEmailExistsError().contains(error));
	}
}
