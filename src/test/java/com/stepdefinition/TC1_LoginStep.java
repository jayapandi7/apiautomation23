package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.Utility.BaseClassAPI1;
import com.endpoints.EndPonits;
import com.global.GlobalData;
import com.pojo.login.Login_Output_pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class TC1_LoginStep extends BaseClassAPI1 {

	Response response;
	public static GlobalData globalData = new GlobalData();

	@Given("User add header")
	public void userAddHeader() {
		addHeader("accept", "application/json");
	}

	@When("User add basic authentication for login")
	public void userAddBasicAuthenticationForLogin() throws FileNotFoundException, IOException {
		addBaseAuth(getPropertyFileValue("username"), getPropertyFileValue("password"));

	}

	@When("User send {string} request for login endpoint")
	public void userSendRequestForLoginEndpoint(String reqType) {
		response = addReqType(reqType, EndPonits.POSTMANBASICAUTH);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		globalData.setStatuscode(statusCode);

	}

	@Then("User verify the logic response body FirstName present as {string} and get the logtoken saved")
	public void userVerifyTheLogicResponseBodyFirstNamePresentAsAndGetTheLogtokenSaved(String expFirstName) {
		Login_Output_pojo login_Output_pojo = response.as(Login_Output_pojo.class);
		String actfirst_name = login_Output_pojo.getData().getFirst_name();
		System.out.println(actfirst_name);
		String logtoken = login_Output_pojo.getData().getLogtoken();
		globalData.setLogtoken(logtoken);
		Assert.assertEquals("Verify FirstName", expFirstName, actfirst_name);

	}

}
