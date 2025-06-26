package ParsingXmlResponse;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponseOptions;

public class ParsingXmlResponse1 {
//	@Test(priority=1)
	void testXmlResponse() {
		//Approach1
		 given()
        .when()
            .get("http://localhost:3000/student1")
        .then()
            .statusCode(200)
            .header("Content-Type", "application/xml; charset=utf-8")
 //           .body("students.student.name[0]", equals("raju4"))
 //           .body("students.student.courses.course[0]", equals("java"))
 //           .body("students.student.courses.course[1]", equals("c#"))
            .log().all();
		
		//Approach2
//		Response res = given()
//		.when()
//		.get("http://localhost:3000/student1");
//		Assert.assertEquals(res.getStatusCode(), 200);
//		Assert.assertEquals(res.getHeader("Content-Type"), "application/xml; charset=utf-8");
//		 String name = res.xmlPath().get("students.student.name[0]").toString();	 
//		Assert.assertEquals(name, "raju4");
				
	}

	@Test
	void parsingXmlData() {
		Response res = given()
		.when()
		.get("http://localhost:3000/student1");
		XmlPath xmlobj=new XmlPath(res.asString());
		//verify total number of names
		List<String> usernames = xmlobj.getList("students.student.name");	
		Assert.assertEquals(usernames.size(), 1);
		//verify course is present
		List<String> coursename = xmlobj.getList("students.student.courses.course");
		boolean status=false;
		for(String coursenames:coursename) {
			if(coursenames.equals("java")) {
				status=true;
				break;
			}
		}
		
	Assert.assertEquals(status, true);
		}

}


