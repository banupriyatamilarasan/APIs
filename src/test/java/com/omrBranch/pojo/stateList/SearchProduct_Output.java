package com.omrBranch.pojo.stateList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchProduct_Output {
	private String image;
	private String type;
	private String text;
	private int id;
	private int category_id;


}
