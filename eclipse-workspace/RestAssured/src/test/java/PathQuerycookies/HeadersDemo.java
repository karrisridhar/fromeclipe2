package PathQuerycookies;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HeadersDemo {
	//@Test(priority=1)
	void headers() {
		given()
		.when()
		.get("https://www.google.com/")
		.then()
		.header("Content-Type", "text/html; charset=ISO-8859-1")
		.header("Content-Encoding", "gzip")
		.header("Server", "gws")
		.log().all();
		
	}
	//@Test(priority=2)
	void headerDem() {
		ValidatableResponse res = given()
		.when()
		.get("https://www.google.com/")
		.then()
		.statusCode(200)
		.log().all();
		res.header("Content-Type", "text/html; charset=ISO-8859-1");
		
	}
	@Test(priority=3)
	public void headerDe1() {
		Response res = given()
		.when()
		.get("https://www.google.com/");
		//single header
		//String head1 = res.getHeader("Content-Type");
		//System.out.println("header value"+head1);
		
		//multiple headers
		Headers headers = res.getHeaders();
		for(Header h:headers) {
			System.out.println(h.getName()+" : "+h.getValue());
		}
		
	}

}
