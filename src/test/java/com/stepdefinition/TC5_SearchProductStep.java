package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.Utility.BaseClassAPI1;
import com.endpoints.EndPonits;
import com.manager.PayloadManager;
import com.pojo.product.SearchProduct_Input_Pojo;
import com.pojo.product.SearchProduct_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC5_SearchProductStep extends BaseClassAPI1{
	public static PayloadManager payloadManager=new PayloadManager();
	
	Response response;
	@Given("User add header for to SearchProduct endpoint")
	public void userAddHeaderForToSearchProductEndpoint() {
      List<Header> listHeader=new ArrayList<>();
      Header h1=new Header("accept","application/json");
      Header h2=new Header("Content-Type","application/json");
	  listHeader.add(h1);
	  listHeader.add(h2);
	  Headers headers=new Headers(listHeader);
	  addHeaders(headers);
	
	}
	@When("User add request body for search product {string}")
	public void userAddRequestBodyForSearchProduct(String text) {
       SearchProduct_Input_Pojo searchProduct_Input_Pojo = payloadManager.getProductPayLoad().searchProduct(text);
       addBody(searchProduct_Input_Pojo);
			}
	@When("User send {string} request for searchProduct endpoint")
	public void userSendRequestForSearchProductEndpoint(String reqType) {
	response = addReqType(reqType, EndPonits.SEARCHPRODUCT);
	int statusCode = response.getStatusCode();
	TC1_LoginStep.globalData.setStatuscode(statusCode);
	
	}
	
	@Then("User should verify the SearchProduct response message matches {string}")
	public void userShouldVerifyTheSearchProductResponseMessageMatches(String expMessage) {
    SearchProduct_Output_Pojo searchProduct_Output_Pojo = response.as(SearchProduct_Output_Pojo.class); 
	String actMessage1 = searchProduct_Output_Pojo.getMessage();
	System.out.println(actMessage1);
	Assert.assertEquals("verify status",expMessage, actMessage1); 
	}



	
	



}
