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

public class BookAppointmentTest  {
	
	WebDriver driver = Hooks.driver;
	protected static final CucumberTestConfig cucumberconfig = ConfigFactory.create(CucumberTestConfig.class);
	private HomePage homepage;
	private StorePage storepage;
	String parentWindow;
	String url;

	@Given("User already on homepage")
	public void user_already_on_homepage() {
		homepage = PageFactory.initElements(driver, HomePage.class);
		url = driver.getCurrentUrl();
        assertEquals(url, "https://www.lenskart.com/");
	}

	@When("User hover over store locator and clicks locate a store")
	public void user_hover_over_store_locator_and_clicks_locate_a_store() {
		homepage.hoverStoreLocator(driver).clickStoreLink();
		String url = driver.getCurrentUrl();
        assertEquals(url, "https://www.lenskart.com/stores");
	}

	@Then("User on store page")
	public void user_on_store_page() {
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if (! window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
		storepage = PageFactory.initElements(driver, StorePage.class);
		assertTrue(storepage.isSearchBoxVisible());
	
	}

	@Then("User searches {string} and selects the first suggestion")
	public void user_searches_and_selects_the_first_suggestion(String city) {
			storepage.setCity(city).clickCity();
				
			
	}

	@Then("User book a free appointment from the top most list")
	public void user_book_a_free_appointment_from_the_top_most_list() {
		String output = 
		storepage.clickBookAppointment().setDetails(cucumberconfig.userName(),
						cucumberconfig.getNumber())
		.clickBooking().selectShift().getConfirmationText();

        assertEquals(output, "Appointment Confirmed");
	}

}
