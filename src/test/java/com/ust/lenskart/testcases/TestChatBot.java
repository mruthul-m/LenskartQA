package com.ust.lenskart.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ust.lenskart.pages.HomePage;

public class TestChatBot extends Hooks {
	HomePage homePage;
	int count=0;
	@DataProvider (name = "chatBotSuggestions")
	public String[][] getData() {
		File f = new File(System.getProperty("user.dir")+"/src/main/java/com/ust/lenskart/testdata/ChatBot Chat Suggestions.xlsx");
		System.out.println(f);
		String Sheetname = testconfig.getSheetName();
		try {
			Workbook wb = new XSSFWorkbook(f);
			Sheet sheet = wb.getSheet(Sheetname);
			int rowCount = sheet.getPhysicalNumberOfRows();
			Row row = sheet.getRow(0);
			int colCount =  row.getPhysicalNumberOfCells();
			String arr[][] = new String[rowCount-1][colCount]; 
			for (int i = 1; i < rowCount; i++) {
				for(int j =0;j<colCount;j++) {
				DataFormatter df  =  new DataFormatter();
				arr[i-1][j] = df.formatCellValue(sheet.getRow(i).getCell(j));
				}
			}
			wb.close();
			return arr;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
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
    
    @Test(priority=3,dependsOnMethods = "testChatNewConversation",dataProvider = "chatBotSuggestions")
    public void testChatBotSuggestion(String suggestion,String assertionMessage) {
    	homePage.clickChatSuggestion(suggestion);
        assertEquals(assertionMessage,homePage.getAssertionText(assertionMessage));
        delay(2);
        homePage.clickMoreActions();
        homePage.clickNewConversation();
        
    }
}