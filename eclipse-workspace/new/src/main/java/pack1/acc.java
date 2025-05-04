package pack1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class acc {
	public static WebDriver driver;
	public static Actions a;
 @BeforeTest
  public void open() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver-win64 (3)\\chromedriver-win64\\chromedriver.exe");
      driver=new ChromeDriver();
     driver.manage().window().maximize();
    
  }
 @AfterTest
 public void close() {
	// driver.close();
	 
 }
}
