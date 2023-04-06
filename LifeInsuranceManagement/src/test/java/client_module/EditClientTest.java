package client_module;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.genericUtilities.FileUtility;
import com.genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EditClientTest {

	public static void main(String[] args) throws Throwable {
		
		FileUtility flib=new FileUtility();
		WebDriverUtility wlib=new WebDriverUtility();
			
		//Login to the application
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
		driver.findElement(By.linkText("CLIENTS")).click();	
		List<WebElement> clientid = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		String id=null;
		for(int i=15;i<clientid.size();i++)
		{
		     id = clientid.get(i).getText();
		     System.out.println(id);
		     
			//click the particular client for updating & scroll down the page
			int y=driver.findElement(By.xpath("//td[text()='"+id+"']/../td[8]/a[text()='Edit']")).getLocation().getY();
			JavascriptExecutor j=(JavascriptExecutor)driver;
			j.executeScript("window.scrollBy(0,"+y+")");
			driver.findElement(By.xpath("//td[text()='"+id+"']/../td[8]/a[text()='Edit']")).click();
			driver.findElement(By.name("name")).clear();
			driver.findElement(By.name("name")).sendKeys("Kutty muyal");
			
			//Scroll down the page for clicking update button
			int y1=driver.findElement(By.name("submit")).getLocation().getY();
			j.executeScript("window.scrollBy(0,"+y1+")");
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(By.name("submit")));
			driver.findElement(By.name("submit")).click();	
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			
			
			//After updating validating the client information in client status page
			driver.findElement(By.linkText("CLIENTS")).click();
			int y2=driver.findElement(By.xpath("//td[text()='"+id+"']/../td[7]/a[text()='Client Status']")).getLocation().getY();
			j.executeScript("window.scrollBy(0,"+y2+")");
			driver.findElement(By.xpath("//td[text()='"+id+"']/../td[7]/a[text()='Client Status']")).click();
		    String text=driver.findElement(By.xpath("//input[@name='name']")).getAttribute("value");
		    System.out.println(text);
		    if(text.equals("Kutty muyal"))
		      System.out.println("Client information is updated successfully");
		    else
		    	System.out.println("Client information is not updated");
			break;
		}
	    driver.close();
	}
}
