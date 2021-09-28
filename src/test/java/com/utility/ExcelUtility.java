package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	String userdir = System.getProperty("user.dir");
	String excelpath = userdir+PropertyReader.properyReader("excelpath");
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null; 
	

		public String readExcelData(String sheetname, String Colname, int rowNum) throws IOException {
			
			workbook = new XSSFWorkbook(excelpath);
			sheet = workbook.getSheet(sheetname);
			//int rows = sheet.getLastRowNum();
			int cols = sheet.getRow(0).getLastCellNum();
			row= sheet.getRow(0);
			int colno = 0; 
			String Cellvalue = null;
				
		for(int r=0; r< cols; r++)
		{
			String value = row.getCell(r).getStringCellValue();
			if(value.equals(Colname))
				{
				colno = r;
				}
		}
		row = sheet.getRow(rowNum-1);
		cell = row.getCell(colno);
		DataFormatter df = new DataFormatter();
		Cellvalue = df.formatCellValue(cell);
		return Cellvalue;
		
		}
}
