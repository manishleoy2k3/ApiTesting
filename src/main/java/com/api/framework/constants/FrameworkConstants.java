package com.api.framework.constants;

import java.io.File;
import java.util.HashMap;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class FrameworkConstants {

	public static final String CONFIGFILE = "configuration/configuration.properties";
	public static HashMap<String, String> GLOBALCONFIG = new HashMap<String, String>();
	
	public static String TMP = "";
	public static String LOGDIR = "logs";
	public static String TMPDIR = "tmp";
	public static String EXECUTION_MODE = "";
	public static final String EXECUTOR_NAME = System.getProperty("user.name");
	public static ExtentReports EXTENT;
	public static ExtentReports REPORT;
	public static ExtentTest TESTCASE;
	public static ExtentTest REPORTNODE;
	public static Integer STEP_COUNTER = 0;
	public static String SCREENSHOT_LOCATION = TMP + File.separator + "screenshots" + File.separator;
	public static HashMap<String, String> APPLICATION_CONFIG = new HashMap<String, String>();
	public static HashMap<String, String> DATABASE_CONFIG = new HashMap<String, String>();
	public static HashMap<String, String> DATASHEET_CONFIG = new HashMap<String, String>();
	
}
