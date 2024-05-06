package com.ust.lenskart.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ust.lenskart.pages.HomePage;
import com.ust.lenskart.utils.ExcelHandling.DataProviders;



public class TestChatBot extends Hooks {
	//declares a variable of type HomePage
	HomePage homePage;

	//Tests whether the site is navigating to correct url
	@Test(priority=0)
	public void testEnterSearchBox() {
		homePage = PageFactory.initElements(driver, HomePage.class);
		assertEquals(homePage.getUrl(),testconfig.getUrl());
	}
	
	//Tests whether the chatbot is displayed when the chatbot button is clicked
    @Test(priority=1,dependsOnMethods ="testEnterSearchBox" )
    public void testChatBot() {
    	homePage.clickChatBotIcon();
    	assertTrue(homePage.isChatBotDisplayed());
    }
    
    //Tests whether the chatbot welcome text is displayed correctly when a new chat is started
    @Test(priority=2,dependsOnMethods = "testChatBot")
    public void testChatNewConversation() {
        homePage.startNewChat();
        assertTrue(homePage.checkChatBotWelcomeText());
    }
    
    //Tests whether the chatbot responses are displayed correctly when a new chat is started 
    @Test(priority=3,dependsOnMethods = "testChatNewConversation", dataProvider = "chatBotSuggestion",dataProviderClass = DataProviders.class)
    public void testChatBotSuggestion(String suggestion,String assertionMessage) {
    	homePage.clickChatSuggestion(suggestion);
        assertEquals(assertionMessage,homePage.getAssertionText(assertionMessage));
        delay(2);
        homePage.clickMoreActions().clickNewConversation();
        
    }
}