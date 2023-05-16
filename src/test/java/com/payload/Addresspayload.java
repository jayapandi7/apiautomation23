package com.payload;

import com.pojo.address.AddUserAddress_Input_pojo;
import com.pojo.address.CityList_Input_pojo;
import com.pojo.address.DeleteUserAddress_Input_Pojo;
import com.pojo.address.UpdateUserAddress_Input_Pojo;

public class Addresspayload {

	public AddUserAddress_Input_pojo addUserAddress(String first_name, String last_name, String mobile,
			String apartment, int state, int city, int country, String zipcode, String address, String address_type) {
		AddUserAddress_Input_pojo address_Input_pojo = new AddUserAddress_Input_pojo(first_name, last_name, mobile,
				apartment, state, city, country, zipcode, address, address_type);
		return address_Input_pojo;
	}

	public CityList_Input_pojo cityList(String state_id) {
		CityList_Input_pojo cityList_Input_pojo = new CityList_Input_pojo(state_id);
     return cityList_Input_pojo;
	}

	public UpdateUserAddress_Input_Pojo updateUserAddress(String address_id, String first_name, String last_name, String mobile,
			String apartment, int state, int city, int country, String zipcode, String address, String address_type) {
		UpdateUserAddress_Input_Pojo updateUserAddress_Input_Pojo = new UpdateUserAddress_Input_Pojo(address_id,
				first_name, last_name, mobile, apartment, state, city, country, zipcode, address, address_type);
          return updateUserAddress_Input_Pojo;
	}

	public DeleteUserAddress_Input_Pojo deleteUserAddress(String address_id) {
		DeleteUserAddress_Input_Pojo deleteUserAddress_Input_Pojo=new DeleteUserAddress_Input_Pojo(address_id);
        return deleteUserAddress_Input_Pojo; 
	}
	
	
	
	
}
