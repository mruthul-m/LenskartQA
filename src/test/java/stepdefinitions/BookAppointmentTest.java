package stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Set;

import com.ust.lenskart.utils.CucumberTestConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ust.lenskart.pages.HomePage;
import com.ust.lenskart.pages.StorePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

// Step definition class for booking an appointment
public class BookAppointmentTest  {
    // WebDriver instance obtained from the Hooks class
	WebDriver driver = Hooks.driver;
	// Instance of the CucumberTestConfig for accessing configuration
	protected static final CucumberTestConfig cucumberconfig = ConfigFactory.create(CucumberTestConfig.class);
	// Instance of the HomePage class
	private HomePage homepage;
	// Instance of the StorePage class
	private StorePage storepage;
	String parentWindow;
	String url;

	// Step to ensure the user is already on the homepage
	@Given("User already on homepage")
	public void user_already_on_homepage() {
	    // Initialize the HomePage object using PageFactory
		homepage = PageFactory.initElements(driver, HomePage.class);
		// Get the current URL of the page
		url = driver.getCurrentUrl();
		// Assert that the current URL matches the homepage URL
        assertEquals(url, "https://www.lenskart.com/");
	}

	// Step to hover over store locator and click locate a store
	@When("User hover over store locator and clicks locate a store")
	public void user_hover_over_store_locator_and_clicks_locate_a_store() {
	    // Hover over store locator and click locate a store
		homepage.hoverStoreLocator(driver).clickStoreLink();
		// Get the current URL of the page
		String url = driver.getCurrentUrl();
		// Assert that the current URL matches the store page URL
        assertEquals(url, "https://www.lenskart.com/stores");
	}

	// Step to verify user is on store page
	@Then("User on store page")
	public void user_on_store_page() {
	    // Switch to the newly opened window
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if (! window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
		// Initialize the StorePage object using PageFactory
		storepage = PageFactory.initElements(driver, StorePage.class);
		// Assert that the search box is visible on the store page
		assertTrue(storepage.isSearchBoxVisible());
	}

	// Step to search for a city and select the first suggestion
	@Then("User searches {string} and selects the first suggestion")
	public void user_searches_and_selects_the_first_suggestion(String city) {
	    // Search for the city and click on the first suggestion
		storepage.setCity(city).clickCity();
	}

	// Step to book a free appointment from the topmost list
	@Then("User book a free appointment from the top most list")
	public void user_book_a_free_appointment_from_the_top_most_list() {
	    // Perform booking appointment actions and get the confirmation text
		String output = 
		storepage.clickBookAppointment().setDetails(cucumberconfig.getNumber(),
					cucumberconfig.userName())
		.clickBooking().selectShift().getConfirmationText();
		// Assert that the confirmation text matches the expected output
        assertEquals(output, "Appointment Confirmed");
	}

}