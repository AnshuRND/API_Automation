package com.api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class loginAPITest {

    @Test(description = "Verify if Login API is working")
    public void loginTest(){
        RestAssured.baseURI="https://reqres.in/";
        RequestSpecification x=RestAssured.given();
        RequestSpecification y=x.header("Content-Type","application/json");
        RequestSpecification z=y.body("{\"email\": \"eve.holt@reqres.in\",\n\"password\": \"cityslicka\"\n}");
Response response=z.post("/api/login");

System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
