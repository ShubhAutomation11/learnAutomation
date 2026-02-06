package pom.learn.test;

import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.learn.util.DriverFactory;

import Pom.pages.HomePage;
import Pom.pages.LoginPage;
import src.learn.util.ConfigReader;

public class LoginTest extends BaseTest {

	@Test(groups = { "Sanity", "Regression" })
	void loginOrangeHRM() {
		LoginPage login = new LoginPage(DriverFactory.getDriver());
		HomePage homepage = new HomePage(DriverFactory.getDriver());
		String user = ConfigReader.getProperty("userName");
		String pwd = ConfigReader.getProperty("password");
		login.EnterUserName(user);
		login.EnterPassword(pwd);
		login.clickLogin();
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Assert.assertEquals(homepage.getTitle(), "OrangeHRM", "Title not matched");
		Assert.assertEquals(homepage.getbreadCrumbText(), "Dashboard", "Breadcrumbs Validation failed");
	}

	@Test(groups = { "Sanity" })
	void inValidLogin() {
		LoginPage login = new LoginPage(DriverFactory.getDriver());
		String user = ConfigReader.getProperty("userName");
		login.EnterUserName(user);
		login.EnterPassword("admin123ss");
		login.clickLogin();
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Assert.assertEquals(login.getErrormsg(), "Invalid credentials", "Error msg validation failed");

	}

}
