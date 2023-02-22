package loginDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pages.loginPage;

public class LoginSteps {
	
	WebDriver driver = null;
	loginPage login;

	@SuppressWarnings("deprecation")
	@Given("browser has been open")
	public void browser_has_been_open() {
		System.out.println("Inside Step - browser has been open");
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is : "+projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@And("user is on login page")
	public void user_is_on_login_page() {
		driver.navigate().to("https://example.testproject.io/web/");
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) throws InterruptedException {
		
		login = new loginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		
//		driver.findElement(By.id("name")).sendKeys(username);
//		driver.findElement(By.id("password")).sendKeys(password);
		
		Thread.sleep(1000);
	}

	@And("user clicks on login")
	public void user_clicks_on_login() {
		login.clickLogin();
//		driver.findElement(By.id("login")).click();
	}

	
	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() throws InterruptedException {
		login.checkLogOutIsDisplayed();
//		driver.findElement(By.id("logout")).isDisplayed();
		
		Thread.sleep(1000);
		driver.close();
		driver.quit();
	}

}
