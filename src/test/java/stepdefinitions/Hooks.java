package stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.ust.lenskart.base.TestBase;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends TestBase{
	
	public static WebDriver driver;
	@Before
	public static void setup() {
		appInit();
		driver = TestBase.driver;
		navigateTo();
	}
	
	@After
	public void quitDriver() {
		driver.quit();
	}
}
