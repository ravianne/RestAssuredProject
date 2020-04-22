package com.rest.tests;

import java.util.Base64;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleRestGET {
	public static void main(String[] args) {

		// String encodedPassword = new
		// String(Base64.getEncoder().encodeToString("Password".getBytes()));
		// String decodedPassword = new
		// String(Base64.getDecoder().decode(encodedPassword));

		// System.setProperty("http.proxyPassword", new
		// String(Base64.getDecoder().decode("VmVua2F0QDQ0NA==")));
		// System.getProperties().put("https.proxySet", "true");

		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Get the RequestSpecification of the request that you want to sent to the server.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the method URL.

		// This will return the Response from the server. Store the response in a variable.
		// Response response = httpRequest.request(Method.GET, "/Hyderabad");
		Response response = httpRequest.get("/Hyderabad");

		// Get the status code from the Response.
		System.out.println("Response Status Code is =>  " + response.getStatusCode());

		// Should get a status code of 200 on successful interaction with WebService
		if (response.getStatusCode() == 200) {
			System.out.println("WebService is successful");
		} else {
			System.out.println("Webservice is unsuccessful");
		}

		// Get the status line from the Response and print
		System.out.println("Response Status Code is =>  " + response.getStatusLine());

		// Reader header of a give name. In this line we will get Content-Type,
		// Server, Content-Encoding
		System.out.println("Content-Type value: " + response.header("Content-Type"));
		System.out.println("Server value: " + response.header("Server"));
		System.out.println("Content-Encoding value: " + response.getHeader("Content-Encoding"));
		
		// Get all the headers. Return value is of type Headers.
		Headers allHeaders = response.headers();

		// Iterate over all the Headers
		for (Header header : allHeaders) {
			System.out.println("Header name:" + header.getName() + " --- Value: " + header.getValue());
		}

		// Print the response body of the message from server
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);

		// First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();

		// Print all the values from JSON
		System.out.println("City received from Response " + jsonPathEvaluator.get("City"));
		System.out.println("Temperature received from Response" + jsonPathEvaluator.get("Temperature"));
		System.out.println("Humidity received from Response" + jsonPathEvaluator.get("Humidity"));
		System.out.println("WeatherDescription received from Response" + jsonPathEvaluator.get("WeatherDescription"));
		System.out.println("WindSpeed received from Response" + jsonPathEvaluator.get("WindSpeed"));
		System.out.println("WindDirectionDegree received from Response" + jsonPathEvaluator.get("WindDirectionDegree"));

	}

}