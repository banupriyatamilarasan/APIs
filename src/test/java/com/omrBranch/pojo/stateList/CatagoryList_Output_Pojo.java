package com.omrBranch.pojo.stateList;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatagoryList_Output_Pojo {
	public int status;
    public String message;
    public ArrayList<CatagoryList_Output> data;

}
