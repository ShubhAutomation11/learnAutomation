package Pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Declare WebElements

	@FindBy(xpath = "//input[contains(@name,'username')]")
	WebElement inputUser;
	@FindBy(xpath = "//input[contains(@name,'password')]")
	WebElement inputPassword;
	@FindBy(xpath = "//button[contains(@type,'submit')]")
	WebElement loginBtn;
	@FindBy(xpath = "//div[contains(@class,'oxd-alert-content oxd-alert-content--error')]//p")
	WebElement errormsg;

	// Declare Methods

	public void EnterUserName(String userName) {
		inputUser.click();
		inputUser.sendKeys(userName);

	}

	public void EnterPassword(String password) {
		inputPassword.sendKeys(password);

	}

	public void clickLogin() {
		loginBtn.click();

	}

	public String getErrormsg() {
		String acutalErrormsg = errormsg.getText();
		return acutalErrormsg;

	}

}
