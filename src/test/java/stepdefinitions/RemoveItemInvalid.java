package stepdefinitions;

import com.ust.lenskart.pages.CartPage;
import com.ust.lenskart.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RemoveItemInvalid {
    WebDriver driver = Hooks.driver;
    HomePage homePage;
    CartPage cartpage;

    @When("User clicks on cart link")
    public void user_clicks_on_cart_link() {
        homePage = PageFactory.initElements(driver,HomePage.class);
        cartpage = homePage.cartLink(driver);

    }
    @Then("User sees {string}")
    public void user_sees(String expected) {
        Assert.assertEquals(cartpage.getEmptyCartText(),expected);
    }
}
