package PathQuerycookies;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class PathAndQueryParam {
	//https://reqres.in/api/users?page=2&id=5
	@Test
	void testpathAndQueryParam() {
		given()
		.header("x-api-key", "reqres-free-v1" )
		.pathParams("path","users")
		.queryParams("page", 2)
		.queryParam("id", 5)
		.when()
		.get("https://reqres.in/api/{path}")
		.then()
		.statusCode(200)
		.log().all();
		
	}

}
