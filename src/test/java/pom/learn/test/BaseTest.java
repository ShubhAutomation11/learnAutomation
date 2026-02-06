package pom.learn.test;

import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.learn.util.DriverFactory;

import src.learn.util.ConfigReader;

public class BaseTest {

	@BeforeTest
	void StartLogger() {
		System.out.println("Execute First Test");
	}

	@BeforeMethod(alwaysRun = true)
	void SetupDriver() {
		System.out.println("Inside Setup method");
		DriverFactory.setDriver();
		DriverFactory.getDriver().manage().window().maximize();
		String url = ConfigReader.getProperty("baseUrlHR");
		DriverFactory.getDriver().get(url);
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@AfterMethod(alwaysRun = true)
	void tearDown() {
		DriverFactory.getDriver().close();
	}
}
