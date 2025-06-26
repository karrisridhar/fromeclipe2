package Diffrentrequestoayload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import  io.restassured.RestAssured;
import requests.Pojo_PostRequest;

import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Diffwaystocreatereqbody {
	//1. post request using hashmap
//	@Test(priority=1)
	void postsinghshmap() {
		HashMap<Object, Object> data=new HashMap();
		data.put("id", 2);
		data.put("name", "raju");
		data.put("location", "hyd");
		data.put("phoneno", "12345");
		
		String couseArr []= {"c","c++"};
		data.put("courses", couseArr);
		given()
		.contentType("application/json")
		.body(data)
		.when()
		.post("http://localhost:3000/student")
		.then()
		.statusCode(201)
		.body("name", equalTo("raju"))
		.body("location", equalTo("hyd"))
		.body("phoneno", equalTo("12345"))
		.body("courses[0]", equalTo("c"))
		.body("courses[1]",equalTo( "c++"))
		//.header("Content-Type","application/json; charset=utf-8")
		.log().all();
	}
	//2.post request by using org.json library
//	@Test(priority=1)
	void postsingjsonlibrary() {
		JSONObject data=new JSONObject();
		data.put("id", 3);
		data.put("name", "raju1");
		data.put("location", "hyd1");
		data.put("phoneno", "123451");
		
		String couseArr []= {"java","c#"};
		data.put("courses", couseArr);
		given()
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("http://localhost:3000/student")
		.then()
		.statusCode(201)
		.body("name", equalTo("raju1"))
		.body("location", equalTo("hyd1"))
		.body("phoneno", equalTo("123451"))
		.body("courses[0]", equalTo("java"))
		.body("courses[1]",equalTo( "c#"))
		//.header("Content-Type","application/json; charset=utf-8")
		.log().all();
	}
	//3.post request by using POJO class(Plain old java object)
//	@Test(priority=1)
	void postpojolibrary() {
		Pojo_PostRequest data=new Pojo_PostRequest();
		data.setName("raju1");
		data.setLocation("hyd1");
		data.setPhoneno("123451");
		
		String couseArr []= {"java","c#"};
		data.setCourses(couseArr);
		
		given()
		.contentType("application/json")
		.body(data)
		.when()
		.post("http://localhost:3000/student")
		.then()
		.statusCode(201)
		.body("name", equalTo("raju1"))
		.body("location", equalTo("hyd1"))
		.body("phoneno", equalTo("123451"))
		.body("courses[0]", equalTo("java"))
		.body("courses[1]",equalTo( "c#"))
		//.header("Content-Type","application/json; charset=utf-8")
		.log().all();
	}
	//4.post request by using externl json
	@Test(priority=1)
	void postexternaljson() throws FileNotFoundException {
		File f=new File(".\\body.json");
		FileReader r=new FileReader(f);
		JSONTokener t=new JSONTokener(r);
		JSONObject data=new JSONObject(t);
		
		
		given()
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("http://localhost:3000/student")
		.then()
		.statusCode(201)
		.body("name", equalTo("raju1"))
		.body("location", equalTo("hyd1"))
		.body("phoneno", equalTo("123451"))
		.body("courses[0]", equalTo("java"))
		.body("courses[1]",equalTo( "c#"))
		//.header("Content-Type","application/json; charset=utf-8")
		.log().all();
	}
	@Test(priority=2)
	void deletehashmap() {
		given()
		.when()
		.delete("http://localhost:3000/student/3f95")
		.then()
		.statusCode(200);
	}

}
