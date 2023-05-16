package com.stepdefinition;

import org.junit.Assert;

import com.Utility.BaseClassAPI1;
import io.cucumber.java.en.Then;

public class CommonStep extends BaseClassAPI1 {

	@Then("User should verify the statuscode is {int}")
	public void userShouldVerifyTheStatuscodeIs(int expStatuscode) {
		int actStatusCode = TC1_LoginStep.globalData.getStatuscode();
		Assert.assertEquals("Verify status code", expStatuscode, actStatusCode);
		HooksClass.sc.log("Acutal Status Code :"+actStatusCode+"\n"+"Expected Status Code :"+expStatuscode);
	}


}
