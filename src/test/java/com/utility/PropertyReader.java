package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

	public static String properyReader(String property)
	{
		String propertyvalue = null;
		try {
		Properties prop = new Properties();
		String userdir = System.getProperty("user.dir");
		InputStream input = new FileInputStream(userdir+"/src/test/resources/config.properties");
		prop.load(input);
		propertyvalue = prop.getProperty(property);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return propertyvalue;
	}

	}
