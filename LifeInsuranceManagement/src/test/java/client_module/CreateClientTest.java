package client_module;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.genericUtilities.ExcelUtility;
import com.genericUtilities.FileUtility;
import com.genericUtilities.JavaUtility;
import com.genericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateClientTest {

	public static void main(String[] args) throws Throwable {
	    //creating object for generic utilities
		ExcelUtility elib=new ExcelUtility();
		FileUtility flib=new FileUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		JavaUtility jlib=new JavaUtility();
		
		WebDriverManager.chromedriver().create();
		WebDriver driver=new ChromeDriver();
		wlib.maximizeWindow(driver);
		wlib.waitForImplicitly(driver);
		
		//login to the application   // get data from property file
		String ul=flib.readDataFromPropertyFile("url");
		String un=flib.readDataFromPropertyFile("username");
		String pw=flib.readDataFromPropertyFile("password");
		
		driver.get(ul);
		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pw);
		driver.findElement(By.xpath("//button[text()='login']")).click();
		
		//add client
		driver.findElement(By.linkText("CLIENTS")).click();
		driver.findElement(By.linkText("Add Client")).click();
		int randomno = jlib.random();
		HashMap<String, String> map = elib.readMultipleData("Client");
		for(Entry<String, String> i:map.entrySet())
		{
			if(i.getKey().equals("name"))
			{
			   driver.findElement(By.name(i.getKey())).sendKeys(i.getValue()+randomno);
			}
			else
			{
				driver.findElement(By.name(i.getKey())).sendKeys(i.getValue());
			}
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
