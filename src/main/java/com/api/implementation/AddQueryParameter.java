package com.api.implementation;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.api.interfaces.IAddParameter;
import com.api.interfaces.IAddQueryParameters;
import com.api.interfaces.IGeneric;

public class AddQueryParameter implements IAddQueryParameters, IGeneric{

	private static AddQueryParameter instance = null;
	private static  Logger logger = Logger.getLogger(AddQueryParameter.class);
	
		
	protected AddQueryParameter() {
		
	}
	
	public static AddQueryParameter getInstance() {
		if(null == instance) {
			instance = new AddQueryParameter();
		}
		return instance;
	}

	@Override
	public IAddParameter addParameter(String paramKey) {
		logger.debug("Setting query parameter key");
		addParameter.setParameterKey(paramKey);
		logger.debug("Setting query parameter Type");
		addParameter.setParameterType("QUERY");
		return addParameter;
	}

	@Override
	public void addParameterMap(HashMap<String, String> queryParametersHashMap) {
		//extentManager.createNode("Add query Parameter: ");
		logger.debug("Adding query parameters map to request");
		requestBuilder.getRequestSpecBuilder().addQueryParams(queryParametersHashMap);
	}
}
