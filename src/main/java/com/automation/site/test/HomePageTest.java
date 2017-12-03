package com.automation.site.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.automation.site.page.HomePage;

public class HomePageTest {
	HomePage homepage=new HomePage();

	
	String URL="http://demo.guru99.com/selenium/newtours/";
	@Test(groups= {"Sanity"})
	public void login() {
		homepage.openHomePageUrl(URL)
		.login();
	}
	
	@Test(groups= {"SanityNot"})
	public void loginNot() {
		homepage.openHomePageUrl("http://demo.guru99.com/");
		//.login();
	}
	
	@AfterTest
	public void teardown() {
		homepage.closeBrowser();
	}
}
