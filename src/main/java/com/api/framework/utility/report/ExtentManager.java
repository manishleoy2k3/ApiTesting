package com.api.framework.utility.report;

import java.net.InetAddress;


import com.api.framework.constants.FrameworkConstants;
import com.api.framework.utility.DateTime;
import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager {

	private ExtentReports extent;
	private ExtentHtmlReporter htmlReporter;
	private static ExtentManager instance = null;	
	private static InetAddress ip;
	
	protected ExtentManager() {
		
	}
	
	public static ExtentManager getInstance() {
		if(null == instance) {
			instance = new ExtentManager();
		}
		return instance;
	}

	public ExtentReports getExtent() {
		if(extent != null)
			return extent;
		
		extent = new ExtentReports();
		extent.attachReporter(getHtmlReporter());
		return extent;
	}

	private ExtentHtmlReporter getHtmlReporter() {

		String filePath = FrameworkConstants.TMP+"/extentreport.html";
		try {
			ip = InetAddress.getLocalHost();
			
			htmlReporter = new ExtentHtmlReporter(filePath);
			
			htmlReporter.config().setDocumentTitle(FrameworkConstants.GLOBALCONFIG.get("HTML_REPORT_TITLE"));
			htmlReporter.config().setReportName("" + DateTime.getCurrentTime("ddMMyyyyhhmmss"));
			htmlReporter.config().setTheme(Theme.STANDARD);
			extent.setAnalysisStrategy(AnalysisStrategy.TEST);
			htmlReporter.config().setTimeStampFormat("MM/dd/yyyy hh:mm:ss a");
			htmlReporter.config().setChartVisibilityOnOpen(true);
			
			extent.setSystemInfo("OS", System.getProperty("os.name").toUpperCase());
			extent.setSystemInfo("Host Name", ip.getHostName());
			extent.setSystemInfo("IP", ip.toString());
			extent.setSystemInfo("User Name", System.getProperty("user.name"));
			extent.setSystemInfo("Environment", "QA");
			
			return htmlReporter;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return htmlReporter;
	}

	public ExtentTest createTest(String description) {
		return FrameworkConstants.TESTCASE = extent.createTest(description);
	}
	
	public void createNode(String stepDescription) {
		FrameworkConstants.REPORTNODE = FrameworkConstants.TESTCASE.createNode(stepDescription);
	}
	
	/*public void endReport() {
		extent.flush();
	}*/
}
