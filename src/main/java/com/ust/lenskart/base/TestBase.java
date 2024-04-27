package com.ust.lenskart.base;

import java.time.Duration;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ust.lenskart.utils.TestConfig;

public class TestBase {

	// Stores the configuration properties from TestConfig.class
	protected static final TestConfig testconfig = ConfigFactory.create(TestConfig.class);

	// WebDriver instance used for browser interaction
	protected static WebDriver driver;

	// WebDriverWait object for implicit waits during test execution
	protected static WebDriverWait wait;

	// Actions object for simulating user interactions
	protected static Actions actions;

	// Select object used for interacting with dropdown menus
	protected static Select select;

	/**
	 * Initializes the WebDriver, WebDriverWait, Actions, and navigates to the test
	 * URL.
	 */
	public static void appInit() {
		driver = invokeBrowser();
		wait = setWait(driver, 10);
		actions = setActions(driver);
	}

	/**
	 * Creates a WebDriverWait object with a specified wait timeout.
	 * 
	 * @param driver  The WebDriver instance to use for waiting.
	 * @param seconds The wait timeout in seconds.
	 * @return A new WebDriverWait object.
	 */
	public static WebDriverWait setWait(WebDriver driver, int seconds) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		return wait;
	}

	/**
	 * Creates an Actions object to perform user interactions on the web page.
	 * 
	 * @param driver The WebDriver instance to use for interactions.
	 * @return A new Actions object.
	 */
	public static Actions setActions(WebDriver driver) {
		actions = new Actions(driver);
		return actions;
	}

	/**
	 * Navigates the WebDriver to the Lenskart URL obtained from the TestConfig
	 * class.
	 */
	public static void navigateTo() {
		String url = testconfig.getUrl();
		driver.navigate().to(url);
	}

	/**
	 * Launches the browser based on the configuration (currently supports Chrome
	 * and Edge).
	 * 
	 * @return A new WebDriver instance for the chosen browser.
	 */
	public static WebDriver invokeBrowser() {

		String browser = testconfig.getBrowser();

		switch (browser) {

			case "chrome":
				ChromeOptions chromeoptions = new ChromeOptions();
				chromeoptions.addArguments("--disable-notifications", "--start-maximized");
				chromeoptions.addArguments("--guest");
				return new ChromeDriver(chromeoptions);

			case "edge":
				EdgeOptions edgeoptions = new EdgeOptions();
				edgeoptions.addArguments("--disable-notifications", "--start-maximized");
				edgeoptions.addArguments("--guest");
				return new EdgeDriver(edgeoptions);

			default:
				System.out.println("Browser not configured: " + browser);
				return null;

		}

	}

	public static void delay(int num) {
		try {
			Thread.sleep(num * 1000);
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}
	
//	public static void switchToFrame(WebElement frame) {
//		driver.switchTo().frame(frame);
//	}
}
