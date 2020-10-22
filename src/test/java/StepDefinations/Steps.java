package StepDefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Base.BaseClass;
import PageObjects.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps  {

	public WebDriver driver;
	HomePage hp;

	@Given("^User navigated to the GreenKart landing page$")
	public void user_navigated_to_the_greenkart_landing_page() throws Throwable {

		driver=BaseClass.getDriver();
		
	}

	@When("^user searched for \"([^\"]*)\" vegetable$")
	public void user_searched_for_something_vegetable(String cucumber) throws Throwable {
		
		hp=new HomePage(driver);
		hp.getSearch().sendKeys(cucumber);
		Thread.sleep(3000);
	}

	@Then("^\"([^\"]*)\" results are displayed$")
	public void something_results_are_displayed(String strArg1 ) throws Throwable {

		/*String veg=driver.findElement(By.cssSelector("h4.product-name")).getText();
		System.out.println(veg);
		String Expected ="Cucumber - 1 Kg";
		if(veg==Expected) {

			System.out.println("Search results are displayed");
		}else
		{
			System.out.println("Search results are not displayed");
		}*/

		Assert.assertTrue(driver.findElement(By.cssSelector("h4.product-name")).getText().contentEquals(strArg1));

	}
	@And("^added items to cart$")
	public void added_items_to_cart() throws Throwable {

		driver.findElement(By.cssSelector("a.increment")).click();
		driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();

	}
	@Then("^verify selected \"([^\"]*)\" items are displayed in check out page$")
	public void verify_selected_something_items_are_displayed_in_check_out_page(String strArg1) throws Throwable {
		Thread.sleep(2000);
		Assert.assertTrue( driver.findElement(By.cssSelector("p.product-name")).getText().contains(strArg1));
	}


	@And("^user proceed to checkout page for purchase$")
	public void user_proceed_to_checkout_page_for_purchase() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/div[3]/a[4]/img")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

	}


}

