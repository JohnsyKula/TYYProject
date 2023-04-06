package client_module;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WithoutHardcodingTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//login to the application   // get data from property file
		WebDriverManager.chromedriver().create();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		FileInputStream fis=new FileInputStream("./src/test/resources/Commendata.properties");
		Properties p=new Properties();
	    p.load(fis);
	    String ul=p.getProperty("url");
	    String un=p.getProperty("username");
	    String pw=p.getProperty("password");
		driver.get(ul);
		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pw);
		driver.findElement(By.xpath("//button[text()='login']")).click();
		
		//add  client
		driver.findElement(By.linkText("CLIENTS")).click();
		driver.findElement(By.linkText("Add Client")).click();
		
		FileInputStream fis1=new FileInputStream("./src/test/resources/Edu.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Client");
		
		
		HashMap<String,String> map=new HashMap<String,String>();
		for(int i=0;i<sh.getLastRowNum();i++)
		{
			String key=sh.getRow(i).getCell(0).getStringCellValue();
			String value=sh.getRow(i).getCell(1).getStringCellValue();
			
			map.put(key, value);
		}
		for(Entry<String, String> i:map.entrySet())
		{
			driver.findElement(By.name(i.getKey())).sendKeys(i.getValue());
		}
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
