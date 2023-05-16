package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.Utility.BaseClassAPI1;
import com.endpoints.EndPonits;
import com.manager.PayloadManager;
import com.pojo.address.AddUserAddress_Input_pojo;
import com.pojo.address.AddUserAddress_Output_pojo;
import com.pojo.address.DeleteUserAddress_Input_Pojo;
import com.pojo.address.DeleteUserAddress_Output_Pojo;
import com.pojo.address.GetUserAddress_Output_Pojo;
import com.pojo.address.UpdateUserAddress_Input_Pojo;
import com.pojo.address.UpdateUserAddress_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC4_AddressStep extends BaseClassAPI1 {

	Response response;
	public static PayloadManager payLoadManager = new PayloadManager();
	// Add user address
	@Given("User add header and bearer authorization for accessing address endpoints")
	public void userAddHeaderAndBearerAuthorizationForAccessingAddressEndpoints() {
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalData.getLogtoken());
		Header h3 = new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);

	}
	
	@When("User add requestbody for add new address {string},{string},{string},{string}, {int} , {int} , {int} ,{string},{string} and {string}")
	public void userAddRequestbodyForAddNewAddressAnd(String first_name, String last_name, String mobile, String apartment, int state, int city, int country, String zipcode, String address, String address_type) {
      AddUserAddress_Input_pojo addUserAddress_Input_pojo = payLoadManager.getAddresspayload().addUserAddress(first_name, last_name, mobile, apartment, state, city, country, zipcode, address, address_type);
      addBody(addUserAddress_Input_pojo);
	
	}

	@When("User send {string} request for addUserAddress endpoint")
	public void userSendRequestForAddUserAddressEndpoint(String reqType) {
		response = addReqType(reqType, EndPonits.ADDUSERADDRESS);
		int statusCode = response.getStatusCode();
		TC1_LoginStep.globalData.setStatuscode(statusCode);
	}

	@Then("User verify the addUserAddress response message matches {string}")
	public void userVerifyTheAddUserAddressResponseMessageMatches(String expMessage) {
		AddUserAddress_Output_pojo addUserAddress_Output_pojo = response.as(AddUserAddress_Output_pojo.class);
		String actMessage = addUserAddress_Output_pojo.getMessage();
		Assert.assertEquals("Verify status message", expMessage, actMessage);
		int address_id_Num = addUserAddress_Output_pojo.getAddress_id();
		String address_Id = String.valueOf(address_id_Num);
		TC1_LoginStep.globalData.setAddress_Id(address_Id);
	}

	// Update user address
	@When("User add requestbody for update user address {string},{string},{string},{string},{string}, {int} , {int} , {int} ,{string},{string} and {string}")
	public void userAddRequestbodyForUpdateUserAddressAnd(String address_id, String first_name, String last_name, String mobile, String apartment, int state, int city, int country, String zipcode, String address, String address_type) {
      UpdateUserAddress_Input_Pojo updateUserAddress_Input_Pojo = payLoadManager.getAddresspayload().updateUserAddress(TC1_LoginStep.globalData.getAddress_Id(), first_name, last_name, mobile, apartment, state, city, country, zipcode, address, address_type);
      addBody(updateUserAddress_Input_Pojo);
	}

	@When("User send {string} request for updateUserAddress endpoint")
	public void userSendRequestForUpdateUserAddressEndpoint(String reqType) {
		response = addReqType(reqType, EndPonits.UPDATEUSERADDRESS);
		int statusCode = response.getStatusCode();
		TC1_LoginStep.globalData.setStatuscode(statusCode);
	}

	@Then("User verify the updateUserAddress response message matches {string}")
	public void userVerifyTheUpdateUserAddressResponseMessageMatches(String expMessage) {
		UpdateUserAddress_Output_Pojo userAddress_Output_Pojo = response.as(UpdateUserAddress_Output_Pojo.class);
		String actMessage = userAddress_Output_Pojo.getMessage();
		Assert.assertEquals("Verify the status Message", expMessage, actMessage);

	}

	// get user address
	

	@Given("User add header and bearer authorization for accessing address endpoints for get user address")
	public void userAddHeaderAndBearerAuthorizationForAccessingAddressEndpointsForGetUserAddress() {

		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalData.getLogtoken());
		listHeader.add(h1);
		listHeader.add(h2);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);
	}
	
	@When("User send {string} request for getUserAddress endpoint")
	public void userSendRequestForGetUserAddressEndpoint(String reqType) {
        response = addReqType(reqType, EndPonits.GETUSERADDRESS);
		int statusCode = response.getStatusCode();
		TC1_LoginStep.globalData.setStatuscode(statusCode);
	}

	@Then("User verify the getUserAddress response message matches {string}")
	public void userVerifyTheGetUserAddressResponseMessageMatches(String expMessage) {
            GetUserAddress_Output_Pojo getUserAddress_Output_Pojo = response.as(GetUserAddress_Output_Pojo.class);
            String actMessage = getUserAddress_Output_Pojo.getMessage();
            Assert.assertEquals("Verify the status Message ",expMessage,actMessage);
		
	}
// delete user Address

	@When("User add requestbody for delete user address {string}")
	public void userAddRequestbodyForDeleteUserAddress(String address_id) {
        DeleteUserAddress_Input_Pojo deleteUserAddress_Input_Pojo = payLoadManager.getAddresspayload().deleteUserAddress(TC1_LoginStep.globalData.getAddress_Id());
		addBody(deleteUserAddress_Input_Pojo);
		
	}

	@When("User send {string} request for deleteUserAddress endpoint")
	public void userSendRequestForDeleteUserAddressEndpoint(String reqType) {
		response = addReqType(reqType, EndPonits.DELETEADDRESS);
		  int statusCode = response.getStatusCode();
	      TC1_LoginStep.globalData.setStatuscode(statusCode);
		
	}

	@Then("User verify the deleteUseraddress response message matches {string}")
	public void userVerifyTheDeleteUseraddressResponseMessageMatches(String expMessage) {
      DeleteUserAddress_Output_Pojo deleteUserAddress_Output_Pojo = response.as(DeleteUserAddress_Output_Pojo.class);
      String actMessage = deleteUserAddress_Output_Pojo.getMessage();
      Assert.assertEquals("Verify status code",expMessage,actMessage);	
	}

}
