package com.rest.tests;

import java.util.Base64;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleRestAuthentication {

	public static void main(String[] args) {

//		System.setProperty("http.proxyPassword", new String(Base64.getDecoder().decode("VmVua2F0QDQ0NA==")));
//		System.getProperties().put("https.proxySet", "true");

		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
		RequestSpecification httpRequest = RestAssured.given();
		Response httpResponse = httpRequest.get();
		System.out.println("Status Code - " + httpResponse.getStatusCode());
		System.out.println("Body - " + httpResponse.body().asString());

	}

}