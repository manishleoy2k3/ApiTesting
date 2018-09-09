package com.api.implementation;

import org.apache.log4j.Logger;

import com.api.interfaces.IRespStatus;
import com.api.interfaces.IStatusCode;
import com.api.interfaces.IStatusLine;

public class ResponseStatus implements IRespStatus{

	private ResponseBuilder responseBuilder = ResponseBuilder.getResponseBuilder();
	private static ResponseStatus instance = null;
	private static  Logger logger = Logger.getLogger(ResponseStatus.class);
	
		
	protected ResponseStatus() {
		
	}
	
	public static ResponseStatus getInstance() {
		if(null == instance) {
			instance = new ResponseStatus();
		}
		return instance;
	}
	
	
	public IStatusCode statusCode() {
		StatusCode.getInstance().setStatusCode(responseBuilder.getResponse().getStatusCode());
		return StatusCode.getInstance();
	}

	
	public IStatusLine statusLine() {
		StatusLine.getInstance().setStatusLine(responseBuilder.getResponse().getStatusLine());
		return StatusLine.getInstance();
	}

	
}
