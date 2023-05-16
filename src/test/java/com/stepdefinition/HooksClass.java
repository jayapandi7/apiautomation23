package com.stepdefinition;

import com.Utility.BaseClassAPI1;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClassAPI1 {
	public static Scenario sc;

	@Before
	public void beforeScenario(Scenario scenario) {
		sc = scenario;
	}

	@After
	public void afterScenario() {
		String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		sc.log(resBodyAsPrettyString);
	}

}
