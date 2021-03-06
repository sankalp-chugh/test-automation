import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class BaseTest {
	WebDriver driver;
//  @Test(dataProvider = "dp")
//  public void f(Integer n, String s) {
//  }
	
	@BeforeSuite
	public void beforeSuite() {
		ExtentSparkReporter spark = new ExtentSparkReporter("src/test/resources/reportSpark.html");
  	ExtentReports extent = new ExtentReports();
  	extent.attachReporter(spark);
	}
	
  @BeforeTest
  public void beforeTest() {
  	System.out.println("beforeTest method running");
  	
  	System.setProperty("webdriver.chrome.driver", "/Users/sankalpchugh/Projects/Selenium/chromedriver");
  	
  	//setup webdriver & navigate to test page
  	driver=new ChromeDriver();
  }
  
	@BeforeClass	//runs after beforeTest method
  public void beforeClass() {
		System.out.println("beforeClass method running");
  	
  }
	
  @BeforeMethod
  public void beforeMethod() {
  	
  	driver.navigate().to("http://automationpractice.com/index.php");
  }
  

  

  @AfterClass
  public void afterClass() {
  }
  
  @AfterMethod
  public void afterMethod() {
  }
  

  @AfterTest
  public void afterTest() {
  }
  
//  @Test
//  public void demoTest() {
//  	
//  }
  

}
