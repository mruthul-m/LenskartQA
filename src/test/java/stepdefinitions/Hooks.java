package stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.ust.lenskart.base.TestBase;

import io.cucumber.java.After;
import io.cucumber.java.Before;

// Hooks class to manage setup and teardown operations for scenarios
public class Hooks extends TestBase {
	
	// Static WebDriver instance shared across steps
	public static WebDriver driver;

	// Method to execute before each scenario
	@Before
	public static void setup() {
		// Initialize WebDriver and navigate to the application URL
		appInit();
		driver = TestBase.driver;
		navigateTo();
	}
	
	// Method to execute after each scenario
	@After
	public void quitDriver() {
		// Quit the WebDriver instance
		driver.quit();
	}
}
