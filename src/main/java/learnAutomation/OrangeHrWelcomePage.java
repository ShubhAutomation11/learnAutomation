package learnAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHrWelcomePage {
	// automate login
	public static void main(String args[]) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		// Mention web elements
		WebElement input_UserName = driver.findElement(By.name("username"));
		WebElement input_Password = driver.findElement(By.name("password"));
		WebElement btn_Login = driver.findElement(By.xpath("//button[contains(@type,'submit')]"));
		input_UserName.click();
		input_UserName.sendKeys("admin");
		input_Password.click();
		input_Password.sendKeys("admin123");
		btn_Login.click();
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

	}

}
