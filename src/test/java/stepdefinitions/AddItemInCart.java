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

    WebDriver driver = Hooks.driver;
    protected static final CucumberTestConfig cucumberconfig = ConfigFactory.create(CucumberTestConfig.class);

    private ShoppingPage shoppingpage;
    private String baseWindow;
    private String[] modelNumber;
    private String model;


    @When("User search for Aviator")
    public void user_search_for_aviator() {
        baseWindow = driver.getWindowHandle();
        HomePage homepage;
        homepage = PageFactory.initElements(driver, HomePage.class);
        homepage.enterSearchBox(cucumberconfig.getProductName());
    }
    @Then("User selects a Product")
    public void user_selects_a_product() {
        PageFactory.initElements(driver, ProductPage.class).selectProduct();

    }
    @Then("User on product page")
    public void user_on_product_page() {
        shoppingpage = new ShoppingPage(driver,baseWindow);
        model = shoppingpage.getModelNo();
        modelNumber = model.toLowerCase().split(" ");
        Assert.assertEquals(true, driver.getCurrentUrl()
        									.contains(String.join("-", modelNumber)));
        
        

    }
    @Then("User clicks on Buy Now")
    public void user_clicks_on_buy_now() {
    	shoppingpage.getModelNo();
        shoppingpage.clickBuyNow();
        Assert.assertNotEquals(driver.getWindowHandle(), baseWindow);
    }
    @Then("User will successfully add item to the Cart")
    public void user_will_successfully_add_item_to_the_cart() {
        CartPage cartpage = PageFactory.initElements(driver,CartPage.class);
        assertEquals(true, cartpage.getModelFromCart().contains(model));
        

    }
}
