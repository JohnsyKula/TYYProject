package practise;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.genericUtilities.ExcelUtility;

public class Data_Pro {
	
	@Test(dataProvider = "readData")
	public void getData(String src,String dst)
	{
		System.out.println("From----->"+src+" To------>"+dst);
	}
	
	
	@DataProvider
	public Object[][] readData() throws Throwable
	{
		ExcelUtility elib=new ExcelUtility();
		Object[][] value = elib.readMultipleSetOfData("DP");
		return value;
	}
	
	
	
	/*@DataProvider
	public Object[][] data() throws EncryptedDocumentException, IOException
	{
	FileInputStream fis=new FileInputStream("./src/test/resources/Edu.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("DP");
	int lastRow = sh.getLastRowNum()+1;
	System.out.println(lastRow);
	int lastCell = sh.getRow(0).getLastCellNum();
	
	Object[][] obj=new Object[lastRow][lastCell];  //create array
	for(int i=0;i<lastRow;i++)
	{
		for(int j=0;j<lastCell;j++)
		{
			obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
		}
	}
	return obj;
	}*/
	
	
	/*@DataProvider
	public Object[][] data()
	{
		Object[][] obj=new Object[3][2];
		obj[0][0]="qspider";
		obj[0][1]="testyantra";
		obj[1][0]="testyantra";
		obj[1][1]="Sony";
		obj[2][0]="Sony";
		obj[2][1]="Infosys";
		return obj;
	}*/
}
