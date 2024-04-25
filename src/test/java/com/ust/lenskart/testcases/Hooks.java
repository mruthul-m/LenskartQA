package com.ust.lenskart.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.ust.lenskart.base.TestBase;

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
