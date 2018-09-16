package com.api.framework;

import com.api.framework.listener.TestListener;
import com.api.framework.utility.report.ExtentManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.ITestListener;
import org.testng.TestNG;

public class RunTestNG {

	private ExtentManager extentManager = ExtentManager.getInstance();
	
	public void executeTestNGXML(String xmlPath) {
		TestNG testNG = new TestNG(); 
		File file = new File(xmlPath);
		String absolutePath = file.getAbsolutePath();
		List<String> suite = new ArrayList<String>();
		
		//TestListener testListener = new TestListener();
		//testNG.addListener((ITestListener)testListener);
		suite.add(absolutePath);
		testNG.setTestSuites(suite);
		testNG.run();
		//extentManager.endReport();
	}
}
