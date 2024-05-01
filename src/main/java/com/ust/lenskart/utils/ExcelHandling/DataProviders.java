package com.ust.lenskart.utils.ExcelHandling;


import org.testng.annotations.DataProvider;

import com.ust.lenskart.base.TestBase;

public class DataProviders extends TestBase {
	@DataProvider(name = "chatBotSuggestion")
	public String[][] getData() {
		String path = System.getProperty("user.dir")+"/src/main/java/com/ust/lenskart/testdata/ChatBot Chat Suggestions.xlsx";
		String Sheetname = testconfig.getSheetName();
		XLutility xl = new XLutility(path,Sheetname);
		int rownum=xl.getRowCount();
		int colnum=xl.getCellCount(1);
		String[][] arr=new String[rownum][colnum];
		for (int i=1;i<=rownum;i++) {
			for (int j=0;j<colnum;j++) {
				arr[i-1][j]=xl.getCellData(i, j);
			}
		}
		return arr;
	}
}
