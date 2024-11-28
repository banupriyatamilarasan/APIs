package com.omrBranch.stepdefinition;

import java.util.ArrayList;


import com.omrBranch.baseClass.BaseClass;
import com.omrBranch.endpoints.Endpoints;

import com.omrBranch.pojo.stateList.Datum;
import com.omrBranch.pojo.stateList.StateListAndCityList_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class TC002_StateListStep extends BaseClass {
	
	@Given("User add headers for to StateList")
	public void userAddHeadersForToStateList() {
		addHeader("accept","application/json");
		  
	}
	@When("User send {string} request for StateList endpoint")
	public void userSendRequestForStateListEndpoint(String string) {
		Response response = addReqType("GET", Endpoints.STATELIST);
		TC001_LoginStep.globalData.setResponse(response);
		
	    }

	@Then("User should verify the stateList response message matches {string} and saved state id")
	public void userShouldVerifyTheStateListResponseMessageMatchesAndSavedStateId(String stateName) {
		StateListAndCityList_Output_Pojo stateListAndCityList_Output_Pojo =TC001_LoginStep.globalData.getResponse().as(StateListAndCityList_Output_Pojo.class);
		ArrayList<Datum> stateList = stateListAndCityList_Output_Pojo.getData();
		for (Datum eachStateList : stateList) {
			String name = eachStateList.getName();
			System.out.println("Hello");
			if(name.equals(stateName)) {
				 int stateIdNum = eachStateList.getId();
				 String stateIdText=String.valueOf(stateIdNum);
				 TC001_LoginStep.globalData.setStateId(stateIdNum);
				 TC001_LoginStep.globalData.setStateIdText(stateIdText);
				 
				System.out.println(stateIdText);
				
				break;
				
		
	    }

			
}

		}
}
