package com.omrBranch.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.omrBranch.baseClass.BaseClass;
import com.omrBranch.report.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

	@RunWith(Cucumber.class)
	@CucumberOptions(tags="@Login or @StateList or @CityList or @Address",stepNotifications = true, publish=true, monochrome = true,   snippets = SnippetType.CAMELCASE, dryRun=false,plugin = {"pretty", "json:target//output.json","json:target//output.html"},glue="com.omrBranch.stepdefinition",features="src\\test\\resources")
	public class TestRunner extends BaseClass{

		@AfterClass
		public static void afterClass() {
			 Reporting.generateJVMReport(getProjectPath()+"\\target\\output.json");

		}
	}



