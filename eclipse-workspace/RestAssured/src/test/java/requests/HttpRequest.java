package requests;

import org.testng.annotations.Test;


import  io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HttpRequest {
	int id;
	
@Test(priority=1)
void getUsers() {
	

	given()
	
	.when()
	.get("https://reqres.in/api/users?page=2")
	.then()
	.statusCode(200)
	.body("page", equalTo(2))
	.log().all();
		
	}
@Test(priority=2)
void createUser() {
	 HashMap<String, String> data = new HashMap<>();
     data.put("name", "sidhar3");
     data.put("job", "QAEngineer3");

     id=given()
         .header("x-api-key", "reqres-free-v1" )
         .contentType("application/json")
         .body(data)
     .when()
         .post("https://reqres.in/api/users")
         .jsonPath().getInt("id");
   //  .then()
    //    .statusCode(201)
    //    .body("name", equalTo("sidhar1"))
    //     .body("job", equalTo("QAEngineer1"))
      //   .log().all();
 }
@Test(priority=3,dependsOnMethods="createUser")
void updateUser() {
	 HashMap<String, String> data = new HashMap<>();
     data.put("name", "sidhar4");
     data.put("job", "QAEngineer4");

     given()
         .header("x-api-key", "reqres-free-v1" )
         .contentType("application/json")
         .body(data)
     .when()
         .post("https://reqres.in/api/users/"+id)
         
    .then()
       .statusCode(201)
       .body("name", equalTo("sidhar4"))
        .body("job", equalTo("QAEngineer4"))
         .log().all();
 }
@Test(priority=4)
void deleteUser() {
	given()
	 .header("x-api-key", "reqres-free-v1" )
	.when()
	.delete("https://reqres.in/api/users/"+id)
	.then()
	.statusCode(204)
	.log().all();
}

}



