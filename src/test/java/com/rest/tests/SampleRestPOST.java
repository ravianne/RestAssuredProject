package com.rest.tests;

import java.util.Base64;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleRestPOST {
	public static void main(String[] args) {
		System.setProperty("http.proxyPassword", new String(Base64.getDecoder().decode("VmVua2F0QDQ0NA==")));
		System.getProperties().put("https.proxySet", "true");

		// Create a Request pointing to the Service Endpoint
		RestAssured.baseURI = "http://restapi.demoqa.com/customer/register";
		RequestSpecification httpRequest = RestAssured.given();

		// Create a JSON request which contains all the fields
		JSONObject requestParams = new JSONObject();

		// requestParams.put("FirstName", "Ravi");
		// requestParams.put("LastName", "Kiran");
		// requestParams.put("UserName", "ravikiran");
		// requestParams.put("Password", "123456");
		// requestParams.put("email", "ravikiran@test.com");

		requestParams.put("FirstName", "Virender");
		requestParams.put("LastName", "Singh");
		requestParams.put("UserName", "simpleuser001");
		requestParams.put("Password", "password1");
		requestParams.put("Email", "someuser@gmail.com");
		
		// Add JSON body in the request and send the Request
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toString());
		
		// Post the request and check the response
		Response httpResponse = httpRequest.post("/register");
		if (httpResponse.getStatusCode() == 201) {
			if (httpResponse.jsonPath().get("SuccessCode").equals("OPERATION_SUCCESS"))
				System.out.println("Register Operation is successful");
			else
				System.out.println("Register Operation is unsuccessful" + httpResponse.getBody().asString());
		} else
			System.out.println("Post request Operation failed" + httpResponse.getStatusCode() + httpResponse.body().asString());
	}

}
