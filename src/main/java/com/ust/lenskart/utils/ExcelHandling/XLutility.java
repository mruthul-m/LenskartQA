package com.ust.lenskart.utils.ExcelHandling;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// Utility class for handling Excel operations
public class XLutility {
    // File input stream to read Excel file
    public FileInputStream f1;
    // Workbook instance to work with Excel
    public XSSFWorkbook wb;
    // Sheet instance to access Excel sheet
    public XSSFSheet sheet;
    // Row instance to access Excel row
    public XSSFRow row;
    // Cell instance to access Excel cell
    public XSSFCell cell;
    // Path of the Excel file
    String path;
    // Name of the Excel sheet
    String Sheetname;
    
    // Constructor to initialize path and sheet name
    public XLutility(String path, String Sheetname){
        this.path = path;
        this.Sheetname = Sheetname;
    }
    
    // Method to get the total number of rows in the Excel sheet
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
    
    // Method to get the total number of cells in a specified row of the Excel sheet
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
    
    // Method to get the data from a specified cell in the Excel sheet
    public String getCellData(int rowNum, int colNum) {
        try {
            f1=new FileInputStream(path);
            wb=new XSSFWorkbook(f1);
            sheet=wb.getSheet(Sheetname);
            row=sheet.getRow(rowNum);
            cell=row.getCell(colNum);
            // Using DataFormatter to get formatted cell value (handles different cell types)
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