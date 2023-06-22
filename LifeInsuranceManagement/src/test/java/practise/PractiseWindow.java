package practise;

import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PractiseWindow {
	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://secure.indeed.com/");
		driver.findElement(By.id("apple-signin-button")).click();
		driver.findElement(By.id("login-facebook-button")).click();
		Set<String> allwh = driver.getWindowHandles();
		String pid=driver.getWindowHandle();
		Set<String> all=driver.getWindowHandles();
		for(String each:all)
		  {
		    driver.switchTo().window(each);
		    if(!pid.equals(each))
		      {
		         System.out.println(driver.getTitle());
		         break;
		      }
		   }
		driver.quit();
	}

}
