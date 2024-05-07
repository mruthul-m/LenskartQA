package com.ust.lenskart.utils;


import java.io.IOException;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.ust.lenskart.base.TestBase;

// Listener for Extent Reports
public class ExtentReportsListener extends TestBase implements ITestListener {
    
    public ExtentReports extent;
    public ExtentTest test;
    
    // Executed at the start of the test suite
    public void onStart(ITestContext context) {
        try {
            extent = ExtentManager.createInstance();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Executed before each test method
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }
    
    // Executed when a test method passes
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test case passed");
        test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
        String[] folderName = result.getInstanceName().split("\\.");
        String className = folderName[folderName.length - 1];
        String testName = result.getName();
        String filepath = System.getProperty("user.dir") + "//ScreenShots/" + className + "/" + testName + "//" + testName + "_passed.png";
        try {
            takeScreenshot(filepath);
            test.log(Status.PASS, "Adding screenshot...");
            test.addScreenCaptureFromPath(filepath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Executed when a test method fails
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test case Failed");
        test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
        String[] folderName = result.getInstanceName().split("\\.");
        String className = folderName[folderName.length - 1];
        String testName = result.getName();
        String filepath = System.getProperty("user.dir") + "//ScreenShots/" + className + "/" + testName + "//" + testName + "_failed.png";
        try {
            takeScreenshot(filepath);
            test.log(Status.FAIL, "Adding screenshot...");
            test.addScreenCaptureFromPath(filepath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Executed when a test method is skipped
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test case Skipped");
        test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.AMBER));
    }
    
    // Executed at the end of the test suite
    public void onFinish(ITestContext context) {
        extent.flush();
    }
    
   
}