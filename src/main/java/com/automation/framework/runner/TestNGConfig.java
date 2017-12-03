package com.automation.framework.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlPackage;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.automation.framework.utils.TestProperties;

public class TestNGConfig {

	public void runTestNGTests() {
		TestNG testNG=new TestNG();
		testNG.setXmlSuites(createSuites());
		testNG.run();
				
	}
	
	public List<XmlSuite> createSuites() {
		//return null;
		XmlSuite suite = new XmlSuite();		 
		XmlTest test = new XmlTest(suite);
		test.setName(TestProperties.TEST_NAME);
		test.setPackages(getPackages());
		//test.setParallel(XmlSuite.ParallelMode.METHODS);
		test.setIncludedGroups(Arrays.asList(TestProperties.GROUP_INCLUDES.split(",")));
		List<XmlSuite> suites=new ArrayList<>();
		suites.add(suite);
		return suites;
	}
	
	public List<XmlPackage> getPackages(){
		String[] packages=TestProperties.PACKAGES.split(",");
		List<XmlPackage> xmlPackages=new ArrayList<>();
		for (String pack : packages) {
			xmlPackages.add(new XmlPackage(pack));
		}
		
		return xmlPackages;
	}
}
