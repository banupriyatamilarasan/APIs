package com.omrBranch.pojo.stateList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClearCart {
	private int status;
	private String message;
	private int cart_count;

}
