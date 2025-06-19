package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;

import com.swaglabs.utils.SmartFunctions;

public class ProductPage extends SmartFunctions {

	public ProductPage(WebDriver driver, String pagename) {
		super(driver, pagename);
		
	}
	
	public boolean isProductTitleVisible()
	{
		return isElementVisible("producttitle");
	}

	
}
