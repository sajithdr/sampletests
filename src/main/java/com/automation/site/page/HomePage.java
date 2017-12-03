package com.automation.site.page;

import com.automation.framework.core.BasePage;
import com.automation.framework.core.PageElement;
import com.automation.framework.core.PageElement.findByType;

public class HomePage extends BasePage{

	public static final PageElement LOGIN_BUTTON= new PageElement("Sign-in button", "//input[@value='Login']", findByType.XPATH);
	public static final PageElement USERNAME= new PageElement("User Name text Box", "//input[@name='userName']", findByType.XPATH);
	public static final PageElement PASSWORD= new PageElement("Password Text Box", "//input[@name='password']", findByType.XPATH);

	public HomePage openHomePageUrl(String url) {
		logMessage("Open the base url");
		getAction().open(url);
		return this;
	}
	
	public HomePage login() {
		logMessage("Do Login");
		getAction().type(USERNAME,"SajithDR");
		getAction().type(PASSWORD, "password");
		getAction().click(LOGIN_BUTTON);
		
		return this;
	}
}
