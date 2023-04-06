package client_module;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteClientTest {

	public static void main(String[] args) {
		//Login to the application
		WebDriverManager.chromedriver().create();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver/domain/Life_Insurance_Management_System/");
		driver.findElement(By.name("username")).sendKeys("555");
		driver.findElement(By.name("password")).sendKeys("666");
		driver.findElement(By.xpath("//button[text()='login']")).click();
		
		//click the particular client for updating & scroll down the page here i'm hard coding client id
		driver.findElement(By.linkText("CLIENTS")).click();	
		int y=driver.findElement(By.xpath("//td[text()='1665642317']/../td[8]/a[text()='Edit']")).getLocation().getY();
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollTo(0,"+y+")");
		driver.findElement(By.xpath("//td[text()='1665642317']/../td[8]/a[text()='Edit']")).click();
		driver.findElement(By.linkText("Delete Client")).click();
		
		//After deleting validating in nominee information page
		driver.findElement(By.linkText("NOMINEE")).click();
		List<WebElement> clientID = driver.findElements(By.xpath("//td[2]"));
		int count = clientID.size();
		int flag=0;
		for(int i=0;i<count;i++)
		{
			String text = clientID.get(i).getText();
			if(text.equals("1665642317"))
				flag++;
		}
		if(flag==0)
			System.out.println("Client is deleted successfully");
		else
			System.out.println("Client is not deleted");
	
        driver.close();
	}

}
