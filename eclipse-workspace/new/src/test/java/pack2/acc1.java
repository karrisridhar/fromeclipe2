package pack2;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pack1.acc;

public class acc1 extends acc {
  @Test
  public void runtestcases() {
	  acc2 e=new acc2();
	 // e.execute();
	  acc2 ac=PageFactory.initElements(driver, acc2.class);
	  ac.execute();
	  ac.len();
	  ac.ae();
	 
  }
}
