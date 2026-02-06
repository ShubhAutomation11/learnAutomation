package Pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Declare WebElements
	@FindBy(xpath = "//span[@class='oxd-topbar-header-breadcrumb']//h6")
	WebElement breadCrumbsText;

	// Declare methods
	public String getTitle() {
		String actualTitle = driver.getTitle();
		return actualTitle;
	}

	public String getbreadCrumbText() {
		String breadCrumbText = breadCrumbsText.getText();
		return breadCrumbText;

	}

}
