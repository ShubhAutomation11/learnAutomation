package learnAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumFirstSession {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		WebElement input_UserName = driver.findElement(By.xpath("//input[@id='email']"));
		input_UserName.click();
		input_UserName.sendKeys("Shubhashish11");
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		allLinks.size();

	}

}