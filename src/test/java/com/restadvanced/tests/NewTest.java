package com.restadvanced.tests;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class NewTest {

	public static void main(String[] args) {

	 
	  String id = "1";
	  RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employee";
	 
	  Response response = null;
	 
	  try {
	   response = RestAssured.given()
	    .when()
	    .get("/" + id);
	  } catch (Exception e) {
	   e.printStackTrace();
	  }
	 
	  System.out.println("Response :" + response.asString());
	  System.out.println("Status Code :" + response.getStatusCode());
	  System.out.println("Does Reponse contains 'employee_salary'? :" + response.asString().contains("employee_salary"));
	 
	 
	  System.out.println(response.getStatusCode());
	 }
}
