package com.ust.lenskart.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import com.ust.lenskart.base.TestBase;
import com.ust.lenskart.utils.ExtentReportsListener;

@Listeners(ExtentReportsListener.class)
public class Hooks extends TestBase {

	@BeforeClass
	public void pageLoader() {
		appInit();
		navigateTo();
	}

	@AfterClass
	public void quitDriver() {
		driver.quit();
	}


}
