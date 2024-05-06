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

public class SignUpValid {

	WebDriver driver = Hooks.driver;
	private HomePage homepage;

	@When("User clicks on the signup Link.")
	public void user_clicks_on_the_signup_link() {
		homepage = PageFactory.initElements(driver, HomePage.class);
		homepage.clickSignUp();
	}

	@Then("new window pop ups")
	public void new_window_pop_ups() {
		Assert.assertEquals(true, homepage.signUpFormDisplayed());
	}

	@Then("User fills all required feilds")
	public void user_fills_all_required_feilds(DataTable dataTable) {
	
		Map<String, String> formValues = dataTable.asMap();
		
		homepage.setFname(formValues.get("firstname"))
				.setLname(formValues.get("lastname"))
				.setMobile(formValues.get("mobile"))
				.setEmail(formValues.get("email"))
				.setPassword(formValues.get("password"))
				.unCheckWaBox();
						
		assertEquals(homepage.getFname(), formValues.get("firstname"));
		assertEquals(homepage.getLname(), formValues.get("lastname"));
		assertEquals(homepage.getMobileNo(), formValues.get("mobile"));
		assertEquals(homepage.getEmail(), formValues.get("email"));
		assertEquals(homepage.getPassword(), formValues.get("password"));
	
	}
	
	@Then("User clicks on Create an Account")
	public void user_clicks_on_create_an_account() {
	    homepage.clickCreateAccountBtn();
	}
	
	@Then("New user will be created")
	public void new_user_of_name_krishna_will_be_created() {
	    
	}
}
