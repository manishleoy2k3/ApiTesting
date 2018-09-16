package com.api.framework;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.api.framework.constants.FrameworkConstants;
import com.api.interfaces.IReport;
import com.aventstack.extentreports.Status;

public class Report implements IReport{

	private static Report instance = null;
	private static Logger logger = Logger.getLogger(Report.class);
	
	private String appendScreenshot = "";
	
	protected Report() {
		
	}
	
	public static Report getInstance() {
		if(null == instance) {
			instance = new Report();
		}
		return instance;
	}

	public void log(String message, String value, WebElement element, Status status) {
		FrameworkConstants.STEP_COUNTER++;
		logger.info("Step: " + FrameworkConstants.STEP_COUNTER + " : " + message + " Parameter : " +value);
		//TODO : Screenshot details logic		
	}
	
	public void log(String message, String value, Status status) {
		if((!FrameworkConstants.GLOBALCONFIG.get("DEVICE").equalsIgnoreCase("webservice"))) {
			FrameworkConstants.STEP_COUNTER++;
			logger.info("Step: " + FrameworkConstants.STEP_COUNTER + " : " + message + " Parameter : " +value);
			//TODO : Screenshot details logic	
		} else {
			if(true) { //TODO SetUpConstants.HTMLREPORT
				setStepStatus(status, message, value);
			}
		}
	}

	private void setStepStatus(Status status, String message, String value) {
		FrameworkConstants.TESTCASE.log(status, message + " " + "<span style='font-weight:bold;'>" + value + "</span>" + appendScreenshot);
	}
}
