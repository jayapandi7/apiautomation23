package com.stepdefinition;

import java.util.ArrayList;

import com.Utility.BaseClassAPI1;
import com.endpoints.EndPonits;
import com.pojo.address.StateList;
import com.pojo.address.StateList_Output_pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import junit.framework.Assert;

public class TC2_GetStateIdStep extends BaseClassAPI1 {
	Response response;

	@Given("User add headers for to StateList")
	public void userAddHeadersForToStateList() {
		addHeader("accept", "application/json");

	}

	@When("User send {string} request for stateList endpoint")
	public void userSendRequestForStateListEndpoint(String reqType) {
		response = addReqType(reqType, EndPonits.STATELIST);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		TC1_LoginStep.globalData.setStatuscode(statusCode);
	}

	@Then("User verify the StateList response message matches {string} and saved State id")
	public void userVerifyTheStateListResponseMessageMatchesAndSavedStateId(String expStateName) {
		StateList_Output_pojo stateList_Output_pojo = response.as(StateList_Output_pojo.class);
		// Find the state Id of Tamilnadu
		ArrayList<StateList> stateList = stateList_Output_pojo.getData();

		for (StateList eachStateList : stateList) {
			String stateName = eachStateList.getName();
			if (stateName.equals(expStateName)) {
				int stateidNum = eachStateList.getId();
                String state_id = String.valueOf(stateidNum);
			    System.out.println(stateidNum);
			    TC1_LoginStep.globalData.setStateidNum(stateidNum);
			    TC1_LoginStep.globalData.setState_id(state_id);
			    break;
			}
		}
        String actMessage = stateList_Output_pojo.getMessage();  
		Assert.assertEquals("Verify Ok","OK", actMessage);
	}

}
