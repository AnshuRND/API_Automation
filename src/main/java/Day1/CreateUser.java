package Day1;


import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static io.restassured.path.xml.XmlPath.*;
import static org.hamcrest.Matchers.*;


public class CreateUser {

    int id;

@Test(priority = 1)
void getUserList(){

   //Get user list on page 2 https://reqres.in/api/users?page=2
    when()
            .get("https://reqres.in/api/users?page=2")

    .then()
            .statusCode(200)
            .body("page",equalTo(2))
            .log().all();
}
@Test(priority=2)
void CreateAUser(){
    //Post req to create user https://reqres.in/api/users
    HashMap<String, String> hm=new HashMap<>();
    hm.put("name","xyz");
    hm.put("job","trainer");


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

@Test(priority = 3,dependsOnMethods = {"CreateAUser"})
void UpdateCreatedUser(){
    HashMap<String, String> hm=new HashMap<>();
    hm.put("name","abc");
    hm.put("job","Teacher");


    given()
            .contentType("application/json")
            .body(hm)

            .when()
            .put("https://reqres.in/api/users/"+id)


            .then()
                  .statusCode(200)
                  .log().all();

    }
    @Test(priority = 4,dependsOnMethods = "CreateAUser")
    void DeleteUser(){

            when()
                .delete("https://reqres.in/api/users/"+id)
            .then()
                 .statusCode(204)
                    .log().all();

    }

}
