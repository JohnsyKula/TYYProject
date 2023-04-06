package practise;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/Edu.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int count=wb.getSheet("Client").getLastRowNum();
		System.out.println(count);
		int cellcount=wb.getSheet("Client").getRow(0).getLastCellNum();
		System.out.println(cellcount);
		for(int i=1;i<count;i++)
		{
		String branch = wb.getSheet("Client").getRow(i).getCell(0).getStringCellValue();
		String place = wb.getSheet("Client").getRow(i).getCell(1).getStringCellValue();
		
		System.out.println(branch+" "+place);
	    }
	}

}
