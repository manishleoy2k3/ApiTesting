package com.api.utils;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.api.framework.utility.files.PropertiesFiles;

public class Utilities {

	PropertiesFiles configFile = new PropertiesFiles(); 
	private static  Logger logger = Logger.getLogger(Utilities.class);
	private static Utilities  instance = null;
	
	protected Utilities() {
		
	}
	
	public static Utilities getInstance() {
		if(null == instance) {
			instance = new Utilities();
		}
		return instance;
	}
	
	public String getBaseFilePath() {
	
		HashMap<String, String> configDetails = configFile.readProperties("configuration/webServices.properties");
		logger.info("base File path returned is: " + configDetails.get("FILE_PATH"));
		return configDetails.get("FILE_PATH");
	}
}
