package com.automation.framework.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.automation.framework.utils.TestProperties;

public class SeleniumAction {
	private WebDriver driver;
	String path="E:\\MyProjects\\Selenium";

	public SeleniumAction() {
		String browser=TestProperties.BROWSER.toUpperCase();
		switch (browser) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", path+"\\chromedriver.exe");
			driver=new ChromeDriver();

			break;
		case "FIREFOX":

			break;

		default:
			break;
		}
	}
	
	public void open(String url) {
		driver.manage().window().maximize();
		driver.navigate().to(url);
	}
	public void close() {
		driver.close();
		driver.quit();
		
	}

	public void type(PageElement pageElement,String value) {
		WebElement element=getWebElement(pageElement);
		element.clear();
		element.sendKeys(value);
	}
	
	public void click(PageElement pageElement) {
		WebElement element=getWebElement(pageElement);
		element.click();
	}
	
	public WebElement getWebElement(PageElement pageElement) {
		WebElement element=driver.findElement(getBy(pageElement));
		return element;
	}
	
	public By getBy(PageElement pageElement) {
		By by=null;
		switch (pageElement.type) {
		case XPATH:
			by=By.xpath(pageElement.value);
			break;
		case CLASSNAME:
			by=By.className(pageElement.value);
			break;
		case CSS:
			by=By.cssSelector(pageElement.value);
			break;
		case ID:
			by=By.id(pageElement.value);
			break;
		}
		return by;
	}
}
