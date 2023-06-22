package practise;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mictest {
	private static final Object AllowButton = null;

	public static void main(String[] args) throws AWTException, InterruptedException
	{
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		option.addArguments("--use-fake-device-for-media-stream");
		option.addArguments("--use-fake-ui-for-media-stream");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://mictests.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("mic-launcher")).click();
		
//		Robot r=new Robot();
//		r.keyPress(KeyEvent.VK_TAB);
//		r.keyRelease(KeyEvent.VK_TAB);
//		r.keyPress(KeyEvent.VK_TAB);
//		r.keyRelease(KeyEvent.VK_TAB);
//		r.keyPress(KeyEvent.VK_ENTER);
//		r.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//a[text()='Test Webcam']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Set<String> list = driver.getWindowHandles();
		for(String i:list)
		{
				driver.switchTo().window(i);
		
				String tit = driver.getTitle();
				System.out.println(tit);
				if(tit.equals("Webcam Test"))
				{
					break;
				}
			
		}
		driver.findElement(By.id("webcam-launcher")).click();
		//driver.close();
	}

}
