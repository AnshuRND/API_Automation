package Day1_Prac;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class BasicApiAutomation {

int id;
    @Test(priority = 1)
void getUserList(){
        //https://reqres.in/api/users?page=2

            when()
                     .get("https://reqres.in/api/users?page=2")

                   .then()
                      .statusCode(200)
                      .log().all();
}
@Test(priority = 2)
void  CreateNewUser(){

    HashMap<String,String> hm= new HashMap<>();
    hm.put("name","Eve");
    hm.put("job","Leader");

        id=given()
                .contentType("application/json")
                .body(hm)

                .when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");

              /*  .then()
                .statusCode(201)
                .log().all();*/
}
@Test(priority = 3,dependsOnMethods = "CreateNewUser")
void UpdateUSer(){
    HashMap<String,String> hm= new HashMap<>();
    hm.put("name","Evil");
    hm.put("job","Leadership");

    given()
            .contentType("application/json")
            .body(hm)

            .when()
            .put("https://reqres.in/api/users/"+id)


   .then()
                .statusCode(200)
                .log().all();
}
@Test(priority = 4,dependsOnMethods = "CreateNewUser")
void DeleteUser(){

        when()
                .delete("https://reqres.in/api/users/"+id)

                .then()
                .statusCode(204)
                .log().all();


}
}
