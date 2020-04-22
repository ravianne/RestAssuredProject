package com.restadvanced.tests;

import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.http.ContentType;

public class SampleAdvancedRest {

	public static void main(String[] args) {
		checkHeaderData();
	}

	public static void checkHeaderData() {
		given().pathParam("country", "us").pathParam("zipcode", "90210").when()
				.get("http://api.zippopotam.us/{country}/{zipcode}").then().assertThat().statusCode(200).and()
				.contentType(ContentType.JSON);
	}
}
