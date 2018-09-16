package com.api.framework;

import java.io.File;
import java.util.HashMap;
import java.util.Set;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.api.framework.constants.FrameworkConstants;
import com.api.framework.constants.SetUpConstants;
import com.api.framework.utility.files.PropertiesFiles;
import com.api.framework.utility.report.ExtentManager;


public class Initilize {

	private static Initilize instance = null;
	//TODO: SetLogFile
	private PropertiesFiles prop = new PropertiesFiles();
	private HashMap<String, String> propertyData = new HashMap<String, String>();
	private static  Logger logger = Logger.getLogger(Initilize.class);
	private ExtentManager extentManager = ExtentManager.getInstance();

	protected Initilize() {
		
	}
	
	public static Initilize getInstance() {
		if(null == instance) {
			instance = new Initilize();
			instance.setConfiguration();
		}
		return instance;
	}

	private void setConfiguration() {
	
		FrameworkConstants.GLOBALCONFIG = prop.readProperties(FrameworkConstants.CONFIGFILE);
		FrameworkConstants.SCREENSHOT_LOCATION = FrameworkConstants.TMP + File.separator + "screenshots" + File.separator;
		FrameworkConstants.APPLICATION_CONFIG = prop.readProperties(FrameworkConstants.GLOBALCONFIG.get("APPLICATION_CONFIG"));
		FrameworkConstants.DATASHEET_CONFIG = prop.readProperties(FrameworkConstants.GLOBALCONFIG.get("DATASHEET.PROPERTIES"));
		if(FrameworkConstants.GLOBALCONFIG.get("DATABASE_CONNECTION").equalsIgnoreCase("yes")) {
			FrameworkConstants.DATABASE_CONFIG = prop.readProperties(FrameworkConstants.GLOBALCONFIG.get("DATABASE_CONFIG"));
		}
		setExecutionParameter();
	}
	
	private void setExecutionParameter() {
	
		propertyData = new HashMap<String, String>();
		if(FrameworkConstants.GLOBALCONFIG.get("DEVICE").equalsIgnoreCase("desktop")) {
			
			propertyData = prop.readProperties(FrameworkConstants.GLOBALCONFIG.get("DESKTOP.PROPERTIES"));
			SetUpConstants.DEFAULTTIMEOUT = Integer.parseInt(propertyData.get("DEFAULT_TIMEOUT"));
			SetUpConstants.PAGELOADTIMEOUT = Integer.parseInt(propertyData.get("PAGELOAD_TIMEOUT"));
			SetUpConstants.BROWSER = propertyData.get("BROWSER");
			
		} else if(FrameworkConstants.GLOBALCONFIG.get("DEVICE").equalsIgnoreCase("mobile")) {
			propertyData = prop.readProperties(FrameworkConstants.GLOBALCONFIG.get("MOBILE.PROPERTIES"));
			FrameworkConstants.GLOBALCONFIG.put("REMOTE_URL", propertyData.get("REMOTE_URL"));
			FrameworkConstants.GLOBALCONFIG.put("MOBILE_EXECUTION", propertyData.get("EXECUTION"));
			
			//Add this new constants for Mobile platform to identify IOS or Android
			FrameworkConstants.GLOBALCONFIG.put("MOBILE_PLATFORM", propertyData.get("PLATFORMTYPE"));
			SetUpConstants.DEFAULTTIMEOUT = Integer.parseInt(propertyData.get("DEFAULT_TIMEOUT"));
			SetUpConstants.PAGELOADTIMEOUT = Integer.parseInt(propertyData.get("PAGELOAD_TIMEOUT"));
			SetUpConstants.BROWSER = propertyData.get("BROWSER");
			
		} else {
			
		}
		
		FrameworkConstants.EXTENT = extentManager.getExtent();
		SetUpConstants.SCREEN_SHOT = returnBoolean(FrameworkConstants.GLOBALCONFIG.get("SCREEN_SHOT"));
		FrameworkConstants.EXECUTION_MODE = FrameworkConstants.GLOBALCONFIG.get("EXECUTION_MODE");
		SetUpConstants.HTML_REPORT = returnBoolean(FrameworkConstants.GLOBALCONFIG.get("HTML_REPORT"));
		
		updateGlobalConfig(propertyData);
	}
	
	private void updateGlobalConfig(HashMap<String, String> propertyData) {
		Set<String> keys = propertyData.keySet();
		for(String key : keys) {
			FrameworkConstants.GLOBALCONFIG.put(key, propertyData.get(key));
		}
	}

	private boolean returnBoolean(String value) {
	
		if(value.equalsIgnoreCase("yes")) {
			return true;
		} else if(value.equalsIgnoreCase("no")) {
			
		} else {
			Assert.fail("Value should be Yes/No" + value);
		}
		return false;
	}
}
