package pom.learn.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {
	@Test
	void test1() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		String actualTitle = driver.getTitle();
		String expected = "Orange HRM";
		Assert.assertEquals(actualTitle, expected, "Title not matched");
		System.out.println("First assert failed");
		Assert.assertTrue(actualTitle.equalsIgnoreCase(expected));
		driver.close();

	}

	@Test
	void test2() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		

	}
	
	@Test
	void test3() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
	//	Select dropdown_Sort = new Select(driver.findElement(null))
		

	}

}
