package com.omrBranch.stepdefinition;

import org.junit.Assert;

import com.omrBranch.baseClass.BaseClass;
import com.omrBranch.endpoints.Endpoints;
import com.omrBranch.gobalData.GlobalData;
import com.omrbranch1.pojo.login.Login_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;



public class TC001_LoginStep extends BaseClass {
	public static GlobalData globalData=new GlobalData();
	@Given("User add header")
	public void userAddHeader() {
		addHeader("accept","application/json");
		 
	}
	@When("User add basic authentication for login")
	public void userAddBasicAuthenticationForLogin() {
		addBasicAuth("banupriyasr90@gmail.com","Banu@123");

	  
	}
	@When("User send {string} request for login endpoint")
	public void userSendRequestForLoginEndpoint(String string) {
	  
		Response response = addReqType("POST", Endpoints.LOGIN);
		globalData.setResponse(response);
	}
		@Then("User should verify the login response body firstName present as {string} and get the logtoken saved")
	public void userShouldVerifyTheLoginResponseBodyFirstNamePresentAsAndGetTheLogtokenSaved(String string) {
	   Login_Output_Pojo login_Output_Pojo = globalData.getResponse().as(Login_Output_Pojo.class);
	   String first_name = login_Output_Pojo.getData().getFirst_name();
	   String logtoken = login_Output_Pojo.getData().getLogtoken();
	   globalData.setLogToken(logtoken);
	   System.out.println(first_name);
	   Assert.assertEquals("Verify first name ", first_name, "Banupriya");
	}




}
