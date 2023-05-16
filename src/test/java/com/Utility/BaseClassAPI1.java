package com.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClassAPI1 {

	RequestSpecification requestSpecification;
	public static Response response;

	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getPropertyPath() + "\\Config\\Config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;

	}

	public static String getPropertyPath() {
		String path = System.getProperty("user.dir");
		return path;
	}

	public void addHeader(String key, Object value) {
		requestSpecification = RestAssured.given().header(key, value);
	}

	public void addHeaders(Headers headers) {
		requestSpecification = RestAssured.given().headers(headers);
	}

	public void addPathParam(String key, Object value) {
		requestSpecification = requestSpecification.pathParam(key, value);
	}

	public void addQueryParam(String key, Object value) {
		requestSpecification = requestSpecification.queryParam(key, value);
	}

	public void addBody(String body) {
		requestSpecification = requestSpecification.body(body);
	}

	public void addBody(Object body) {
		requestSpecification = requestSpecification.body(body);
	}

	public Response addReqType(String type, String endpoint) {
		switch (type) {
		case "GET":
			response = requestSpecification.log().all().get(endpoint);
			break;
		case "POST":
			response = requestSpecification.log().all().post(endpoint);
			break;
		case "PUT":
			response = requestSpecification.log().all().put(endpoint);
			break;
		case "DELETE":
			response = requestSpecification.log().all().delete(endpoint);
			break;
		case "PATCH":
			response = requestSpecification.log().all().patch(endpoint);
			break;

		default:
			break;
		}
		return response;
	}

	public int getStatusCode(Response response) {
		int statusCode = response.statusCode();
		return statusCode;
	}

	public String getResBodyAsString(Response response) {
		String asString = response.asString();
		return asString;
	}

	public String getResBodyAsPrettyString(Response response) {
		String asPrettyString = response.asPrettyString();
		return asPrettyString;
	}

	public void addBaseAuth(String username, String password) {
		requestSpecification = requestSpecification.auth().preemptive().basic(username, password);
	}

}
