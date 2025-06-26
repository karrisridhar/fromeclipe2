package FakeDataGeneration;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakeDataGeneration {
    @Test
	void fakeDataGeneration() {
    	//fake data generation for we add dependency serarch java faker and copy dependencies and past it
    	Faker faker=new Faker();
    	String firstname = faker.name().firstName();
    	 String lastname = faker.name().lastName();
    	 
    	 String username = faker.name().username();
    	 String password = faker.internet().password();
    	 
    	 String phono = faker.phoneNumber().cellPhone();
    	 
    	 String email = faker.internet().safeEmailAddress();
    	 System.out.println("firstname:"+firstname);
    	 System.out.println("lastname: "+lastname);
    	 System.out.println("username: "+username);
    	 System.out.println("password: "+password);
    	 System.out.println("phono: "+phono);
    	 System.out.println("email: "+email);
		
	}
}
