package pack2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class acc2  extends acc1{
	@FindBy (xpath="//input[@name='txtUserName']") WebElement UN; 
	@FindBy (xpath="//input[@name='txtPassword']") WebElement PW;
	@FindBy (xpath="//input[@name='Submit']")WebElement CL;
	@FindBy (xpath="//span[@class='drop current']") WebElement PM;
	@FindBy (xpath="//span[text()='Add Employee']") WebElement ADE;
	@FindBy (xpath="//span[text()='Benefits']")WebElement BE;
	@FindBy (xpath="//span[text()='Health savings plan']")WebElement HS;
	@FindBy (xpath="//span[text()='Define HSP ']")WebElement HSP;
public void execute() {
	 driver.get("http://127.0.0.1/orangehrm-2.5.0.2/login.php");
	 UN.sendKeys("Admin");
	 PW.sendKeys("Admin");
	 CL.click();
	
}
public void len() {
	a=new Actions(driver);
	WebElement pm=PM;
    System.out.println(pm.getText());
    a.moveToElement(pm).perform();
    ADE.click();
}
public void ae() {
	  WebElement w3=BE;
	  WebElement w4=HS;
	  a.moveToElement(w3).perform();
	  a.moveToElement(w4).perform();
	  HSP.click();
}


}
