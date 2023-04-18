package practise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggession {
	
	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.name("q")).sendKeys("mens");
		Thread.sleep(2000);
		List<WebElement> allOp = driver.findElements(By.xpath("//ul/li/div/a/div[2]"));
		int count=allOp.size();
		System.out.println(count);
		for(int i=0;i<count;i++)
		{
			Thread.sleep(500);
            String text = allOp.get(i).getText();
            System.out.println(text);    
		}
	  
		driver.close();

	}
	

}
