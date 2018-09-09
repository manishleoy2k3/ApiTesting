package com.api.implementation;

import org.apache.log4j.Logger;

import com.api.framework.constants.FrameworkConstants;
import com.api.interfaces.IGeneric;
import com.api.interfaces.ISetRequestBody;
import com.aventstack.extentreports.Status;


public class RequestBody implements ISetRequestBody, IGeneric{

	private static RequestBody instance = null;
	private static  Logger logger = Logger.getLogger(RequestBody.class);
	
		
	protected RequestBody() {
		
	}
	
	public static RequestBody getInstance() {
		if(null == instance) {
			instance = new RequestBody();
		}
		return instance;
	}

	public void setRequestBodyFromFile(String fileName) {
		logger.debug("Setting request body from file ");
		requestBuilder.getRequestSpecBuilder().setBody(jsonHandler.readJsonFromFile(fileName));
		FrameworkConstants.REPORTNODE.log(Status.PASS, fileName);
	}
	
	public void setRequestBody(String strBody) {
		logger.debug("Setting request body from string value ");
		requestBuilder.getRequestSpecBuilder().setBody(strBody);
		FrameworkConstants.REPORTNODE.log(Status.PASS, strBody);
	}
}
