package pom.learn.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoQA {
	WebDriver driver;

	@BeforeTest
	void startExecution() {
		System.out.println("Execution Started");
	}

	@BeforeMethod
	void driverSetup() {
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		System.out.println("DemoQA Website Launched");

	}

	@Test
	void verifyForm() {
		WebElement firstName = driver.findElement(By.xpath("//input[contains(@id,'firstName')]"));
		WebElement lastName = driver.findElement(By.xpath("//input[contains(@id,'lastName')]"));
		WebElement email = driver.findElement(By.xpath("//input[contains(@id,'userEmail')]"));
		WebElement Gender = driver.findElement(By.xpath("//input[@value='Male']"));
		WebElement Hobbies = driver.findElement(By.xpath("//input[contains(@id,'hobbies-checkbox-1')]"));
		WebElement Address = driver.findElement(By.xpath("//textarea[contains(@id,'currentAddress')]"));
		WebElement submit = driver.findElement(By.xpath("//button[contains(@id,'submit')]"));
		// verify form is active
		firstName.isDisplayed();
		firstName.isEnabled();
		email.isEnabled();

		// Enter form inputs
		firstName.sendKeys("Shubh");
		lastName.sendKeys("Test");
		email.sendKeys("ShubhTest@gmail.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	//	Gender.click();
		Hobbies.click();
		Address.sendKeys("2869 Battleford rd \n Mississauga\n Canada");
		Select state = new Select(driver.findElement(By.xpath("//div[contains(@id,'stateCity-wrapper')]")));
		state.selectByVisibleText("NCR");
		submit.click();

	}

	@AfterMethod
	void closeDriver() {
		// driver.quit();
	}

}
