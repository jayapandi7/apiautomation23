package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.report.JVMReports;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags=" ",monochrome=true, dryRun=false, snippets=io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE,plugin= {"pretty","json:target\\OMRBranchGrocery.json"},features="src\\test\\resources\\Features",glue="com.stepdefinition")
public class TestRunnerClass {
	
	@AfterClass
	public static void afterExecution() {
     JVMReports.generateJVMReport(System.getProperty("user.dir")+"\\target\\OMRBranchGrocery.json");
	}

	
}
