package SerilizationDeserilization;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import requests.Pojo_PostRequest;

public class Serlizationdeserlization {
	//pojo --->json(serilization)
//	@Test
	void convertpojo2json() throws JsonProcessingException {
		//create java object using pojo cass
		Pojoclass pojo=new Pojoclass();
		pojo.setName("raju1");
		pojo.setLocation("hyd1");
		pojo.setPhoneno("123451");
		
		String couseArr []= {"java","c#"};
		pojo.setCourses(couseArr);
		//conver java object ----> json object(serilization)
		ObjectMapper objmapper=new ObjectMapper();
		String jsondata = objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(pojo);
		System.out.println(jsondata);
	}
	//json --->pojo(de-serilization)
		@Test
		void convertjson2pojo() throws JsonProcessingException {
			//create json data using pojo object
			String jsondata="{\r\n"
					+ "  \"name\" : \"raju1\",\r\n"
					+ "  \"location\" : \"hyd1\",\r\n"
					+ "  \"phoneno\" : \"123451\",\r\n"
					+ "  \"courses\" : [ \"java\", \"c#\" ]\r\n"
					+ "}";
			//conver json data ----> pojo object(de-serilization)
			ObjectMapper objmapper=new ObjectMapper();
			Pojoclass data=objmapper.readValue(jsondata, Pojoclass.class);//conver json to pojo
			System.out.println("name:"+data.getName());
			System.out.println("location:"+data.getLocation());
			System.out.println("phoneno:"+data.getPhoneno());
			System.out.println("course:"+data.getCourses()[0]);
			System.out.println("course:"+data.getCourses()[1]);
			
		}
}
