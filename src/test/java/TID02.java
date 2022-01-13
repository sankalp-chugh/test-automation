import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class TID02 extends BaseTest {
	
	POMDemo pom = null;
	
	@BeforeTest
  public void beforeTest() {
  	super.beforeTest();
  	pom = new POMDemo(driver);
  }
	
	@BeforeMethod
  public void beforeMethod() {
		super.beforeMethod();
  }
	
  @Test
  public void TID02Test() {
  	ArrayList<String> expectedItems = new ArrayList<String>();
  	expectedItems.add("WOMEN");
  	expectedItems.add("DRESSES");
  	expectedItems.add("T-SHIRTS");
  	
  	List<WebElement> menuItems = pom.getItemsInMenu();
  	
  	
  }
  

 

  @AfterTest
  public void afterTest() {
  }

}
