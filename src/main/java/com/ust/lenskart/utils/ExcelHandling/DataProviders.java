package com.ust.lenskart.utils.ExcelHandling;

import org.testng.annotations.DataProvider;
import com.ust.lenskart.base.TestBase;

// This class provides data for TestNG tests from an Excel sheet
public class DataProviders extends TestBase {
	
    // DataProvider method named "chatBotSuggestion"
	@DataProvider(name = "chatBotSuggestion")
	public String[][] getData() {
        // Get the path of the Excel file containing test data
		String path = System.getProperty("user.dir")+"/src/main/resources/testdata/ChatBot Chat Suggestions.xlsx";
        
        // Get the sheet name from configuration
		String Sheetname = testconfig.getSheetName();
        
        // Create an object of XLutility to handle Excel operations
		XLutility xl = new XLutility(path,Sheetname);
        
        // Get the total number of rows in the Excel sheet
		int rownum=xl.getRowCount();
        
        // Get the total number of columns in the first row of the Excel sheet
		int colnum=xl.getCellCount(1);
        
        // Create a 2D array to store Excel data
		String[][] arr=new String[rownum][colnum];
        
        // Loop through each row of the Excel sheet
		for (int i=1;i<=rownum;i++) {
            // Loop through each column of the current row
			for (int j=0;j<colnum;j++) {
                // Get the data from the current cell and store it in the array
				arr[i-1][j]=xl.getCellData(i, j);
			}
		}
        
        // Return the 2D array containing Excel data
		return arr;
	}
}