package practise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteMultipleData {


	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		writeData();
	}
	public static void writeData() throws EncryptedDocumentException, IOException
	{
		
		Scanner sc=new Scanner(System.in);

		FileInputStream fis=new FileInputStream("./src/test/resources/Education.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		//If the cell is empty it will throw null pointer Exception
		//wb.getSheet("Sheet1").getRow(5).getCell(0).setCellValue("TecnoElevate");
		System.out.println("Enter sheet name");
		String sname=sc.nextLine();
		Sheet sh=wb.getSheet(sname);
		int rowno = sh.getLastRowNum();
		int row=rowno+1;
		for(int i=row;i<row+3;i++)
		{
			System.out.println("Enter name");
			String name=sc.nextLine();
			System.out.println("Enter Qualification");
			String qul=sc.nextLine();
			FileOutputStream fos=new FileOutputStream("./src/test/resources/Education.xlsx");
			wb.getSheet(sname).createRow(i).createCell(0).setCellValue(name);//it will create new cell and it store the data	
		    wb.getSheet(sname).getRow(i).createCell(1).setCellValue(qul);
		    wb.write(fos);
		}
		wb.close();
		sc.close();
	}

}
