package stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ust.lenskart.pages.HomePage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

// Step definition class for the valid sign-up scenario
public class SignUpValid {

	// WebDriver instance obtained from the Hooks class
	WebDriver driver = Hooks.driver;
	// Instance of the HomePage class
	private HomePage homepage;

	// Step to click on the sign-up link
	@When("User clicks on the signup Link.")
	public void user_clicks_on_the_signup_link() {
		// Initialize the HomePage object using PageFactory
		homepage = PageFactory.initElements(driver, HomePage.class);
		// Click on the sign-up link
		homepage.clickSignUp();
	}

	// Step to verify new window pop-ups
	@Then("new window pop ups")
	public void new_window_pop_ups() {
		// Assert that the sign-up form is displayed
		Assert.assertEquals(true, homepage.signUpFormDisplayed());
	}

	// Step to fill all required fields in the sign-up form
	@Then("User fills all required feilds")
	public void user_fills_all_required_feilds(DataTable dataTable) {
		// Get form values as a map from DataTable
		Map<String, String> formValues = dataTable.asMap();
		// Fill the sign-up form with provided values
		homepage.setFname(formValues.get("firstname")).setLname(formValues.get("lastname"))
				.setMobile(formValues.get("mobile")).setEmail(formValues.get("email"))
				.setPassword(formValues.get("password")).unCheckWaBox();

		// Assert that the filled values match the provided values
		assertEquals(homepage.getFname(), formValues.get("firstname"));
		assertEquals(homepage.getLname(), formValues.get("lastname"));
		assertEquals(homepage.getMobileNo(), formValues.get("mobile"));
		assertEquals(homepage.getEmail(), formValues.get("email"));
		assertEquals(homepage.getPassword(), formValues.get("password"));
	}

	// Step to click on the "Create an Account" button
	@Then("User clicks on Create an Account")
	public void user_clicks_on_create_an_account() {
		homepage.clickCreateAccountBtn();
	}

	// Step to verify new user creation
	@Then("New user will be created")
	public void new_user_of_name_krishna_will_be_created() {
		// Assertion or verification for new user creation can be added here
	}
}