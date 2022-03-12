import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TID01 extends BaseTest {
	POMDemo pom = null;
	WebDriverWait wait = null;
	ExtentReports extent = null;


	@BeforeSuite
	public void beforeSuite() {
		ExtentSparkReporter spark = new ExtentSparkReporter("src/test/resources/reportSpark.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}

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

		assertTrue(elements.size()>0);
	}


	@Test 
	public void TID01TestNegative() { 
		ExtentTest test1 = extent.createTest("TID01TestNegative","Negative Test for search function.");

		test1.log(Status.INFO, "Searching with wrong name.");

		//Search String and error msg
		String searchString = "Blue"; 
		String errorMsgActual; 
		String errorMsgExpected = "No results were found for your search \""+searchString +"\"";

		//search
		pom.setTextSearchBar(searchString); 

		//apply explicit wait
		wait.until(ExpectedConditions.titleContains("Search"));

		try
		{
			errorMsgActual = driver.findElement(By.className("alert-warning")).getText();

			test1.log(Status.INFO, "Verify result.");

			assertEquals(errorMsgActual, errorMsgExpected);
			test1.pass("Error message matches", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		} catch (AssertionError e)
		{
			test1.fail("Error message does not match", MediaEntityBuilder.createScreenCaptureFromPath("src/test/resources").build());
		}
		catch (NoSuchElementException e) {
			test1.fail("Error message does not match", MediaEntityBuilder.createScreenCaptureFromPath("src/test/resources").build());
		}


	}


	@AfterTest
	public void afterTest() {
		driver.quit();
		extent.flush();
	}


}
