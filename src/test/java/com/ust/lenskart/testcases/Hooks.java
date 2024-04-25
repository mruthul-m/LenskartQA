package com.ust.lenskart.testcases;

import org.testng.annotations.*;

import com.ust.lenskart.base.TestBase;

public class Hooks extends TestBase {
	
@BeforeClass
public void startup() {
	appInit();
}

//@AfterClass
//public void teardown() {
//    driver.quit();
//}
}
