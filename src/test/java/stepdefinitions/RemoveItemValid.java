package stepdefinitions;

import static org.testng.Assert.assertEquals;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ust.lenskart.pages.CartPage;
import com.ust.lenskart.utils.CucumberTestConfig;

import io.cucumber.java.en.Then;

public class RemoveItemValid {
	
	private WebDriver driver = Hooks.driver;
	private CartPage cartpage;
	protected static final CucumberTestConfig cucumberconfig = ConfigFactory.create(CucumberTestConfig.class);
	
	@Then("User goto the homepage")
	public void user_goto_the_homepage() {
	  cartpage =  PageFactory.initElements(driver,CartPage.class);
	  cartpage.gotoHomePage();
	  assertEquals( cucumberconfig.getUrl(), driver.getCurrentUrl());
	}

    @Then("User removes an Item from the cart")
    public void user_removes_an_item_from_the_cart() {
    	cartpage.removeItemFromCart();
    	assertEquals(false, cartpage.ItemIsPresent());
    }
}
