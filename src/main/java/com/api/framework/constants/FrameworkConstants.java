package com.api.framework.constants;

import java.util.HashMap;

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
}
