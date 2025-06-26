package APIChaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class CreateUser {
	@Test
	void createUser(ITestContext context) {
		Faker faker=new Faker();
		JSONObject data=new JSONObject();
		data.put("name", faker.name().username());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		String bearerToken="4373f9fdb28843a6307585020fed8d9322a4ed440689ce63cfec78f8c12ca9fe";
		int id=given()
		.header("Authorization","Bearer "+bearerToken)
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("https://gorest.co.in/public/v2/users")
	   //  .jsonPath().getInt("id");//if we use this line we can't use then
		.then()
        .statusCode(201) // Expected success status code for resource creation
        .log().all()
        .extract().jsonPath().getInt("id");

    System.out.println("Generated ID is: " + id);
   // context.setAttribute("user_id", id); //this is available at test level
    context.getSuite().setAttribute("user_id", id);  //this is available at suite level
		
	}

}
