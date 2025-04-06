package com.api.tests;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class loginAPITest2 {

    @Test(description = "Verify if Login API is working")
    public void loginTest(){
        //baseURI="https://reqres.in/";
Response response= given()
        .baseUri("https://reqres.in/")
        .header("Content-Type","application/json")
        .body("{\"email\": \"eve.holt@reqres.in\",\n\"password\": \"cityslicka\"\n}")
        .post("/api/login");

System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
