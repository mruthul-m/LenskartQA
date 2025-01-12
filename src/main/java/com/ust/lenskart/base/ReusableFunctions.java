package com.ust.lenskart.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.ust.lenskart.utils.DriverIsNotChanged;
import com.ust.lenskart.utils.TestConfig;

public class ReusableFunctions {


  // Load the configuration properties
  protected static final TestConfig testconfig = ConfigFactory.create(TestConfig.class);

  // WebDriver instance used for browser interaction
  protected static WebDriver driver;

  // WebDriverWait object for implicit waits during test execution
  protected static WebDriverWait wait;

  // Actions object for simulating user interactions
  protected static Actions actions;

  // Select object used for interacting with dropdown menus
  protected static Select select;

  // Initialize WebDriver, WebDriverWait, and Actions
  public static void appInit() {
    driver = invokeBrowser();
    wait = setWait(driver, 10);
    actions = setActions(driver);
  }

  // Create a WebDriverWait object with a specified wait timeout
  public static WebDriverWait setWait(WebDriver driver, int seconds) {
    return new WebDriverWait(driver, Duration.ofSeconds(seconds));

  }

  // Create an Actions object to perform user interactions on the web page
  public static Actions setActions(WebDriver driver) {
    return new Actions(driver);
  }

  // Navigate to the specified URL
  public static void navigateTo() {
    String url = testconfig.getUrl();
    driver.navigate().to(url);
  }

  // Launch the browser based on the configuration
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

  // Introduce a forced delay in test execution for a specified number of seconds
  // Note: This method uses Thread.sleep() which can cause tests to become brittle and unreliable
  public static void delay(int num) {
    try {
      Thread.sleep(num * 1000);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  // Switch the focus of the WebDriver to a different browser window
  public static WebDriver changeWindow(WebDriver driver, String parentWindow)
      throws DriverIsNotChanged {
    Set<String> windows = driver.getWindowHandles();
    for (String window : windows) {
      if (!window.equals(parentWindow)) {
        driver.switchTo().window(window);
        return driver;
      }
    }
    throw new DriverIsNotChanged(String.format("Driver is not changed, still: %s", parentWindow));
  }

  // driver teardown
  public static void tearDown() {
    driver.quit();
  }

  // Method to capture screenshot
  public static void takeScreenshot(String filepath) {
    TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
    File srcFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
    File destFile = new File(filepath);
    try {
      FileUtils.copyFile(srcFile, destFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Method to set implicit wait
  public static void setImplicitWait(int seconds) {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
  }


}
