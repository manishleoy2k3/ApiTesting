package com.api.framework.utility.files;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Assert;

public class PropertiesFiles {

	private HashMap<String, String> propData = null;
	private static  Logger logger = Logger.getLogger(PropertiesFiles.class);
	
	
	
	public HashMap<String, String> readProperties(String filePath) {

		propData = new HashMap<String, String>();
		logger.info(filePath + " Reading properties file.");
		try {
			InputStream input = PropertiesFiles.class.getClassLoader().getResourceAsStream(filePath);
			if(input == null) {
				Assert.fail("Properties file not found at " + filePath + " location.");
			}
			Properties properties = new Properties();
			properties.load(input);
			input.close();
			
			Enumeration<Object> enuKeys = properties.keys();
			while(enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				Assert.assertTrue((!value.isEmpty()), "Value of " + key + " key is missing.");
				propData.put(key.trim(), value.trim());
			}
			logger.info(filePath + " file read successfully.");
		} catch(FileNotFoundException e) {
			logger.error("Exception "+ e);
			logger.error("Properties file not found.");
			Assert.fail("Properties file not found.");
		} catch(IOException e) {
			logger.error("Exception "+ e);
			logger.error("Error while reading Properties file not found.");
			Assert.fail("Properties file not found.");
		}
		return propData;
	}
}
