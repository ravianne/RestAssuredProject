package com.restadvanced.tests;

import com.jayway.restassured.http.ContentType;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleAdvancedRest {

	public static void main(String[] args) {
		checkHeaderData();
	}

	public static void checkHeaderData() {
		Response response = null;
		RestAssured.given().pathParam("country", "us").pathParam("zipcode", "90210")
				.when()
				.get("http://api.zippopotam.us/{country}/{zipcode}")
				.then().assertThat().statusCode(400);
	}
}
