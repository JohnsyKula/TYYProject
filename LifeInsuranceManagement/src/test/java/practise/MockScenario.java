package practise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MockScenario {
	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 14 pro max");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		List<WebElement> allname = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> allprice = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price-whole']"));
	    LinkedHashMap<String, String> map=new LinkedHashMap<String, String>();
	    FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Education.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
	    Sheet sh = wb.createSheet("Amazon");
	    for(int i=0;i<allname.size();i++)
	    {
	    		String key=allname.get(i).getText();
	    		String value=allprice.get(i).getText();
	    		map.put(key, value);
	    }
	    FileOutputStream fos=new FileOutputStream(".\\\\src\\\\test\\\\resources\\\\Education.xlsx");
	    int j=0;
		for(String i:map.keySet())
	    {
	      String name=i;
	      String price=map.get(i);
	      sh.createRow(j).createCell(0).setCellValue(name);
	      sh.getRow(j).createCell(1).setCellValue(price);
	      j++;
	    }
		wb.write(fos);
		wb.close();
		driver.close();  	
	}

}
