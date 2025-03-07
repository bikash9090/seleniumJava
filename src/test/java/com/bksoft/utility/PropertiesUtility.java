package com.bksoft.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {

	Properties prop;

	PropertiesUtility() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
			System.getProperty("user.dir") + "\\src\\test\\resources\\data.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getName() {
		return prop.getProperty("name");
	}

}
