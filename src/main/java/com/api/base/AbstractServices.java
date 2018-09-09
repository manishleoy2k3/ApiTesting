package com.api.base;

import org.apache.log4j.Logger;

import com.api.framework.Initilize;
import com.api.framework.constants.FrameworkConstants;
import com.api.implementation.AddHeaderParameter;
import com.api.implementation.AddPathParameter;
import com.api.implementation.AddQueryParameter;
import com.api.implementation.BaseURL;
import com.api.implementation.Execute;
import com.api.implementation.RequestBody;
import com.api.implementation.ResponseBuilder;
import com.api.implementation.Verify;
import com.api.interfaces.IAddHeadersParameters;
import com.api.interfaces.IAddPathParameters;
import com.api.interfaces.IAddQueryParameters;
import com.api.interfaces.IExecute;
import com.api.interfaces.IGeneric;
import com.api.interfaces.IServices;
import com.api.interfaces.ISetRequestBody;
import com.api.interfaces.ISetURL;
import com.api.interfaces.IVerify;

public class AbstractServices implements IServices, IGeneric{

	private static Initilize init = Initilize.getInstance();
	private static  Logger logger = Logger.getLogger(AbstractServices.class);
	
	
	@Override
	public ISetURL setBaseURL(String baseURL) {
		extentManager.createNode("Set Base URL: ");
		BaseURL.getInstance().setBaseURL(baseURL);
		return BaseURL.getInstance();
	}

	@Override
	public ISetRequestBody setRequestBodyFromFile(String filePath) {
		extentManager.createNode("Set Request Body from File");
		requestBody.setRequestBodyFromFile(filePath);
		return requestBody;
	}

	@Override
	public ISetRequestBody setRequestBody(String strBody) {
		extentManager.createNode("Set Request Body");
		RequestBody.getInstance().setRequestBody(strBody);
		return RequestBody.getInstance();
	}

	@Override
	public IExecute execute() {
		extentManager.createNode("Execute Request: ");
		return new Execute();
	}

	@Override
	public IVerify verify() {
		if(!(FrameworkConstants.REPORTNODE.getModel().getName().toString().contains("Field Verification:"))) {
			extentManager.createNode("Field Verification: ");
		}
		return new Verify();
	}

	@Override
	public IAddQueryParameters queryParam() {
		if(!(FrameworkConstants.REPORTNODE.getModel().getName().toString().contains("Add Query Parameter:"))) {
			extentManager.createNode("Add Query Parameter: ");
		}
		return AddQueryParameter.getInstance();
	}

	@Override
	public IAddPathParameters pathParam() {
		if(!(FrameworkConstants.REPORTNODE.getModel().getName().toString().contains("Add Path Parameter:"))) {
			extentManager.createNode("Add Path Parameter: ");
		}
		return AddPathParameter.getInstance();
	}

	@Override
	public IAddHeadersParameters header() {
		if(!(FrameworkConstants.REPORTNODE.getModel().getName().toString().contains("Add Header Parameter:"))) {
			extentManager.createNode("Add Header Parameter: ");
		}
		return AddHeaderParameter.getInstance();
	}

	@Override
	public String getResponseBody() {
		extentManager.createNode("Get Response Body: ");
		return ResponseBuilder.getResponseBuilder().getResponse().getBody().asString();
	}

	@Override
	public void removeQueryParameters() {
		extentManager.createNode("Remove Query Parameters: ");
		for(String temp : addParameter.getQueryParamList()) {
			logger.debug("Query Parameter to be removed is: " + temp);
			requestBuilder.getRequestSpecBuilder().removeQueryParam(temp);
		}
		addParameter.clearQueryParamList();
	}

	@Override
	public void removePathParameters() {
		extentManager.createNode("Remove Path Parameters: ");
		for(String temp : addParameter.getPathParamList()) {
			logger.debug("Path Parameter to be removed is: " + temp);
			requestBuilder.getRequestSpecBuilder().removePathParam(temp);
		}
		addParameter.clearPathParamList();		
	}

	/**
	 * @return the init
	 */
	public static Initilize getInit() {
		return init;
	}

	/**
	 * @param init the init to set
	 */
	public static void setInit(Initilize init) {
		AbstractServices.init = init;
	}

}
