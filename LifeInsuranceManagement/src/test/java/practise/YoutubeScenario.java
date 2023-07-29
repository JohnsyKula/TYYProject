package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class YoutubeScenario {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.youtube.com/watch?v=6RaDZhfXHI8&ab_channel=NaveenAutomationLabs");
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//	driver.findElement(By.name("search_query")).sendKeys("Appium course");
//	driver.findElement(By.id("search-icon-legacy")).click();
//	driver.findElement(By.xpath("//span[contains(text(),'Appium for Beginners')]")).click();
	
	driver.findElement(By.xpath("//button[@aria-label='Play keyboard shortcut k']//*[name()='svg']/*[local-name()='use']")).click();
}
}
