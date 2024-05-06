package stepdefinitions;

import static org.testng.Assert.assertEquals;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ust.lenskart.pages.CartPage;
import com.ust.lenskart.utils.CucumberTestConfig;

import io.cucumber.java.en.Then;

// Step definition class for removing an item from the cart
public class RemoveItemValid {
    // WebDriver instance obtained from the Hooks class
    private WebDriver driver = Hooks.driver;
    // Instance of the CartPage class
    private CartPage cartpage;
    // Instance of the CucumberTestConfig for accessing configuration
    protected static final CucumberTestConfig cucumberconfig = ConfigFactory.create(CucumberTestConfig.class);
    
    // Step to navigate to the homepage
    @Then("User goto the homepage")
    public void user_goto_the_homepage() {
        // Initialize the CartPage object using PageFactory
        cartpage =  PageFactory.initElements(driver,CartPage.class);
        // Navigate to the homepage
        cartpage.gotoHomePage();
        // Assert that the current URL matches the homepage URL from the configuration
        assertEquals(cucumberconfig.getUrl(), driver.getCurrentUrl());
    }

    // Step to remove an item from the cart
    @Then("User removes an Item from the cart")
    public void user_removes_an_item_from_the_cart() {
        // Remove an item from the cart
        cartpage.removeItemFromCart();
        // Assert that the item is no longer present in the cart
        assertEquals(false, cartpage.ItemIsPresent());
    }
}