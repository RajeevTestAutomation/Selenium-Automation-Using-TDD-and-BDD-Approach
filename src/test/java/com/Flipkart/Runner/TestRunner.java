package com.Flipkart.Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="features",
		glue={"stepDefinition"},
		plugin={"html:target/FlipkartNormal-html-report","json:target/cucumber.json","pretty:target/cucumber-pretty.txt","usage:target/cucumber-usage.json"})

        //  tags="~@blocked",

        //  dryRun= false,
       // monochrome= true,
       //  stric=true,
       // snippets=SnippetType.CAMELCASE



public class TestRunner {
	
	/*
	 @AfterClass
	    public static void setup() {
	       Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
	     Reporter.setSystemInfo("user", System.getProperty("user.name"));
	        Reporter.setSystemInfo("os", "Windows");
	        Reporter.setTestRunnerOutput("Sample test runner output message");
	       // Reporter.addStepLog("pass");
	        
	       // Reporter.getExtentReport().createTest("Rajeev", "description").log(Status.FAIL, "details");
	        
	        

}

*/


}
