package com.omrBranch.pojo.stateList;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserAddress_Input_Pojo {
    private int status;
    private String message;
    private ArrayList<GetUserAddress_Output_Pojo> data;
}

