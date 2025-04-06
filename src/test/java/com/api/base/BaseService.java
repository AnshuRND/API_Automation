package com.api.base;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;


public class BaseService {
    //Base URI
    private static  final String BASE_URI="https://reqres.in/";
    private RequestSpecification requestSpecification;

    public BaseService(){
        requestSpecification=given().baseUri(BASE_URI);
    }
    protected Response PostRequest(String payload, String EndPoint){
      return  requestSpecification.contentType(ContentType.JSON)
                .body(payload).post(EndPoint);
    }



}
