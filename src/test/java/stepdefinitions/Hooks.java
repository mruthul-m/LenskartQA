package stepdefinitions;


import org.openqa.selenium.WebDriver;

import com.ust.lenskart.base.ReusableFunctions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

// Hooks class to manage setup and teardown operations for scenarios
public class Hooks extends ReusableFunctions {
	
	// Static WebDriver instance shared across steps
	public static WebDriver driver;

	// Method to execute before each scenario
	@Before
	public static void setup() {
		// Initialize WebDriver and navigate to the application URL
		appInit();
		driver = ReusableFunctions.driver;
		navigateTo();
	}
	
	// Method to execute after each scenario
	@After
	public static void tearDown(Scenario scenario) {
		String filePath = 					System.getProperty("user.dir")+"/Screenshots/Feature/"+scenario.getName();
		//validate if scenario has failed
		if(scenario.isFailed()) {
			takeScreenshot(filePath+"_failed.png");
		}	
		
		tearDown();
	}
}
