package com.ust.lenskart.testrunner;



//import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(glue = "stepdefinitions",
				features = "src/test/resources",
				tags = "@removeItemNegative",
				plugin = { "pretty",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"timeline:test-output-thread",
						"json:Reports/cucumber-reports/Cucumber.json",
						"junit:Reports/cucumber-reports/Cucumber.xml",
						"html:Reports/cucumber-reports/index.html"},
				monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests{
	
//	 	@Override
//	    @DataProvider(parallel = true)
//	    public Object[][] scenarios() {
//	        return super.scenarios();
//	    }

}
