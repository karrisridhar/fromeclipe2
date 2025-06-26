package PathQuerycookies;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
public class CookiesDemo {
	//@Test(priority=1)
	void getCookie() {
		given()
		.when()
		.get("https://www.google.com/")
		.then()
		.cookie("AEC","AVh_V2hnQ3Eue5hYrQR7FtuBwJjhwSG4Btf0qrIsHLQlPw6YMj3539JPfQg")
		.log().all();
		
	}
	@Test
	void getCookiesInfo() {
//		ValidatableResponse res = given()
//		.when()
//		.get("https://www.google.com/")
//		.then()
//		.statusCode(200)
//		.log().all();
//		
//		ValidatableResponse cookval = res.cookie("AEC");
//		System.out.println("value of cookie is ======="+cookval);
		
		 Response res = given()
				.when()
				.get("https://www.google.com/");
				//single cookie inforamtion
			//	String cookval = res.getCookie("AEC");
			//	System.out.println("value of cookie is ======="+cookval);
		 //get all cooie infomartion
		 Map<String, String> allcookies = res.getCookies();
		 System.out.println(allcookies.keySet());
		 for(String k:allcookies.keySet()) {
			// System.out.println(res.getCookie(k));
			 String cookieval = res.getCookie(k);
			 System.out.println(k+"   :"+cookieval);
			 
}
}
}
