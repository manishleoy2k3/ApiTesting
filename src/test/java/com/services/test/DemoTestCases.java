package com.services.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.ServicesAPI;
import com.api.framework.utility.files.ReadExcel;
import com.api.interfaces.IServices;
import com.api.utils.JsonHandler;
import com.services.requests.RequestBodyTemplate;

@Listeners (com.api.framework.listener.TestListener.class)
public class DemoTestCases {

	IServices services = new ServicesAPI();
	JsonHandler jsonutil = JsonHandler.getInstance();
	String baseURL = "http://httpbin.org";
	String resourcePath = "/post";
	RequestBodyTemplate rb = new RequestBodyTemplate();
	private static ReadExcel readExcel = new ReadExcel();
	private static String filePath = "C:\\Users\\manish\\eclipse-workspace\\com.test.api\\src\\main\\resources\\datasheets\\TestExcel.xlsx";
	
	
	@Test(description="Get Method of REST API Testing", enabled=true, priority=1)
	public void test1_performGetRequest() {
		
		services.setBaseURL("http://petstore.swagger.io").setBasePath("/v2/");
		services.header().addParameter("Content-Type").value("application/json");
		//services.queryParam().addParameter("id").value("123");
		//services.pathParam().addParameter("param1").value("VS");
		services.execute().getRequest();
	}
	
	@AfterMethod
	public void dispose() {
		
	}
}
