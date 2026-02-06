package src.learn.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties properties;
	static {
		try {
			FileInputStream fis = new FileInputStream("src/test/resources/ConfigProperties");
			properties = new Properties();
			properties.load(fis);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	// method to fetch property value by key
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

}
