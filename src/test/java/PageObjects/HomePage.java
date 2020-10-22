package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver)
	{
		this.driver=driver;

	}
	
	By search= By.xpath("//input[@class='search-keyword']");
	
	public WebElement getSearch() throws InterruptedException
	{
		//Thread.sleep(2000);
		return driver.findElement(search);
	}


}
