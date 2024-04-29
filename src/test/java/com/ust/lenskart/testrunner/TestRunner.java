package com.ust.lenskart.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = "stepdefinitions",
				features = "src/test/resources", tags = "@removeItemPositive")
public class TestRunner extends AbstractTestNGCucumberTests{

}
