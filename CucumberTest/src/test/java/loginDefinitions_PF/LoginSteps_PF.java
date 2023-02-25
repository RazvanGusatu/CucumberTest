package loginDefinitions_PF;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageFactory.HomePage_PF;
import pageFactory.loginPage_PF;

public class LoginSteps_PF {
	
	WebDriver driver = null;
	loginPage_PF login;
	HomePage_PF home;

	@SuppressWarnings("deprecation")
	@Given("browser has been open")
	public void browser_has_been_open() {
		System.out.println(" ==== I am inside LoginSteps_PF class ==== ");
		
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
		
		login = new loginPage_PF(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		
		Thread.sleep(1000);
	}

	@And("user clicks on login")
	public void user_clicks_on_login() {
		login.clickOnLogin();
	}

	
	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() throws InterruptedException {
		home = new HomePage_PF(driver);
		home.checkLogoutIsDisplayed();

		Thread.sleep(1000);
		driver.close();
		driver.quit();
	}

}
