package ParsingJsonResponseData;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class ParsingJsonResponseData {
//	@Test
 void testJsonResponse1() {
		//Approach1
		given()
		.contentType("ContentType.JSON")
		.when()
		.get("http://localhost:3000/student")
		.then()
		.statusCode(200)
		.header("Content-Type", "application/json")
		.body("[0].name", equalTo("raju")); // Adjusted JSON path
		
		
	}
//	@Test
	void testjsonRes2() {
		//Approach2
		Response res = given()
		.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:3000/student");
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"),"application/json");
		String names = res.jsonPath().get("[0].name").toString();
		Assert.assertEquals(names, "raju");	 
 }
	@Test
	void testJsonres3() {
		//approach3
		Response res = given()
		.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:3000/student");
		
		//using json object class some issue so using Array class
	/*	JSONObject ob=new JSONObject(res.asString());//convert response to json object
		
		//prinnt all student of names
		
		 for(int i=0;i<ob.getJSONArray("student").length();i++) {
			
		String names = ob.getJSONArray("student").getJSONObject(i).get("name").toString();
		System.out.println(names);	*/
		
		// Convert response string to JSONArray
        JSONArray arr = new JSONArray(res.asString());

        // Loop through the array and print all student names
        for (int i = 0; i < arr.length(); i++) {
            JSONObject studentObj = arr.getJSONObject(i);
            String name = studentObj.getString("name");
            System.out.println(name);
		 }
        
    //  search the name of the book vlaidation1
    	boolean status=false;
    	for (int i = 0; i < arr.length(); i++) {
            JSONObject studentObj = arr.getJSONObject(i);
            String name = studentObj.getString("name");
            if(name.equals("ramu")) {
    			status=true;
    			break;			
   		}	
		 }
    	Assert.assertEquals(status, true);
    //validation total price	
    	double prices=0;
    	for (int i = 0; i < arr.length(); i++) {
            JSONObject studentObj = arr.getJSONObject(i);
            double pri = studentObj.getDouble("price");
            
            prices+=pri;
           
   	System.out.println("total price is :"+prices);

		 }
    	Assert.assertEquals(prices, 215.1);
		 }
	
}

