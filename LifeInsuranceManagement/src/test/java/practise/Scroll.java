package practise;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scroll {
	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
//		Thread.sleep(1000);
//		JavascriptExecutor j=(JavascriptExecutor)driver;
//		j.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//		Thread.sleep(1000);
//		j.executeScript("window.scrollTo(0,0)");
//		Thread.sleep(1000);
//		int y = driver.findElement(By.xpath("//a[text()='Australia']")).getLocation().getY();
//		j.executeAsyncScript("window.scrollTo(0,"+y+")");	
//		String color = driver.findElement(By.xpath("//span[@class='icp-nav-flag icp-nav-flag-in icp-nav-flag-lop']")).getCssValue("position");
//	    System.out.println(color);
//		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Samsung s20");
//		Thread.sleep(2000);
//		List<WebElement> list = driver.findElements(By.xpath("//div[@class='s-suggestion s-suggestion-ellipsis-direction']"));
//		int count=list.size();
//		System.out.println(count);
//		for(int i=0;i<list.size();i++)
//		{
//			String text=list.get(i).getText();
//			if(text.contains("5g back cover"))
//			{
//				list.get(i).click();
//				break;
//			}
//		}
		
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_N);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_SHIFT);
		r.keyRelease(KeyEvent.VK_N);
		
		
		
		
//	    driver.close();
	}

}
