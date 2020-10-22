package Base;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;

	public static WebDriver getDriver() throws IOException
	{

		prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\tanumay123\\Desktop\\Cucumber\\Workspace_photon\\GreenKart2\\src\\test\\java\\Base\\base.properties");
		prop.load(fis);

		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));



		return driver;

	}




}
