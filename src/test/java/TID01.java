import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
//assertions
import org.testng.Assert;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
//waits
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TID01 extends BaseTest {
	POMDemo pom = null;
	WebDriverWait wait;
	
	@BeforeTest
  public void beforeTest() {
  	super.beforeTest();
  	pom = new POMDemo(driver);
  }
	
	@BeforeMethod
  public void beforeMethod() {
  	super.beforeMethod();
  	//initialize wait
  	wait = new WebDriverWait(driver,20);
  }
	
  @Test
  public void TID01TestPositive() {
  	pom.setTextSearchBar("Blue");
  	wait.until(ExpectedConditions.titleContains("Search"));
  	//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
  	List<WebElement> elements = driver.findElements(By.xpath(".//*[@id='center_column']/ul/li"));
  	//System.out.println(elements.size());
  	assertTrue(elements.size()>0);
  }
  
	
	  @Test 
	  public void TID01TestNegative() { 
		  String searchString = "Blose"; 
		  String errorMsgActual; 
		  String errorMsgExpected = "No results were found for your search \""+searchString +"\"";
		  pom.setTextSearchBar("Blose"); 
		  //apply explicit wait
		  wait.until(ExpectedConditions.titleContains("Search"));
		  
		  errorMsgActual = driver.findElement(By.className("alert-warning")).getText();
		  System.out.println(errorMsgActual); assertEquals(errorMsgActual,
		  errorMsgExpected); 
	  }
	 

  @AfterTest
  public void afterTest() {
  	driver.quit();
  }


}
