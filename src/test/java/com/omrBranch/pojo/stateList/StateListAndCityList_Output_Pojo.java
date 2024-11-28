package com.omrBranch.pojo.stateList;

import java.util.ArrayList;

//import com.omr.APIBaseClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateListAndCityList_Output_Pojo{
    private int status;
    private String message;
    private ArrayList<Datum> data;
}


