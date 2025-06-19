package com.swaglabs.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadTestData {

	private Sheet sheet;
	public ReadTestData(String filename)
	{
		
		
		String projectpath=System.getProperty("user.dir");
		String filepath=projectpath+"/src/main/resources/testdata/"+filename+".xlsx";
		File f = new File(filepath);
		if(!f.exists())
		{
			System.out.println("File not found : "+filepath);
		return;
		}
		try {
			FileInputStream instream = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(instream);
			 sheet=wb.getSheetAt(0);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	
	
	public String getData(int rowno,int colno)
	{
		return sheet.getRow(rowno).getCell(colno).getStringCellValue();
	}
	

	public List<String> getData(int rowno)
	{
		int cellscount = sheet.getRow(rowno).getLastCellNum();
		List<String> rowdata= new ArrayList<String>();
		for(int i=0;i<cellscount;i++)
		{
			rowdata.add(sheet.getRow(rowno).getCell(i).getStringCellValue());
		}
		return rowdata;
	}
	
	public String[][] getData()
	{
		int lastrowno=sheet.getLastRowNum();  // 8
		int cellscount = sheet.getRow(0).getLastCellNum(); // 2
		String testdata[][] = new String[lastrowno][cellscount];
		int k=0,l;
		
		for(int i=1;i<=lastrowno;i++)
		{
			l=0;
			for(int j=0;j<cellscount;j++)
			{
				testdata[k][l]=sheet.getRow(i).getCell(j).getStringCellValue();
				l++;
			}
		k++;
		}
		return testdata;
	}
	
	public String[][] getTestData(int limit)
	{
		
		int cellscount = sheet.getRow(0).getLastCellNum(); // 2
		String testdata[][] = new String[limit][cellscount];
		int k=0,l;
		
		for(int i=1;i<=limit;i++)
		{
			l=0;
			for(int j=0;j<cellscount;j++)
			{
				testdata[k][l]=sheet.getRow(i).getCell(j).getStringCellValue();
				l++;
			}
		k++;
		}
		return testdata;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		ReadTestData read = new ReadTestData("loginpage");
		String data[][]=read.getTestData(3);
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	/*
	 
	 Workbook
	 Sheets
	 Rows
	 cells
	 
	 */
}
