package com.integrated.utils.steps;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.integrated.utils.restapi.JsonUtil;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;

public class restResponse extends JsonUtil {

	String city;
	String temperature;
	String humidity;
	String weatherDescription;
	String windSpeed;
	String windDirectionDegree;

	Logger loggerPrint = Logger.getLogger(JsonUtil.class.getName());

	@When("user gets the response of the GET method")
	public Response getResponseBody() {
		Response response = setupRestAssured().get("/Hyderabad");
		ResponseBody body = response.getBody();
		System.out.println("Reponse Body is: " + body.asString());
		return response;
	}

	@Then("user validates the response")
	public void validateResponse() {
		Response response = setupRestAssured().get("/Pune");
		HashMap<String, String> getResponseValues = setResponseValues(response);

		for (Map.Entry m : getResponseValues.entrySet()) {
			switch (m.getKey().toString()) {
			case "City":
				if (m.getValue().toString().equalsIgnoreCase("Pune")) {
					loggerPrint.info((m.getKey() + " is: " + m.getValue()));
				} else {
					loggerPrint
							.info("Incorrect " + m.getKey() + " Comparision");
				}
				break;
			case "Temperature":
				if (m.getValue().toString()
						.equalsIgnoreCase("21 Degree celsius")) {
					loggerPrint.info((m.getKey() + " is: " + m.getValue()));
				} else {
					loggerPrint
							.info("Incorrect " + m.getKey() + " Comparision");
				}
				break;
			case "Humidity":
				if (m.getValue().toString().equalsIgnoreCase("82 Percent")) {
					loggerPrint.info((m.getKey() + " is: " + m.getValue()));
				} else {
					loggerPrint
							.info("Incorrect " + m.getKey() + " Comparision");
				}
				break;
			case "WeatherDescription":
				if (m.getValue().toString().equalsIgnoreCase("clear sky")) {
					loggerPrint.info((m.getKey() + " is: " + m.getValue()));
				} else {
					loggerPrint
							.info("Incorrect " + m.getKey() + " Comparision");
				}
				break;
			case "WindSpeed":
				if (m.getValue().toString().equalsIgnoreCase("1.5 Km per hour")) {
					loggerPrint.info((m.getKey() + " is: " + m.getValue()));
				} else {
					loggerPrint
							.info("Incorrect " + m.getKey() + " Comparision");
				}
				break;
			case "WindDirectionDegree":
				if (m.getValue().toString()
						.equalsIgnoreCase("21 Degree celsius")) {
					loggerPrint.info((m.getKey() + " is: " + m.getValue()));
				} else {
					loggerPrint
							.info("Incorrect " + m.getKey() + " Comparision");
				}
				break;
			default:
				break;
			}
		}

	}

	public HashMap<String, String> setResponseValues(Response response) {
		HashMap<String, String> responseValues = new HashMap<String, String>();

		city = response.jsonPath().get("City");
		temperature = response.jsonPath().get("Temperature");
		humidity = response.jsonPath().get("Humidity");
		weatherDescription = response.jsonPath().get("WeatherDescription");
		windSpeed = response.jsonPath().get("WindSpeed");
		windDirectionDegree = response.jsonPath().get("WindDirectionDegree");

		responseValues.put("City", city);
		responseValues.put("Temperature", temperature);
		responseValues.put("Humidity", humidity);
		responseValues.put("WeatherDescription", weatherDescription);
		responseValues.put("WindSpeed", windSpeed);
		responseValues.put("WindDirectionDegree", windDirectionDegree);

		return responseValues;
	}
}
