package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStep {
	
	WebDriver driver;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("https://www.saucedemo.com/");
		
	}

	@When("User enters valid login credentials")
	public void user_enters_valid_login_credentials() {
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	    
	}

	@Then("User should be taken to next page")
	public void user_should_be_taken_to_next_page() {
		
		String actualURL = driver.getCurrentUrl();
	    String expectedURL = "https://www.saucedemo.com/inventory.html";
	    Assert.assertEquals(actualURL, expectedURL);
		
	}

	
	

}
