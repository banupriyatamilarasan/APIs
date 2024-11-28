package com.omrBranch.pojo.stateList;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchProduct_Output_Pojo {
	private int status;
	private String message;
	private ArrayList<SearchProduct_Output> data;
	private String currency;
	}


