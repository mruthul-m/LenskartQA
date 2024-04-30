package com.ust.lenskart.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ust.lenskart.pages.HomePage;
import com.ust.lenskart.utils.ExcelHandling.DataProviders;
import com.ust.lenskart.utils.ExcelHandling.XLutility;

public class TestChatBot extends Hooks {
	HomePage homePage;
	
	@Test(priority=0)
	public void testEnterSearchBox() {
		homePage = PageFactory.initElements(driver, HomePage.class);
		assertEquals(testconfig.getUrl(), homePage.getUrl());
	}
	
    @Test(priority=1)
    public void testChatBot() {
    	homePage.clickChatBotIcon();
    	assertTrue(homePage.isChatBotDisplayed());
    }
    
    @Test(priority=2,dependsOnMethods = "testChatBot")
    public void testChatNewConversation() {
        homePage.startNewChat();
        assertTrue(homePage.checkChatBotWelcomeText());
    }
    
    @Test(priority=3,dependsOnMethods = "testChatNewConversation", dataProvider = "chatBotSuggestion",dataProviderClass = DataProviders.class)
    public void testChatBotSuggestion(String suggestion,String assertionMessage) {
    	homePage.clickChatSuggestion(suggestion);
        assertEquals(assertionMessage,homePage.getAssertionText(assertionMessage));
        delay(2);
        homePage.clickMoreActions().clickNewConversation();
        
    }
}