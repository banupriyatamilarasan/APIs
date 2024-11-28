package com.omrBranch.product;

import com.omrBranch.pojo.stateList.SearchProduct_Input_Pojo;

public class ProductPayload {
	SearchProduct_Input_Pojo addproductSearchPayload(String text) {
		SearchProduct_Input_Pojo searchProduct_Input_Pojo=new SearchProduct_Input_Pojo(text);
		return searchProduct_Input_Pojo;
		
	
}
}
