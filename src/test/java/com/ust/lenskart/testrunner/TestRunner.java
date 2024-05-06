package com.ust.lenskart.testrunner;

//import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = "stepdefinitions",
				features = "src/test/resources"
				,tags = "@AddToCart")
public class TestRunner extends AbstractTestNGCucumberTests{
	
//	 	@Override
//	    @DataProvider(parallel = true)
//	    public Object[][] scenarios() {
//	        return super.scenarios();
//	    }

}
