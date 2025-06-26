package Authenications;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Authinications {
	@Test(priority=1,enabled=false)
	void basicAuthinicaton() {
		given()
		.auth().basic("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	@Test(priority=2,enabled=false)
	void digestAuthinicaton() {
		given()
		.auth().digest("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	@Test(priority=3,enabled=false)
	void preemptiveAuthinicaton() {
		given()
		.auth().preemptive().basic("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
//	@Test(priority=3)
	void bearerToken() {
		given()
		.header("Authorization","Bearer QpwL5tke4Pnpja7X4")
		.when()
		.get("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.log().all();
	}
//	@Test(priority=3)
	void authToken() {
		given()
		.auth().oauth("consumerkey", "consumersecret", "accestoken", "tokensecret")
		.when()
		.get("url")
		.then()
		.statusCode(200)
		.log().all();
	}
//	@Test(priority=3)
	void auth2Token() {
		given()
		.auth().oauth2("QpwL5tke4Pnpja7X4")
		.when()
		.get("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.log().all();
	}
	@Test
	void apiKeyAuthtication() {
		//two ways to send api keys using parameter or header
//	    given()
//	        .queryParam("q", "London")
//	       // .queryParam("appid", "YOUR_API_KEY")
//	    .when()
//	        .get("https://api.openweathermap.org/data/2.5/weather")
//	    .then()
//	        .statusCode(200)
//	        .log().all();
		given()
		  .header("x-api-key", "testkey123")
		.when()
		  .get("https://httpbin.org/headers")
		.then()
		  .statusCode(200)
		  .log().all();
	}

}
