package APIChaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class GetUser {
	@Test
	void getUser(ITestContext context) {
		//int id=(Integer)context.getAttribute("user_id");      //id should come from create user request(testlevel)
		int id=(Integer)context.getSuite().getAttribute("user_id");  //id should come from create user request(suitelevel)
		String bearerToken="4373f9fdb28843a6307585020fed8d9322a4ed440689ce63cfec78f8c12ca9fe";
		given()
		.header("Authorization","Bearer "+bearerToken)
		.contentType("application/json")
		.pathParam("id", id)
		.when()
		.get("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.statusCode(200)
		.log().all();
	}

}
