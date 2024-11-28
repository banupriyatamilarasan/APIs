package com.omrBranch.stepdefinition;

import java.util.ArrayList;
import java.util.List;

//import org.junit.Assert;

import org.testng.Assert;

import com.omrBranch.baseClass.BaseClass;
import com.omrBranch.endpoints.Endpoints;
import com.omrBranch.pojo.stateList.SearchProduct_Input_Pojo;
import com.omrBranch.pojo.stateList.SearchProduct_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC005_ProductSearchStep extends BaseClass{

	@Given("User add headers for search product")
	public void userAddHeadersForSearchProduct() {
		List<Header>lstHeader=new ArrayList<>();
		Header h1 = new Header("accept","application/json");
		Header h2 = new Header("Content-Type","application/json");
		lstHeader.add(h1);
		lstHeader.add(h2);
		Headers headers=new Headers(lstHeader);
		addHeaders(headers);
		
	    }
	@When("User add request body for search product {string}")
	public void userAddRequestBodyForSearchProduct(String string) {
		SearchProduct_Input_Pojo search=new SearchProduct_Input_Pojo(string);
		addBody(search);
	   }
	@When("User send {string} request for search product endpoint")
	public void userSendRequestForSearchProductEndpoint(String string) {
		Response response = addReqType("POST",Endpoints.PRODUCTLIST);
		TC001_LoginStep.globalData.setResponse(response);
	   }
	
	@Then("User should verify the search product response message matches {string} and category id saved")
	public void userShouldVerifyTheSearchProductResponseMessageMatchesAndCategoryIdSaved(String string) {
		SearchProduct_Output_Pojo product_Output_Pojo =TC001_LoginStep.globalData.getResponse() .as(SearchProduct_Output_Pojo.class);
		String message = product_Output_Pojo.getMessage();
		System.out.println(message);
		Assert.assertEquals( message,"OK","Verify ok msg" );

	   }



}
