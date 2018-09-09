package com.api.implementation;

import org.apache.log4j.Logger;

import com.api.framework.constants.FrameworkConstants;
import com.api.interfaces.IGeneric;
import com.api.interfaces.ISetURL;
import com.aventstack.extentreports.Status;

public class BaseURL implements ISetURL, IGeneric{

	private String baseURL = "";
	private static BaseURL instance = null;
	private static  Logger logger = Logger.getLogger(BaseURL.class);
	
		
	protected BaseURL() {
		
	}
	
	public static BaseURL getInstance() {
		if(null == instance) {
			instance = new BaseURL();
		}
		return instance;
	}

	/**
	 * @return the baseURL
	 */
	public String getBaseURL() {
		//TODO: report log this
		return baseURL;
	}

	/**
	 * @param baseURL the baseURL to set
	 */
	public void setBaseURL(String baseURL) {
		requestBuilder.getRequestSpecBuilder().setBaseUri(baseURL);
		logger.debug("Base URL set: " + baseURL);
		FrameworkConstants.REPORTNODE.log(Status.PASS, baseURL);
	}

	@Override
	public void setBasePath(String resourcePath) {
		requestBuilder.getRequestSpecBuilder().setBasePath(resourcePath);
		logger.debug("Base Path set: " + resourcePath);
		FrameworkConstants.REPORTNODE.log(Status.PASS, resourcePath);
	}

}
