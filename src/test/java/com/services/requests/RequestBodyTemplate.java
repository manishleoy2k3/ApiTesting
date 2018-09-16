package com.services.requests;

import com.api.utils.JsonHandler;

public class RequestBodyTemplate {

	JsonHandler jsonHandler =JsonHandler.getInstance();
	
	private String jpathEmployed = "custProfBasic.Employed";
	private String jpathSalary = "custProfBasic.Salary";
	private String jpathfirstName = "custProfBasic.aliasName.firstName";
	private String jpathlastName = "custProfBasic.aliasName.lastName";
	private String jpathbusinessName = "custProfBasic.aliasName.businessName";
	private String jpathmiddleName = "custProfBasic.aliasName.middleName";
	private String jpathtitlePrefix = "custProfBasic.aliasName.titlePrefix";
	private String jpathTemperature = "custProfBasic.Temperature";
	private String jpathaccessCode = "custProfBasic.accessCode";
	private String jpathrqUID = "rqUID.rqUID";
	
	
	public String modify_customRequestBody(String jsonSource, String employed, String salary, String firstName,
			String lastName, String businessName, String middleName, String titlePrefix, String Temperature, String accessCode,
			String rqUID) {
		try {
			jsonSource = jsonHandler.modifyJson(jsonSource, jpathEmployed, (Object) Boolean.parseBoolean(employed));
			jsonSource = jsonHandler.modifyJson(jsonSource, jpathSalary, (Object) Double.parseDouble(salary));
			jsonSource = jsonHandler.modifyJson(jsonSource, jpathfirstName, (Object)firstName);
			jsonSource = jsonHandler.modifyJson(jsonSource, jpathlastName, (Object) lastName);
			jsonSource = jsonHandler.modifyJson(jsonSource, jpathbusinessName, (Object) businessName);
			jsonSource = jsonHandler.modifyJson(jsonSource, jpathmiddleName, (Object) middleName);
			jsonSource = jsonHandler.modifyJson(jsonSource, jpathtitlePrefix, (Object) titlePrefix);
			jsonSource = jsonHandler.modifyJson(jsonSource, jpathTemperature, (Object) Double.parseDouble(Temperature));
			jsonSource = jsonHandler.modifyJson(jsonSource, jpathaccessCode, (Object) Long.parseLong(accessCode));
			jsonSource = jsonHandler.modifyJson(jsonSource, jpathrqUID, (Object) Long.parseLong(rqUID));
			
		} catch(Exception e) {
			e.getMessage();
		}
		return jsonSource;
	}

	public String modify_customRequestBodyFromFile(String jsonSourceFileName, Object employed, Object salary, Object firstName,
			Object lastName, Object businessName, Object middleName, Object titlePrefix, Object Temperature, Object accessCode,
			Object rqUID) {
		
		String jsonSource = jsonHandler.readJsonFromFile(jsonSourceFileName).toString();
		try {
			jsonSource = jsonHandler.modifyJson(jsonSource, jpathEmployed, employed);
			jsonSource = jsonHandler.modifyJson(jsonSource, jpathSalary, salary);
			jsonSource = jsonHandler.modifyJson(jsonSource, jpathfirstName, firstName);
			jsonSource = jsonHandler.modifyJson(jsonSource, jpathlastName, lastName);
			jsonSource = jsonHandler.modifyJson(jsonSource, jpathbusinessName, businessName);
			jsonSource = jsonHandler.modifyJson(jsonSource, jpathmiddleName, middleName);
			jsonSource = jsonHandler.modifyJson(jsonSource, jpathtitlePrefix, titlePrefix);
			jsonSource = jsonHandler.modifyJson(jsonSource, jpathTemperature, Temperature);
			jsonSource = jsonHandler.modifyJson(jsonSource, jpathaccessCode, accessCode);
			jsonSource = jsonHandler.modifyJson(jsonSource, jpathrqUID, rqUID);
			
		} catch(Exception e) {
			e.getMessage();
		}
		jsonHandler.writeJsonToFile(jsonSource, jsonSourceFileName);
		return jsonSource;
	}
}
