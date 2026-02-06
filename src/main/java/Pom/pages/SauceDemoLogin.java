package Pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SauceDemoLogin {
	WebDriver driver;
	// By Locators
	By sauceUser = By.xpath("//input[contains(@id,'user-name')]");
	By saucePassword = By.xpath("//input[contains(@name,'password')]");
	By signInBtn = By.xpath("//input[contains(@id,'login-button')]");
	By productsTitle = By.xpath("//span[contains(text(),'Products')]");

	public SauceDemoLogin(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUser(String user) {
		driver.findElement(sauceUser).sendKeys(user);

	}

	public void enterPassword(String password) {
		driver.findElement(saucePassword).sendKeys(password);

	}

	public void clickSignIn() {
		driver.findElement(signInBtn).click();
	}

}
