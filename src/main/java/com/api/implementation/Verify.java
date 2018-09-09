package com.api.implementation;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.api.interfaces.IGeneric;
import com.api.interfaces.IResponseHeader;
import com.api.interfaces.IResponseJsonPath;
import com.api.interfaces.IResponseTime;
import com.api.interfaces.IStatusCode;
import com.api.interfaces.IStatusLine;
import com.api.interfaces.IVerify;
import com.api.interfaces.IXPath;

import io.restassured.response.Response;

public class Verify implements IVerify, IGeneric{

	private static  Logger logger = Logger.getLogger(Verify.class);

	@Override
	public IResponseHeader header(String headerName) {
		responseHeader.setHeaderVal(responseBuilder.getResponse().getHeader(headerName));
		return ResponseHeader.getInstance();
	}

	@Override
	public IStatusCode statusCode() {
		statusCode.setStatusCode(responseBuilder.getResponse().getStatusCode());
		return statusCode;
	}

	@Override
	public IStatusLine statusLine() {
		statusLine.setStatusLine(responseBuilder.getResponse().getStatusLine());
		return statusLine;
	}

	@Override
	public IResponseTime responseTime(TimeUnit tUnit) {
		responseTime.setResponseTime((int) responseBuilder.getResponse().timeIn(TimeUnit.SECONDS));
		responseTime.setResponseTimeUnit(tUnit);
		return responseTime;
	}

	@Override
	public IResponseJsonPath JsonPath(String jpath) {
		responseJsonPath.setJsonPath(jpath);
		return ResponseJsonPath.getInstance();
	}

	public IXPath xPath(String xPath) {
		XPath.getInstance().setXpathValue(xPath);
		return XPath.getInstance();
	}

	@Override
	public void jsonResponseSchema(String filePath) {
		Response response = responseBuilder.getResponse();
		try {
			response.then().assertThat().body(matchesJsonSchema(new File(filePath)));
		} catch(AssertionError a) {
			logger.error("JSON response schema validation failed.");
		}
	}
}
