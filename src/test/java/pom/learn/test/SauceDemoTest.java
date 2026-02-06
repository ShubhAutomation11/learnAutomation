package pom.learn.test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SauceDemoTest {
	WebDriver driver;

	@BeforeTest
	void startLogger() {
		System.out.println("Execution Started");
	}

	@BeforeMethod
	void setUpDriver() {
		driver = new ChromeDriver();
		// Launch and verify Title
		driver.get("https://www.saucedemo.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String sauceTitle = driver.getTitle();
		Assert.assertEquals(sauceTitle, "Swag Labs", "Title not matched");
	}

	@AfterMethod
	void closeDriver() {
		driver.close();
	}

	@Test
	@Parameters({"val1","val2"})
	void loginCheck(String val1,String val2) {
		WebElement sauce_UserName = driver.findElement(By.xpath("//input[contains(@id,'user-name')]"));
		WebElement sauce_Password = driver.findElement(By.xpath("//input[contains(@name,'password')]"));
		WebElement sauce_LoginBtn = driver.findElement(By.xpath("//input[contains(@id,'login-button')]"));
		sauce_UserName.sendKeys(val1);
		sauce_Password.sendKeys(val2);
		sauce_LoginBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		WebElement sauce_ProductsTitle = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
		Assert.assertEquals(sauce_ProductsTitle.getText(), "Products", "Products Title not matched");
		sauce_ProductsTitle.isDisplayed();
		Select sort_dropdown = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		sort_dropdown.selectByValue("lohi");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// to do validate Quantity
	}

	@Test
	void addCart() {
		WebElement sauce_UserName = driver.findElement(By.xpath("//input[contains(@id,'user-name')]"));
		WebElement sauce_Password = driver.findElement(By.xpath("//input[contains(@name,'password')]"));
		WebElement sauce_LoginBtn = driver.findElement(By.xpath("//input[contains(@id,'login-button')]"));
		sauce_UserName.sendKeys("standard_user");
		sauce_Password.sendKeys("secret_sauce");
		sauce_LoginBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		WebElement item1Cart = driver
				.findElement(By.xpath("//button[contains(@id,'add-to-cart-sauce-labs-backpack')]"));
		WebElement item2Cart = driver
				.findElement(By.xpath("//button[contains(@id,'add-to-cart-sauce-labs-bike-light')]"));
		item1Cart.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		item2Cart.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement cart_btn = driver.findElement(By.xpath("//a[contains(@data-test,'shopping-cart-link')]"));
		cart_btn.click();
		assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]")).getText(),
				"Sauce Labs Backpack");
		WebElement hamburgerMenu_btn = driver.findElement(By.xpath("//button[contains(@id,'react-burger-menu-btn')]"));
		hamburgerMenu_btn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement logout_link = driver.findElement(By.xpath("//a[contains(@id,'logout_sidebar_link')]"));
		logout_link.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String sauceTitleLogOut = driver.getTitle();
		Assert.assertEquals(sauceTitleLogOut, "Swag Labs", "Title not matched");
	}

}
