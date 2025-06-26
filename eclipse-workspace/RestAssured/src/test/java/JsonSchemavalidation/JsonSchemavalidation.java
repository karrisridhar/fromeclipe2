package JsonSchemavalidation;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class JsonSchemavalidation {
	@Test
 void jsonschemaValidation() {
		given()
		.when()
		.get("http://localhost:3000/student1")
		.then()
		.statusCode(200)
		.contentType("application/json")
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonschema.json"))
		.log().all();
	 
 }
}
