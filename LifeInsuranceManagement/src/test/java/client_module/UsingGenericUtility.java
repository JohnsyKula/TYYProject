package client_module;

import java.util.HashMap;
import java.util.Map.Entry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.genericUtilities.ExcelUtility;
import com.genericUtilities.FileUtility;
import com.genericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UsingGenericUtility {
public static void main(String[] args) throws Throwable {
	
	//creating object for generic utilities
	ExcelUtility elib=new ExcelUtility();
	FileUtility flib=new FileUtility();
	WebDriverUtility wlib=new WebDriverUtility();
		
		//login to the application   // get data from property file
		WebDriverManager.chromedriver().create();
		WebDriver driver=new ChromeDriver();
		wlib.maximizeWindow(driver);
		wlib.waitForImplicitly(driver);
		String ul=flib.readDataFromPropertyFile("url");
		String un=flib.readDataFromPropertyFile("username");
		String pw=flib.readDataFromPropertyFile("password");
		
		driver.get(ul);
		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pw);
		driver.findElement(By.xpath("//button[text()='login']")).click();
		
		//add  client
		driver.findElement(By.linkText("CLIENTS")).click();
		driver.findElement(By.linkText("Add Client")).click();
		
	    	
	
		/*FileInputStream fis1=new FileInputStream("./src/test/resources/Edu.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Client");
		HashMap<String,String> map=new HashMap<String,String>();
		for(int i=0;i<sh.getLastRowNum();i++)
		{
			String key=sh.getRow(i).getCell(0).getStringCellValue();
			String value=sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}*/
		
		
		HashMap<String, String> map = elib.readMultipleData("Client");
		for(Entry<String, String> i:map.entrySet())
		{
			driver.findElement(By.name(i.getKey())).sendKeys(i.getValue());
		}
		Thread.sleep(6000);
		driver.findElement(By.xpath("//input[@type='submit']")).submit();
		String expectedResult="INSERT CLIENT";
		String actuvalResult = driver.findElement(By.xpath("//div/h1")).getText();
		if(actuvalResult.contains(expectedResult))
		   System.out.println("Client is added successfully");
		else
			System.out.println("Client is not added");

		driver.close();
	}



}
