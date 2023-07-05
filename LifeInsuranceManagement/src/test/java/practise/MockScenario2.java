package practise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MockScenario2 {
	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 14 pro max");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		List<WebElement> color = driver.findElements(By.xpath("//span[text()='Apple iPhone 14 (128 GB) - Midnight']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='s-color-swatch-inner-circle-fill']"));
	}

}
