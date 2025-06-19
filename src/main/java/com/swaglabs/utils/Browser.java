package com.swaglabs.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class Browser {

	protected static WebDriver driver;
	
	protected static void launchBrowser(String browsername)
	{
		if(browsername.equalsIgnoreCase("chrome"))
		{
			// headless
			System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
//			 driver = new ChromeDriver();
			  
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("--remote-allow-origins=*"); 
			driver = new ChromeDriver(options);
		}
		else {
			
			
		}
			 //driver=new EdgeDriver();
	}
	
	
	protected static void openURL()
	{
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}
	
	
	protected static void openURL(String url)
	{
		driver.get(url);
	}
	
	protected static void close()
	{
		if(driver!=null)
		driver.close();
	}
	
	protected static void quit()
	{
		driver.quit();
	}
	
	//clear cache
	
	
	
}
