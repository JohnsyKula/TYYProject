package practise;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadMultiple {
	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		readMul();
	}
	public static void readMul() throws EncryptedDocumentException, IOException
	{
		FileInputStream  fis=new FileInputStream("./src/test/resources/Education.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("data2");
		int lastrow=sh.getLastRowNum();
		System.out.println(lastrow);
		int lastcolumn=sh.getRow(0).getLastCellNum();	
		System.out.println(lastcolumn);
	}
	

}
