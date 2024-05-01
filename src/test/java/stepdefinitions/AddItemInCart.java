package stepdefinitions;

import com.ust.lenskart.pages.CartPage;
import com.ust.lenskart.pages.HomePage;
import com.ust.lenskart.pages.ProductPage;
import com.ust.lenskart.pages.ShoppingPage;
import com.ust.lenskart.utils.CucumberTestConfig;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertEquals;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddItemInCart {

    // WebDriver instance obtained from Hooks
    WebDriver driver = Hooks.driver;
    
    // Configuration properties from CucumberTestConfig
    protected static final CucumberTestConfig cucumberconfig = ConfigFactory.create(CucumberTestConfig.class);

    private ShoppingPage shoppingpage;
    private String baseWindow;
    private String[] modelNumber;
    private String model;


    // Step definitions
    @When("User search for Aviator")
    public void user_search_for_aviator() {
        // Get the base window handle
        baseWindow = driver.getWindowHandle();
        
        // Initialize the HomePage
        HomePage homepage;
        homepage = PageFactory.initElements(driver, HomePage.class);
        
        // Perform search for the product
        homepage.enterSearchBox(cucumberconfig.getProductName());
    }
    
    @Then("User selects a Product")
    public void user_selects_a_product() {
        // Select a product from the search results
        PageFactory.initElements(driver, ProductPage.class).selectProduct();

    }
    
    @Then("User on product page")
    public void user_on_product_page() {
        // Initialize ShoppingPage with base window handle
        shoppingpage = new ShoppingPage(driver,baseWindow);
        
        // Get model number of the product
        model = shoppingpage.getModelNo();
        
        // Split model number to check in URL
        modelNumber = model.toLowerCase().split(" ");
        
        // Assert that the URL contains the model number
        Assert.assertEquals(true, driver.getCurrentUrl()
        									.contains(String.join("-", modelNumber)));
        
    }
    
    @Then("User clicks on Buy Now")
    public void user_clicks_on_buy_now() {
    	
        // Click on Buy Now button
        shoppingpage.clickBuyNow();
        
        // Assert that a new window is opened
        Assert.assertNotEquals(driver.getWindowHandle(), baseWindow);
    }
    
    @Then("User will successfully add item to the Cart")
    public void user_will_successfully_add_item_to_the_cart() {
        // Initialize CartPage
        CartPage cartpage = PageFactory.initElements(driver,CartPage.class);
        
        // Assert that the model is present in the cart
        assertEquals(true, cartpage.getModelFromCart().contains(model));
    }
}
