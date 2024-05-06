package com.ust.lenskart.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.ust.lenskart.base.TestBase;

public class Hooks extends TestBase {

	//runs before each test class
	@BeforeClass
	public void pageLoader() {
		appInit();
		navigateTo();
	}

	//runs after each test class
	@AfterClass
	public void quitDriver() {
		driver.quit();
	}


}
