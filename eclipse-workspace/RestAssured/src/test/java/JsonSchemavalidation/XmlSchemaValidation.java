package JsonSchemavalidation;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class XmlSchemaValidation {
   private static final String ResetAssuredMatchers = null;

@Test
	void xmlschemaValidation() {
	   given()
	   .when()
	       .get("http://localhost:3000/student1")
	   .then()
	      .statusCode(200)
	       .and()
	       .contentType(ContentType.XML)
	       .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("student.xsd"))
	       .log().body();
		
	}
}
