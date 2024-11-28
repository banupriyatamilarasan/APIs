package com.omrBranch.stepdefinition;



import org.junit.Assert;

import com.omrBranch.baseClass.BaseClass;

import io.cucumber.java.en.Then;

public class CommonStep  extends BaseClass{
	@Then("User should verify the status code is {int}")
	public void userShouldVerifyTheStatusCodeIs(Integer expectedStatusCode) {
		int statusCode = getStatusCode(TC001_LoginStep.globalData.getResponse());
		System.out.println(statusCode);
		Assert.assertEquals("Verify status code",statusCode,200);
		
	}


}
