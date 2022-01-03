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
	WebElement searchBar;
	WebDriverWait wait;
  @Test
  public void TID01TestPositive() {
  	searchBar.sendKeys("Blue");
  	searchBar.sendKeys(Keys.ENTER);
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
		  searchBar.sendKeys("Blose"); searchBar.sendKeys(Keys.ENTER); 
		  //apply explicit wait
		  wait.until(ExpectedConditions.titleContains("Search"));
		  
		  errorMsgActual = driver.findElement(By.className("alert-warning")).getText();
		  System.out.println(errorMsgActual); assertEquals(errorMsgActual,
		  errorMsgExpected); 
	  }
	 
  
  @BeforeMethod
  public void beforeMethod() {
  	super.beforeMethod();
  	searchBar = driver.findElement(By.id("search_query_top"));
  	wait = new WebDriverWait(driver,20);
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  	super.beforeTest();
  }

  @AfterTest
  public void afterTest() {
  }


}
