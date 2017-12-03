package com.automation.framework.core;

import org.testng.Reporter;

public abstract class BasePage {

	private SeleniumAction action =new SeleniumAction();
	
	public SeleniumAction getAction() {
		return action;
	}
	
	public void closeBrowser() {
		getAction().close();
	}
	
	public void logMessage(String message) {
		Reporter.log(message);
	}
}
