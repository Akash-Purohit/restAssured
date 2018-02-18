package com.integrated.utils.restapi;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.steps.Steps;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.specification.RequestSpecification;

public class JsonUtil extends Steps {

	@Given("user set up the base url")
	public RequestSpecification setupRestAssured() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		return httpRequest;
	}

}
