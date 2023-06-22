package practise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonIhone13 {
	@Test
	public static void writeData() throws EncryptedDocumentException, IOException, InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 13");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		List<WebElement> plist = driver.findElements(By.xpath("//span[contains(text(),'Apple iPhone 13') and not(contains(text(),'Cover')) and not(contains(text(),'Case'))]/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/child::div[@class='sg-row']/descendant::span[@class='a-price-whole']"));
		Thread.sleep(3000);
		FileInputStream fis=new FileInputStream("./src/test/resources/Edu.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.createSheet("Price1");
		String price;
		for(int i=0;i<plist.size();i++)
		{
			price=plist.get(i).getText();
			System.out.println(price);
			sheet.createRow(i).createCell(0).setCellValue(price);
		}
		System.out.println(plist.size());
		FileOutputStream fos=new FileOutputStream("./src/test/resources/Edu.xlsx");
		wb.write(fos);
		wb.close();
	}

}
