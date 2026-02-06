package pom.learn.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsExample {
	WebDriver driver;

	@BeforeTest
	void startLog() {
		System.out.println("Inside Before Test");

	}

	@BeforeMethod
	void driverSetup() {
		System.out.println("Inside Before Method");
		driver = new ChromeDriver();
	}

	@Test
	void Test1() {
		System.out.println("Insid Test1");
		driver.get("https://www.google.com");
	}

	@Test
	void Test2() {
		System.out.println("Inside Test2");
		driver.get("https://www.facebook.com");

	}

	@AfterMethod
	void closeBrowser() {
		System.out.println("Inside After method");
		driver.close();
	}

}
