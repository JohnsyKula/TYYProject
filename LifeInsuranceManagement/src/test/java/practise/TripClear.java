package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TripClear {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com/");
		driver.findElement(By.xpath("//div[@style='border-radius: 14px;']//*[name()='svg']")).click();
		driver.findElement(By.xpath("//div[@class='p-relative']//button")).click();
        driver.findElement(By.xpath("//ul/li[@value='rt']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Adults, Economy')]")).click();
        
	}

}
