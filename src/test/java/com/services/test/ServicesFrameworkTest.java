package com.services.test;

import java.io.IOException;

import com.api.base.AbstractServices;
import com.api.base.ServicesAPI;
import com.api.framework.RunTestNG;
import com.api.interfaces.IServices;

public class ServicesFrameworkTest extends AbstractServices{

	IServices services = new ServicesAPI();
	private static RunTestNG testNG = new RunTestNG();
	
	public static void main(String[] args) throws IOException{
		testNG.executeTestNGXML("src/test/resources/xml/serviceTestNG.xml");
	}
}
