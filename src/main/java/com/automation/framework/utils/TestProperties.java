package com.automation.framework.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {

	public static String BROWSER=getProperty("browser");
	public static String PACKAGES=getProperty("packages");
	public static String GROUP_INCLUDES=getProperty("group.include");
	public static String TEST_NAME=getProperty("test.name");

	static Properties prop;

	public static String getProperty(String key) {

		prop = new Properties();
		InputStream input = null;

		try {		
			// load a properties file
			prop.load(TestProperties.class.getClassLoader().getResourceAsStream("config/config.properties"));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop.getProperty(key);
	}


}
