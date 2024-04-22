package com.ust.lenskart.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.ust.lenskart.base.TestBase;

public class Hooks extends TestBase{
	
	@BeforeTest
	public void setup() {
		appInit();
	}
	
	@BeforeClass
	public void pageLoader() {
		navigateTo();
	}
	
	@AfterClass
	public void quitDriver() {
		driver.quit();
	}

}
