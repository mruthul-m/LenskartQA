package stepdefinitions;

import com.ust.lenskart.pages.CartPage;
import com.ust.lenskart.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

// Step definition class for the scenario where removing an item from the cart is invalid
public class RemoveItemInvalid {
    // WebDriver instance obtained from the Hooks class
    WebDriver driver = Hooks.driver;
    // Instance of the HomePage class
    HomePage homePage;
    // Instance of the CartPage class
    CartPage cartpage;

    // Step to click on the cart link
    @When("User clicks on cart link")
    public void user_clicks_on_cart_link() {
        // Initialize the HomePage object using PageFactory
        homePage = PageFactory.initElements(driver,HomePage.class);
        // Navigate to the cart page
        cartpage = homePage.cartLink(driver);
    }

    // Step to verify a specific message is displayed
    @Then("User sees {string}")
    public void user_sees(String expected) {
        // Assert that the displayed text in the cart matches the expected text
        Assert.assertEquals(cartpage.getEmptyCartText(),expected);
    }
}
