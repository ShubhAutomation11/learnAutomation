package pom.learn.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	@DataProvider(name="Sample")
	public Object[][] dpMethod() {
		return new Object[][] { { "Apple", 2 }, { "Orange", 3 } };
	}

	@Test(dataProvider = "Sample")
	public void dataProviderTest(String item, int qty) {
		System.out.println("Value Passed is" + item + "Quantity" + qty);

	}

}
