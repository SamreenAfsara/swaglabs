package com.swaglabs.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class LocatorReader {

	private Properties pro;
	
	public LocatorReader(String filename) 
	{
		try {
		InputStream in =getClass().getClassLoader().getResourceAsStream("locators/"+filename+".properties");			
		pro=new Properties();
		 pro.load(in);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String getLocator(String locatorname)
	{
		return pro.getProperty(locatorname);
	}
	
	public static void main(String[] args) {
		
		LocatorReader read = new LocatorReader("loginpage");
		System.out.println(read.getLocator("username"));
		
	}
	
}
