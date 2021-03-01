package CucumberFramework.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {

	WebDriver driver;

	@Before()
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Desktop\\CUCUMBER JAVA\\CucumberFramework\\src\\test\\java\\CucumberFramework\\resources\\chromedriver.exe");
		this.driver = new ChromeDriver();;
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}

	@Given("^User navigates to stackoverflow website$")
	public void user_navigates_to_stackoverflow_website() throws Throwable {
		this.driver.get("https://stackoverflow.com/");
	}

	@Given("^User clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable {
		this.driver.findElement(By.xpath("//a[contains(text(),'Log in')]")).click();
	}

	@Given("^User enters a valid username$")
	public void user_enters_a_valid_username() throws Throwable {
		//Thread.sleep(3000);
		this.driver.findElement(By.id("email")).sendKeys("arsov.ivaylo@gmail.com");
	}

	@Given("^User enters a valid password$")
	public void user_enters_a_valid_password() throws Throwable {
		this.driver.findElement(By.id("password")).sendKeys("arsov321@");
	}

	@When("^User clicks on the login button$")
	public void user_clicks_on_the_login_button() throws Throwable {
		this.driver.findElement(By.id("submit-button")).click();
	}

	@Then("^User should be taken to the successful login page$")
	public void user_should_be_taken_to_the_successful_login_page() throws Throwable {
		Thread.sleep(3000);
		WebElement askQuestionBtn = this.driver.findElement(By.xpath("//a[contains(text(), 'Ask Question')]"));
		Assert.assertEquals(true, askQuestionBtn.isDisplayed());
	}
	
	@After()
	public void cleanUp() {
		this.driver.quit();
	}
}
