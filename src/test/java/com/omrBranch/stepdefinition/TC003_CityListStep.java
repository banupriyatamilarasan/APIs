package com.omrBranch.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import com.omrBranch.baseClass.BaseClass;
import com.omrBranch.endpoints.Endpoints;
import com.omrBranch.payload.address.AddressPayload;
import com.omrBranch.pojo.stateList.CityList_Intput_Pojo;
import com.omrBranch.pojo.stateList.Datum;
import com.omrBranch.pojo.stateList.StateListAndCityList_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;


public class TC003_CityListStep extends BaseClass{
	 public static AddressPayload addressPayload = new AddressPayload();
	@Given("User add header  for to get CityList")
	public void userAddHeaderForToGetCityList() {
		List<Header>lstHeader=new ArrayList<>();
		Header h1 = new Header("accept","application/json");
		Header h2 = new Header("Content-Type","application/json");
		lstHeader.add(h1);
		lstHeader.add(h2);
		Headers headers=new Headers(lstHeader);
		addHeaders(headers);
		
	    }
	@When("User add request body state id for  get city list")
	public void userAddRequestBodyStateIdForGetCityList() {
		AddressPayload cityInputList=new AddressPayload();
		CityList_Intput_Pojo cityPayload = cityInputList.addCityPayload(TC001_LoginStep.globalData.getStateIdText());
		addBody(cityPayload);
		
		}
	
	@When("User send {string} request for CityList endpoint")
	public void userSendRequestForCityListEndpoint(String string) {
		Response response = addReqType("POST",Endpoints.CITYLIST);
		TC001_LoginStep.globalData.setResponse(response);
	    
	    }
	@Then("User verify the cityList response message matches {string} and saved city id")
	public void userVerifyTheCityListResponseMessageMatchesAndSavedCityId(String string) {
		StateListAndCityList_Output_Pojo stateListAndCityList_Output_Pojo = TC001_LoginStep.globalData.getResponse().as(StateListAndCityList_Output_Pojo.class);
		ArrayList<Datum> cityList = stateListAndCityList_Output_Pojo.getData();
		for (Datum eachCityList :cityList ) {
			String cityName = eachCityList.getName();
			//System.out.println("Hello");
			if(cityName.equals("Yarkaud")) {
				int cityIdNum= eachCityList.getId();
				String cityIdText=String.valueOf(cityIdNum);
				TC001_LoginStep.globalData.setCityIdText(cityIdText);
				System.out.println(cityIdNum);
				
				break;
		
	    }

		}
		}

}
