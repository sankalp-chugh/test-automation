import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class POMDemo
{
	private WebDriver driver = null;
	private By searchBar = By.id("search_query_top");
	private By searchBtn = By.className("button-search");
	private By menuBarItems = By.xpath("//*[@id='block_top_menu']/ul/li");
	
	public POMDemo(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setTextSearchBar(String searchText) {
		driver.findElement(searchBar).sendKeys(searchText);
		driver.findElement(searchBtn).click();
	}
	
	public List<WebElement> getItemsInMenu() {
		List<WebElement> listItems = driver.findElements(menuBarItems);
		return listItems;
	}
}
