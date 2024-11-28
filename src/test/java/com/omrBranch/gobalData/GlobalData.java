package com.omrBranch.gobalData;

import io.restassured.response.Response;
import lombok.Data;

@Data
public class GlobalData {
	
private Response response;
private String logToken;
private int stateId;
private int cityIdNum;
private String cityIdText;
private String stateIdText;
private String address;
private int statusCode;
private int address_id;

}
