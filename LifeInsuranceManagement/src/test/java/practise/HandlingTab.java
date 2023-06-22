package practise;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingTab {
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException
	{
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
		Set<String> allwh = driver.getWindowHandles();
		for(String wh:allwh)
		{
			driver.switchTo().window(wh);
		
		}
		Thread.sleep(2000);
		List<WebElement> heading = driver.findElements(By.xpath("//h2"));
		Thread.sleep(2000);
		for(WebElement i:heading)
		{
			System.out.println(i.getText());
		}
		driver.quit();
	}

}
