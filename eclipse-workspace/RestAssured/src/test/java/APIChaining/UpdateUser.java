package APIChaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
public class UpdateUser {
	@Test
	void updateUser(ITestContext context) {
		Faker faker=new Faker();
		JSONObject data=new JSONObject();
		data.put("name", faker.name().username());
		data.put("gender", "female");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "active");
		String bearerToken="4373f9fdb28843a6307585020fed8d9322a4ed440689ce63cfec78f8c12ca9fe";
		
		//int id=(Integer)context.getAttribute("user_id");      //id should come from create user request(testlevel)
		int id=(Integer)context.getSuite().getAttribute("user_id");  //id should come from create user request(suitelevel)
		given()
		.header("Authorization","Bearer "+bearerToken)
		.contentType("application/json")
		.body(data.toString())
		.pathParam("id",id)
		.when()
		.put("https://gorest.co.in/public/v2/users/{id}")
		.then()
        .statusCode(200) // Expected success status code for resource creation
        .log().all();
        
	}

}
