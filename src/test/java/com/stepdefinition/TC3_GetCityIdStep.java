package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import com.Utility.BaseClassAPI1;
import com.endpoints.EndPonits;
import com.manager.PayloadManager;
import com.pojo.address.CityList;
import com.pojo.address.CityList_Input_pojo;
import com.pojo.address.CityList_Output_pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC3_GetCityIdStep extends BaseClassAPI1{

	Response response;
    public static PayloadManager payloadManager=new PayloadManager();
	
	@Given("User add headers for to CityList")
	public void userAddHeadersForToCityList() {
	List<Header> listHeader=new ArrayList<>();
	Header h1=new Header("accept", "application/json");
	Header h2=new Header("Content-Type","application/json");
    listHeader.add(h1);
    listHeader.add(h2);
	Headers headers=new Headers(listHeader);
	addHeaders(headers);	
	}

	
	@When("User add Request body for CityList to get StateId")
	public void userAddRequestBodyForCityListToGetStateId() {
	CityList_Input_pojo cityList_Input_pojo = payloadManager.getAddresspayload().cityList(TC1_LoginStep.globalData.getState_id());
   	addBody(cityList_Input_pojo);	
	}


	@When("User send {string} request for CityList endpoint")
	public void userSendRequestForCityListEndpoint(String reqType) {
	response = addReqType(reqType, EndPonits.CITYLIST);
    int statusCode = response.statusCode();
	System.out.println(statusCode);
	TC1_LoginStep.globalData.setStatuscode(statusCode);
	
	}
	
	@Then("User verify the CityList response message matches {string} and saved City id")
	public void userVerifyTheCityListResponseMessageMatchesAndSavedCityId(String expCityName) {
	 CityList_Output_pojo cityList_Output_pojo = response.as(CityList_Output_pojo.class);
	 ArrayList<CityList> cityList = cityList_Output_pojo.getData();
	 for (CityList eachCityList : cityList) {
		String cityName = eachCityList.getName();
	    if (cityName.equals(expCityName)) {
			int cityIdNum = eachCityList.getId();
		 TC1_LoginStep.globalData.setCity_id_int(cityIdNum);
		 String cityId = String.valueOf(cityIdNum);
	     TC1_LoginStep.globalData.setCity_id(cityId);   
	    break;
	    }
	 
	 }
		
	
	}



	

	
	



}
