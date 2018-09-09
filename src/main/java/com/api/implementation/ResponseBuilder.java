package com.api.implementation;

import org.apache.log4j.Logger;

import com.api.framework.constants.FrameworkConstants;
import com.aventstack.extentreports.Status;

import io.restassured.response.Response;


public class ResponseBuilder {

	private Response response = null;
	private static ResponseBuilder instance = null;
	private static  Logger logger = Logger.getLogger(ResponseBuilder.class);
	
		
	protected ResponseBuilder() {
		
	}
	
	//RequestBuilder instance creation
	public static ResponseBuilder getResponseBuilder() {
		if(null == instance) {
			instance = new ResponseBuilder();
			logger.debug("ResponseBuilder Object is created.");
		}
		return instance;
	}

	public Response getResponse() {
		return response;
	}

	
	public void setResponse(Response response) {
		this.response = response;
		logger.debug("Response Object value set.");
		FrameworkConstants.REPORTNODE.log(Status.INFO, "Request Executed");
		FrameworkConstants.REPORTNODE.log(Status.INFO, "Response headers: " + response.getHeaders());
		
		if(!(response.getDetailedCookies().asList().isEmpty())) {
			FrameworkConstants.REPORTNODE.log(Status.INFO, "Response detailed cookies: " + response.getDetailedCookies());
		}
		FrameworkConstants.REPORTNODE.log(Status.INFO, "Response body: " + response.asString());
	}

}
