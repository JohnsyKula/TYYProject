package com.genericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * This method is used to read data from excel sheet
	 * @param SheetName
	 * @param RowNo
	 * @param columnNo
	 * @return String
	 * @throws Throwable
	 */
	public String readDataFromExcel(String SheetName,int RowNo,int columnNo) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(SheetName);
		String value=sh.getRow(RowNo).getCell(columnNo).getStringCellValue();
		return value;	
	
	}
	/**
	 * This method is used to get the row count
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getLastRowNo(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		return count;
	}
	/**
	 * This method is used to write the data into Excel
	 * @param sheetName
	 * @param rownum
	 * @param columnnum
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheetName,int rownum,int columnnum,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IPathConstants.excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		sh.getRow(rownum).createCell(columnnum).setCellValue(data);
        FileOutputStream fos = new FileOutputStream(IPathConstants.excelPath);	
        wb.write(fos);
        wb.close();
	}
	/**
	 * This method is read multiple data from excel sheet
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 */
	public HashMap<String, String> readMultipleData(String SheetName) throws Throwable, IOException
	{
		FileInputStream fis = new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(SheetName);
		int count=sh.getLastRowNum();
		HashMap<String, String> map = new LinkedHashMap<String,String>();
		for(int i=0;i<=count;i++)
		{
			String key=sh.getRow(i).getCell(0).getStringCellValue();
			String value=sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}
	/**
	 * This method is used read data from excel & store it in object array & using data provider
	 * @param sheetname
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleSetOfData(String sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream  fis=new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int lastrow=sh.getLastRowNum()+1;
		int lastcolumn=sh.getRow(0).getLastCellNum();
		
		Object[][] obj=new Object[lastrow][lastcolumn];
		for(int i=0;i<lastrow;i++)
		{
			for(int j=0;j<lastcolumn;j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
	
}
