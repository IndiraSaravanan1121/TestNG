package com.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public FileInputStream fi;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	String path;
	
	public ExcelUtility(String path) {
		this.path = path;
	}
	
	public int getRowCount(String sheetName) throws IOException {
		fi=new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		fi.close();
		return rowcount;	
	}
	
	public int getCellCount(String sheetName, int rowNum) throws IOException {
		fi=new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		fi.close();
		return cellCount;	
	}
	
	public String getCellData(String sheetName, int rowNo, int colNo) throws IOException {
		
		fi= new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet =workbook.getSheet(sheetName);
		row=sheet.getRow(rowNo);
	    cell=row.getCell(colNo);
	    
	    DataFormatter formatter = new DataFormatter();
	    String data;
	    try {
	    	data = formatter.formatCellValue(cell);
	    }catch(Exception e) {
	    	data="";
	    }
	    fi.close();
		return data;
	}
}
