package com.ust.lenskart.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

// Manager class for Extent Reports
public class ExtentManager {
    
    public static ExtentReports er;
    public static ExtentSparkReporter reporter;
    
    // Creates an instance of ExtentReports
    public static ExtentReports createInstance() throws IOException {
        String reportName = "TestReport-" + getTime() + ".html";
        reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/testng-reports/" + reportName);
        reporter.loadXMLConfig(System.getProperty("user.dir") + "/src/test/resources/extent-config.xml");
        er = new ExtentReports();
        er.attachReporter(reporter);
        er.setSystemInfo("OS", "Windows");
        er.setSystemInfo("Host Name", "localhost");
        er.setSystemInfo("Environment", "QA");
        er.setSystemInfo("User Name", "team-04");
        return er;
    }
    
    // Gets the current time
    public static String getTime() {
        return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    }
}