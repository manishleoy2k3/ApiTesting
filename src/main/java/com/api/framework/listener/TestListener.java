package com.api.framework.listener;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.api.framework.Report;
import com.api.framework.constants.FrameworkConstants;
import com.api.framework.utility.report.ExtentManager;
import com.aventstack.extentreports.Status;


public class TestListener implements ITestListener{

	private static  Logger logger = Logger.getLogger(TestListener.class);
	private ExtentManager extentManager = ExtentManager.getInstance();
	private Report report = Report.getInstance();
	
	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		FrameworkConstants.TESTCASE.assignCategory(getGroupName(arg0));
		logger.error(arg0.getThrowable().getMessage());
		report.log(arg0.getThrowable().getMessage(), "", Status.FAIL);
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {

		FrameworkConstants.TESTCASE = extentManager.createTest(getDescription(arg0));
		FrameworkConstants.TESTCASE.assignCategory(getGroupName(arg0));
		report.log("Test case is Skipped.", "", Status.SKIP);
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		FrameworkConstants.TESTCASE = extentManager.createTest(getDescription(arg0));
		FrameworkConstants.TESTCASE.assignCategory(getGroupName(arg0));
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		report.log("Test case is Pass.", "", Status.PASS);
	}

	private String[] getGroupName(ITestResult arg0) {
		try {
			return arg0.getMethod().getGroups();
		} catch(Exception e) {
			return new String[] { "un-Categories" };
		}
	}

	private String getDescription(ITestResult arg0) {
		String description = "";
		try {
			description = arg0.getMethod().getDescription().trim();
			logger.info(arg0.getMethod().getDescription() + "test case started.");
		} catch(Exception e) {
			logger.info(arg0.getMethod().getDescription() + "test case started.");
			description = "Description not present. MethodName " + arg0.getName();
		}
		return description;
	}
}
