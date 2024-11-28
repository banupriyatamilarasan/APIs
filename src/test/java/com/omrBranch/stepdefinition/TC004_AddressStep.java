package com.omrBranch.stepdefinition;

import java.util.ArrayList;
import java.util.List;

//import org.testng.Assert;

import org.junit.Assert;

import com.omrBranch.baseClass.BaseClass;
import com.omrBranch.endpoints.Endpoints;

import com.omrBranch.pojo.stateList.AddUpdateUserAddress_Input_Pojo;
import com.omrBranch.pojo.stateList.AddUpdateUserAddress_Output_Pojo;
import com.omrBranch.pojo.stateList.AddUserAddress_Input_Pojo;
import com.omrBranch.pojo.stateList.AddUserAddress_Output_Pojo;
import com.omrBranch.pojo.stateList.DeleteAddress;
import com.omrBranch.pojo.stateList.GetUserAddress_Input_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC004_AddressStep extends BaseClass {
	
	@Given("User add header and bearer authorization for accessing address endpoints")
	public void userAddHeaderAndBearerAuthorizationForAccessingAddressEndpoints() {
		List<Header>lstHeader=new ArrayList<>();
		Header h1 = new Header("accept","application/json");
		Header h2 = new Header("Authorization","Bearer "+TC001_LoginStep.globalData.getLogToken() );
		Header h3 = new Header("Content-Type","application/json");
		lstHeader.add(h1);
		lstHeader.add(h2); 
		
		lstHeader.add(h3);
		Headers headers=new Headers(lstHeader);
		addHeaders(headers);
		
	   }
	@When("User add request body for add new address {string},{string},{string},{string},{string},{string},{string},{string},{string},and {string}")
	public void userAddRequestBodyForAddNewAddressAnd(String fistName, String lastName, String mobileNo,
			String apptName, String stateId, String cityId, String countryId, String zipCode, String address,
			String addressType) {
		
		AddUserAddress_Input_Pojo addressPayload2 = TC003_CityListStep.addressPayload.addAddressPayload(fistName, lastName, mobileNo, apptName, stateId, cityId, countryId, zipCode, address, addressType);
		addBody(addressPayload2);
		
		  
	}
	@When("User send {string} request for addUserAddress endpoint")
	public void userSendRequestForAddUserAddressEndpoint(String string) {
		Response response = addReqType("POST", Endpoints.ADDADDRESS);
		TC001_LoginStep.globalData.setResponse(response);
		
	    }
	@Then("User should verify the addUserAddress response message matches {string} and get the address id saved")
	public void userShouldVerifyTheAddUserAddressResponseMessageMatchesAndGetTheAddressIdSaved(String string) {
		AddUserAddress_Output_Pojo address_Output_Pojo =TC001_LoginStep.globalData.getResponse() .as(AddUserAddress_Output_Pojo.class);
		
		String actmessage = address_Output_Pojo.getMessage();
	int	address_id = address_Output_Pojo.getAddress_id();
	String address = String.valueOf(address_id);
	TC001_LoginStep.globalData.setAddress_id(address_id);
	TC001_LoginStep.globalData.setAddress(address);
		System.out.println(actmessage);
		Assert.assertEquals("Address added successfully",actmessage,"verify success message");

	}
	
	
	
	
//	UpdateAddress
	@When("User add request body to update new address {string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userAddRequestBodyToUpdateNewAddressAnd(String mobileNo, String apptName, String stateId, String cityId, String countryId, String zipCode, String address,
			String addressType) {
				AddUpdateUserAddress_Input_Pojo updateAddressPayload = TC003_CityListStep.addressPayload.updateAddressPayload(TC001_LoginStep.globalData.getAddress(), apptName, apptName, mobileNo, apptName, stateId, cityId, countryId, zipCode, address, addressType);
		 addBody(updateAddressPayload);
	    }	
	@When("User send {string} request for update addUserAddress endpoint")
	public void userSendRequestForUpdateAddUserAddressEndpoint(String string) {
		Response response = addReqType("PUT", Endpoints.UPDATEUSERADDRESS);
		TC001_LoginStep.globalData.setResponse(response);
	    }
	@Then("User verify the update address response message matches {string}")
	public void userVerifyTheUpdateAddressResponseMessageMatches(String string) {
		AddUpdateUserAddress_Output_Pojo address_Output_Pojo = TC001_LoginStep.globalData.getResponse().as(AddUpdateUserAddress_Output_Pojo.class);
		
		String actmessage = address_Output_Pojo.getMessage();
		System.out.println(actmessage);
		Assert.assertEquals("Address updated successfully",actmessage,"verify update success message");

	    }

	@Given("User add Headers and Bearer authorization for accessing Get address endpoints")
	public void userAddHeadersAndBearerAuthorizationForAccessingGetAddressEndpoints() {
		List<Header>lstHeader=new ArrayList<>();
		Header h1 = new Header("accept","application/json");
		Header h2 = new Header("Authorization","Bearer "+TC001_LoginStep.globalData);
	
		lstHeader.add(h1);
		lstHeader.add(h2); 
		

		Headers headers=new Headers(lstHeader);
		addHeaders(headers);
		

	   }
	@When("User Send {string} request for GetUserAddress endpoint")
	public void userSendRequestForGetUserAddressEndpoint(String string) {
		Response response = addReqType("GET", Endpoints.GETUSERADDRESS);
		addBody(response);
	   }
	@Then("User verify the GetUserAddress response message matches {string}")
	public void userVerifyTheGetUserAddressResponseMessageMatches(String string) {
		GetUserAddress_Input_Pojo getUserAddress_Input_Pojo = TC001_LoginStep.globalData.getResponse().as(GetUserAddress_Input_Pojo.class);
		String message = getUserAddress_Input_Pojo.getMessage();
		Assert.assertEquals("OK",message, "Verify ok msg");
		
	    }
	//Delete
	@When("User add request body for address id")
	public void userAddRequestBodyForAddressId() {
	addBody(TC003_CityListStep.addressPayload.deleteAddress(TC001_LoginStep.globalData.getAddress()));	

	   }
	@When("User Send {string} request for DeleteAddress endpoint")
	public void userSendRequestForDeleteAddressEndpoint(String string) {
		Response response = addReqType("DELETE",Endpoints.DELETEUSERADDRESS); 
		TC001_LoginStep.globalData.setResponse(response);
	}
	@Then("User verify the DeleteAddress response message matches {string}")
	public void userVerifyTheDeleteAddressResponseMessageMatches(String string) {
		DeleteAddress deleteAddress = TC001_LoginStep.globalData.getResponse().as(DeleteAddress.class);
		String message = deleteAddress.getMessage();
		Assert.assertEquals( "Address deleted successfully",message, "Verify delete msg");
	   
	}
}