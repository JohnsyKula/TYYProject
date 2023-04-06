package client_module;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.genericUtilities.FileUtility;
import com.genericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteclientTest1 {

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
		
		//click the particular client for updating & scroll down the page here i'm hard coding client id
		driver.findElement(By.linkText("CLIENTS")).click();	
		List<WebElement> clientid = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		String id=null;
		for(int i=clientid.size()-1;i>=0;i--)
		{
		     id = clientid.get(i).getText();
		     System.out.println(id);
		    
		     driver.findElement(By.xpath("//td[text()='"+id+"']/../td[8]/a[text()='Edit']")).click();
				driver.findElement(By.linkText("Delete Client")).click();
				
				//After deleting validating in nominee information page
				driver.findElement(By.linkText("NOMINEE")).click();
				List<WebElement> clientID = driver.findElements(By.xpath("//tbody/tr/td[1]"));
				int count = clientID.size();
				int flag=0;
				for(int j=0;j<count;j++)
				{
					String text = clientID.get(j).getText();
					if(text.equals(id))
						flag++;
				}
				if(flag==0)
					System.out.println("Client is deleted successfully");
				else
					System.out.println("Client is not deleted");
		
		}
	
        driver.close();
	}

}
