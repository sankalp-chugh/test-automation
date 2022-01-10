import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class POMDemo
{
	private WebDriver driver = null;
	private By searchBar = By.id("search_query_top");
	private By searchBtn = By.className("button-search");
	
	public POMDemo(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setTextSearchBar(String searchText) {
		driver.findElement(searchBar).sendKeys(searchText);
		driver.findElement(searchBtn).click();
	}
}
