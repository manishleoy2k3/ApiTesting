package com.api.implementation;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.api.interfaces.IAddParameter;
import com.api.interfaces.IAddPathParameters;
import com.api.interfaces.IGeneric;

public class AddPathParameter implements IAddPathParameters, IGeneric{

	private static AddPathParameter instance = null;
	private static  Logger logger = Logger.getLogger(AddPathParameter.class);
	
		
	protected AddPathParameter() {
		
	}
	
	public static AddPathParameter getInstance() {
		if(null == instance) {
			instance = new AddPathParameter();
		}
		return instance;
	}

	@Override
	public IAddParameter addParameter(String paramKey) {
		logger.debug("Setting path parameter key");
		addParameter.setParameterKey(paramKey);
		logger.debug("Setting path parameter Type");
		addParameter.setParameterType("PATH");
		return addParameter;
	}

	@Override
	public void addParameterMap(HashMap<String, String> pathParametersHashMap) {
		//extentManager.createNode("Add Header Parameter: ");
		logger.debug("Adding path parameters map to request");
		requestBuilder.getRequestSpecBuilder().addPathParams(pathParametersHashMap);
	}
}
