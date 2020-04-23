package com.rest.tests;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employees";
		
		RequestSpecification httpRequest = RestAssured.given();
		
//		Response response = httpRequest.get();
		Response response = httpRequest.request(Method.GET);
		System.out.println(response.asString());

	}

}
