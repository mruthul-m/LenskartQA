package com.ust.lenskart.utils;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ExtentManager {
	public static ExtentReports er;
	public static ExtentSparkReporter Reporter;
	
	public static ExtentReports createInstance() throws IOException {
		
		String repname="TestReport-"+ getTime()+".html";
		Reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports_Folder//"+repname);
		Reporter.loadXMLConfig(System.getProperty("user.dir")+"\\src\\test\\resources\\extent-config1.xml");
		er = new ExtentReports();
		er.attachReporter(Reporter);
		er.setSystemInfo("OS", "Windows");
		er.setSystemInfo("Host Name", "localhost");
		er.setSystemInfo("Environment", "QA");
		er.setSystemInfo("User Name", "Akshay");
		return er;
	}
	
	public static String getTime() {
		return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	}
}