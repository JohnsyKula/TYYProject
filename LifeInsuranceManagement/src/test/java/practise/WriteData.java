package practise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/Organization.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		//If the cell is empty it will throw null pointer Exception
		//wb.getSheet("Sheet1").getRow(5).getCell(0).setCellValue("TecnoElevate");
		wb.getSheet("Sheet1").createRow(5).createCell(0).setCellValue("Infosys");//it will create new cell and it store the data
		FileOutputStream fos=new FileOutputStream("./src/test/resources/Organization.xlsx");
		wb.write(fos);
		wb.close();
	}
}
