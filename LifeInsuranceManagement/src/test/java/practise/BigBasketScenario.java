package practise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BigBasketScenario {
	
public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.bigbasket.com/");
	WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'Shop by')]"));
	Actions a=new Actions(driver);
	a.moveToElement(ele).perform();
	List<WebElement> alllink = driver.findElements(By.xpath("//ul[@id='navBarMegaNav']/following-sibling::div//ul[@class='nav nav-pills nav-stacked']//a"));
    for(int i=0;i<alllink.size();i++)
    {
    String val = alllink.get(i).getText();
	WebElement ele1 = driver.findElement(By.xpath("//ul[@id='navBarMegaNav']/following-sibling::div//a[text()='"+val+"']"));
	a.moveToElement(ele1).perform();
	System.out.println(ele1.getText());
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\BigBasket.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	wb.createSheet(ele1.getText());
    List<WebElement> list = driver.findElements(By.xpath("//ul[@id='navBarMegaNav']/following-sibling::div//a[text()='"+val+"']/ancestor::div[@class='col-md-3 pad-rt-0 desgn-fix']/following-sibling::div//a"));
    int k=0;
    for(WebElement j:list)
    {
    	wb.getSheet(ele1.getText()).createRow(k).createCell(0).setCellValue(j.getText());
    	System.out.println(j.getText());
    	k++;
    }
    FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\BigBasket.xlsx");
    wb.write(fos);
    wb.close();
    }
    
    driver.close();
}

}
