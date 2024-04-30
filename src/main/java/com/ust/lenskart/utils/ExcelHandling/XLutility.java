package com.ust.lenskart.utils.ExcelHandling;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLutility {
	public FileInputStream f1;
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	String path;
	String Sheetname;
	
	public XLutility(String path, String Sheetname){
		this.path = path;
        this.Sheetname = Sheetname;
	}
	public int getRowCount() {
		try {
			f1=new FileInputStream(path);
			wb=new XSSFWorkbook(f1);
			sheet=wb.getSheet(Sheetname);
			int rowCount=sheet.getLastRowNum();
			wb.close();
			f1.close();
			return rowCount;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int getCellCount(int rowNum) {
		try {
			f1=new FileInputStream(path);
			wb=new XSSFWorkbook(f1);
			sheet=wb.getSheet(Sheetname);
			row=sheet.getRow(rowNum);
			int cellCount=row.getLastCellNum();
			wb.close();
			f1.close();
			return cellCount;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public String getCellData(int rowNum, int colNum) {
        try {
        	f1=new FileInputStream(path);
    		wb=new XSSFWorkbook(f1);
    		sheet=wb.getSheet(Sheetname);
    		row=sheet.getRow(rowNum);
    		cell=row.getCell(colNum);
    		DataFormatter formatter=new DataFormatter();
    		String data;
    		data=formatter.formatCellValue(cell);
    		wb.close();
    		f1.close();
    		return data;
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
		return null;
    }
}
