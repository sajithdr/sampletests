package com.automation.framework.core;

public class PageElement {
	
	public enum findByType{
		XPATH,CSS,ID,CLASSNAME
	}

	String name;
	String value;
	findByType type;
	
	public PageElement(String name, String value, findByType type) {
		this.name = name;
		this.value = value;
		this.type = type;
	}

}
