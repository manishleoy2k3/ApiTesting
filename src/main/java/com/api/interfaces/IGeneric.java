package com.api.interfaces;

import com.api.framework.Report;
import com.api.framework.utility.report.ExtentManager;
import com.api.implementation.AddParameter;
import com.api.implementation.BaseURL;
import com.api.implementation.RequestBody;
import com.api.implementation.RequestBuilder;
import com.api.implementation.ResponseBuilder;
import com.api.implementation.ResponseHeader;
import com.api.implementation.ResponseJsonPath;
import com.api.implementation.ResponseTime;
import com.api.implementation.StatusCode;
import com.api.implementation.StatusLine;
import com.api.utils.Comparison;
import com.api.utils.JsonHandler;
import com.api.utils.Utilities;

public interface IGeneric {

	Utilities util = Utilities.getInstance();
	
	RequestBuilder requestBuilder = RequestBuilder.getRequestBuilder();
	ResponseBuilder responseBuilder = ResponseBuilder.getResponseBuilder();
	AddParameter addParameter = AddParameter.getInstance();
	StatusCode statusCode = StatusCode.getInstance();
	StatusLine statusLine = StatusLine.getInstance();
	ResponseHeader responseHeader = ResponseHeader.getInstance();
	ResponseTime responseTime = ResponseTime.getInstance();
	
	ResponseJsonPath responseJsonPath = ResponseJsonPath.getInstance();
	RequestBody requestBody = RequestBody.getInstance();
	BaseURL baseUrl = BaseURL.getInstance();
	JsonHandler jsonHandler = JsonHandler.getInstance();
	
	Comparison compare = Comparison.getInstance();
	Report report = Report.getInstance();
	ExtentManager extentManager = ExtentManager.getInstance();
}