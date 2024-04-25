package com.ust.lenskart.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = "stepdefinitions",
				features = "classpath:features")
public class TestRunner extends AbstractTestNGCucumberTests{

}
