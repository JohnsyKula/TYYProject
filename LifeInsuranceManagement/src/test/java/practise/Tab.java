package practise;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tab {
	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		driver.findElement(By.xpath("(//div[@class='menu_icon'])[4]")).click();
		driver.findElement(By.linkText("About your actiTIME")).click();
		Thread.sleep(1000);
		driver.findElement(By.partialLinkText("Read Service Agreement")).click();
		Thread.sleep(1000);
		String pwd=driver.getWindowHandle();
		System.out.println(driver.getTitle());
		Set<String> allwh = driver.getWindowHandles();
		for(String wh:allwh)
		{
			if(!wh.equals(pwd))
			{
			    driver.switchTo().window(wh);
			    System.out.println(driver.getTitle());
			    
			}
		}
//		//Thread.sleep(2000);
//		List<WebElement> heading = driver.findElements(By.xpath("//h2"));
//		Thread.sleep(2000);
//		for(WebElement i:heading)
//		{
//			System.out.println(i.getText());
//		}
//		driver.quit();
	}
}
