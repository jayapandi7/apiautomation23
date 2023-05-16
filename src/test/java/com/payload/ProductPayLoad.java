package com.payload;

import com.pojo.product.SearchProduct_Input_Pojo;

public class ProductPayLoad {
	
	public SearchProduct_Input_Pojo searchProduct(String text) {
		SearchProduct_Input_Pojo searchProduct_Input_Pojo=new SearchProduct_Input_Pojo(text);
       return searchProduct_Input_Pojo;
	}

}
