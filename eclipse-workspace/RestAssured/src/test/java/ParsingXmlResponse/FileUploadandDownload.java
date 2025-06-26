package ParsingXmlResponse;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class FileUploadandDownload {
//	@Test(priority=1)
void singleFileUpload() {
	File f=new File("D:\\textfile\\new.txt.txt");
		given()
		.multiPart("file",f)
		.contentType("multipart/form-data")
		.when()
		.post("https://httpbin.org/post") // ✅ use an actual upload-supporting endpoint
		.then()
		.statusCode(200)
//		.body("fileName", equalTo("4mb-examplefile-com.txt"))
		.log().all();
//		  given()
//          .multiPart("file", f)
//          .contentType("multipart/form-data")
//      .when()
//          .post("https://httpbin.org/post") // ✅ use an actual upload-supporting endpoint
//      .then()
//          .statusCode(200)
//          .body("files.'file'", notNullValue()) // ✅ check if file was received
//          .log().all();
	
}
	@Test(priority=2)
	void multipleFileUpload() {
		File f1=new File("D:\\textfile\\new.txt.txt");
		File f2=new File("D:\\textfile\\new2.txt");
		given()
        .multiPart("file1", f1)
        .multiPart("file2", f2)
        .contentType("multipart/form-data")
    .when()
        .post("https://httpbin.org/post")
    .then()
        .statusCode(200)
        .body("files.'file1'", notNullValue())
        .body("files.'file2'", notNullValue())
        .log().all();
//		given()
//		.multiPart("files",f1)
//		.multiPart("files",f2)
//		.contentType("multipart/form-data")
//		.when()
//		.post("https://httpbin.org/post") // ✅ use an actual upload-supporting endpoint
//		.then()
//		.statusCode(200)
//	.body("[0].fileName", equalTo("new.txt.txt"))
//		.log().all();
		
	}
}
