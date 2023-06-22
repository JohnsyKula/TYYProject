package practise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cricbuzz {

	@Test
	public static void login()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cricbuzz.com/");
		driver.findElement(By.xpath("//span[@class='cb-ico cb-search-input-icon cb-search-input-icon-nav']")).click();
		driver.findElement(By.id("search_bar_menu")).sendKeys("sharma");
		driver.findElement(By.xpath("//a[text()='SEARCH']")).click();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//img[@src='/a/img/v1/50x50/i1/c153909/sandeep-sharma.jpg']/parent::div/following-sibling::div/a/span[text()='Sandeep Sharma']")).click();
	    String wicket = driver.findElement(By.xpath("//th[text()='Wkts']/ancestor::thead/following::tbody/tr[2]/td[6]")).getText();
	    System.out.println(wicket);
	    driver.close();
	}
}
