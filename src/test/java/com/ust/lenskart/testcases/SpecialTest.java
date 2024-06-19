package com.ust.lenskart.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;


import com.ust.lenskart.pages.CartPage;
import com.ust.lenskart.pages.HomePage;

public class SpecialTest extends Hooks{
		
	HomePage homepage;
	CartPage cartpage;
	
	@Test(priority = 1)
	public void gotoCart() {
		homepage = PageFactory.initElements(driver, HomePage.class);
		cartpage =  homepage.cartLink(driver);
	}
	
	@Test(priority = 2)
	public void getColor() {
		String text = cartpage.getShoppingText();
		assertEquals("Continue Shopping", text);
		System.out.println(cartpage.getColor());
	}

}
