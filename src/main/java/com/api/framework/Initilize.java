package com.api.framework;

import java.util.HashMap;
import java.util.Set;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.api.framework.constants.FrameworkConstants;
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
		}
		return instance;
	}

	private void setConfiguration() {
	
		setExecutionParameter();
	}
	
	private void setExecutionParameter() {
	
		propertyData = new HashMap<String, String>();
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
