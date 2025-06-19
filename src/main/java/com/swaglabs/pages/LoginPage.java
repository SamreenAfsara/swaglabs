package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;

import com.swaglabs.utils.SmartFunctions;

public class LoginPage extends SmartFunctions {

	public LoginPage(WebDriver driver, String pagename) {
		super(driver, pagename);
	}
	
	
	public void enterUsername(String uname)
	{
		enterText("username", uname);
	}
	public void enterPassword(String pass)
	{
		enterText("password", pass);
	}
	public void clickonLoginbtn()
	{
		click("loginbtn");
	}
	
	public String getErrorMSg()
	{
		
		return getText("errormsg");
	}
	

}
