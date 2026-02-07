package pom.learn.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.learn.util.DriverFactory;

import Pom.pages.SauceDemoLogin;
import src.learn.util.ConfigReader;

public class SauceLoginTest extends BaseTest {
	//SauceTest

	@Test(groups = { "Sanity", "Regression" })
	@Parameters({ "val1", "val2" })
	void validSauceLogin(String val1, String val2) {
		SauceDemoLogin login = new SauceDemoLogin(DriverFactory.getDriver());
		login.enterUser(val1);
		login.enterPassword(val2);
		login.clickSignIn();

	}

	@Test(groups = { "Sanity" })
	void InvalidSauceLogin() {
		SauceDemoLogin login = new SauceDemoLogin(DriverFactory.getDriver());
		String user =ConfigReader.getProperty("userNames");
		String password = ConfigReader.getProperty("passwords");
		System.out.println(user);
		System.out.println(password);
		login.enterUser(user);
		login.enterPassword(password);
		login.clickSignIn();

	}

}
