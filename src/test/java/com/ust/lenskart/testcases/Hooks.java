package com.ust.lenskart.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import com.ust.lenskart.base.ReusableFunctions;
import com.ust.lenskart.utils.ExtentReportsListener;

@Listeners(ExtentReportsListener.class)
public class Hooks extends ReusableFunctions {


	//runs before each test class
	@BeforeClass
	public void pageLoader() {		
		appInit();
		navigateTo();
	}

	//runs after each test class
	@AfterClass
	public void quitDriver() {
		tearDown();
	}


}
