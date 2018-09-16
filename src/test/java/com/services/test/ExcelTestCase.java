package com.services.test;

import java.util.HashMap;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.ServicesAPI;
import com.api.framework.utility.files.PropertiesFiles;
import com.api.framework.utility.files.ReadExcel;
import com.api.implementation.RequestBuilder;
import com.api.interfaces.IServices;
import com.api.utils.JsonHandler;
import com.services.requests.RequestBodyTemplate;

import io.restassured.builder.RequestSpecBuilder;

@Listeners (com.api.framework.listener.TestListener.class)
public class ExcelTestCase {

	IServices services = new ServicesAPI();
	JsonHandler jsonutil = JsonHandler.getInstance();
	RequestBodyTemplate rb = new RequestBodyTemplate();
	
	private static ReadExcel readExcel = new ReadExcel();
	
	private static String filePath = "Users\\manish\\Documents\\com.test.api\\src\\main\\resources\\datasheets\\TestExcel.xlsx";
	
	PropertiesFiles configFile = new PropertiesFiles();
	HashMap<String, String> configDetails = configFile.readProperties("configuration/webservices.properties");
	
	private String jpathBusinessName = "json.custProfBasic.aliasName.businessName";
	private String jpathfirstName = "json.custProfBasic.aliasName.firstName";
	private String jpathlastName = "json.custProfBasic.aliasName.lastName";
	
	@DataProvider(name="Requestdata")
	public static Object[][]RequestData(){
		return readExcel.getExcelData(filePath, "ServiceData");
	}
	
	@Test(description="Perform a POST Request and validate a particular field based on Json Path", dataProvider = "Requestdata", enabled=true, priority=1)
	public void PerformPostRequest(String jsonSource, String Employed, String salary, String firstName, String lastName, String businessName,
			String middleName, String titlePrefix, String Temperature, String accessCode, String rqUID) {
		
		//services.setBaseURL("http://petstore.swagger.io").setBasePath("/v2/");
		services.setBaseURL(configDetails.get("baseURL")).setBasePath(configDetails.get("resourcepath"));
		services.header().addParameter("Content-Type").value("application/json");
		String updateRequestBody = rb.modify_customRequestBody(jsonSource, Employed, salary, firstName, lastName, businessName, middleName, titlePrefix, Temperature, accessCode, rqUID);
		services.setRequestBody(updateRequestBody);
		services.execute().postRequest();
		services.verify().JsonPath(jpathBusinessName).isEqualTo(true, businessName);
		services.verify().JsonPath(jpathfirstName).isEqualTo(true, firstName);
		services.verify().JsonPath(jpathlastName).isEqualTo(true, lastName);
	}
	
	@AfterMethod
	public void dispose() {
		RequestBuilder.getRequestBuilder();
		RequestBuilder.killRequestSpecBuilder();
	}
}
