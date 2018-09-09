package com.api.framework;

import org.apache.log4j.Logger;

import com.api.framework.constants.FrameworkConstants;
import com.api.interfaces.IReport;
import com.aventstack.extentreports.Status;

public class Report implements IReport{

	private static Report instance = null;
	private static  Logger logger = Logger.getLogger(Report.class);
			
	protected Report() {
		
	}
	
	public static Report getInstance() {
		if(null == instance) {
			instance = new Report();
		}
		return instance;
	}

	public void log(String message, String value, Status pass) {
		FrameworkConstants.STEP_COUNTER++;
		logger.info("Step: " + FrameworkConstants.STEP_COUNTER + " : " + message);
		
	}

}
