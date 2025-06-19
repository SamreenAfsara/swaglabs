package com.swaglabs.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SmartFunctions {

	WebDriver driver;
	protected LocatorReader readlocator ;
	public SmartFunctions(WebDriver driver, String pagename)
	{
		readlocator=new LocatorReader(pagename);
		this.driver=driver;
	}
	
	
	public WebElement getElement(String elementname)
	{
		String locatorvalue=readlocator.getLocator(elementname);
		WebElement element;
		String values[]=locatorvalue.split(":", 2);
		System.out.println(values[0]+" "+values[1]);
		
		switch(values[0])
		{
		case "id": 
			element = driver.findElement(By.id(values[1]));
			break;
		case "name":element = driver.findElement(By.name(values[1]));
			break;
		case "classname":element = driver.findElement(By.className(values[1]));
			break;
		case "linktext":element = driver.findElement(By.linkText(values[1]));
			break;
		case "xpath":element = driver.findElement(By.xpath(values[1]));
			break;
		case "css":element = driver.findElement(By.cssSelector(values[1]));
			break;
		case "tagname":element = driver.findElement(By.tagName(values[1]));
			break;
		case "partiallinktext":element = driver.findElement(By.partialLinkText(values[1]));
			break;
			default : element=null;
		}
		return element;	
	}
	
	protected List<WebElement> getElements(String elementname)
	{
		String locatorvalue=readlocator.getLocator(elementname);
		List<WebElement> element;
		String values[]=locatorvalue.split(":", 2);
		switch(values[0])
		{
		case "id": 
			element = driver.findElements(By.id(values[1]));
			break;
		case "name":element = driver.findElements(By.name(values[1]));
			break;
		case "classname":element = driver.findElements(By.className(values[1]));
			break;
		case "linktext":element = driver.findElements(By.linkText(values[1]));
			break;
		case "xpath":element = driver.findElements(By.xpath(values[1]));
			break;
		case "css":element = driver.findElements(By.cssSelector(values[1]));
			break;
		case "tagname":element = driver.findElements(By.tagName(values[1]));
			break;
		case "partiallinktext":element = driver.findElements(By.partialLinkText(values[1]));
			break;
			default : element=null;
		}
		return element;	
	}
	

	
	protected WebElement dynamicXpath(String locatorvalue)
	{
return driver.findElement(By.xpath("//*[text()='"+locatorvalue+"']"));		
	}
	
	protected void  enterText(String elementname,String testdata)
	{
		getElement(elementname).sendKeys(testdata);
	}
	
	protected void  click(String elementname) 
	{try {
		Thread.sleep(3000);
		
		getElement(elementname).click();
		}
		catch(Exception e)
		{
			
		}
	}
	
	protected void  actionsClick(String elementname)
	{
		Actions action = new Actions(driver);
		action.moveToElement(getElement(elementname)).click().build().perform();
	}
	
	protected void  jsClick(String elementname)
	{
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", getElement(elementname));
		
	}
	
	protected String  getText(String elementname)
	{
		return getElement(elementname).getText();
	}
	
	protected boolean isElementVisible(String elementname)
	{
		try {
		return getElement(elementname).isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	
}
