package practise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MockFlipkart {
	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("Samsungs20");
		//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        //driver.findElement(By.xpath("//a[@href='/search?q=samsungs20&sid=tyy%2C4io&as=on&as-show=on&otracker=AS_QueryStore_OrganicAutoSuggest_2_10_na_na_na&otracker1=AS_QueryStore_OrganicAutoSuggest_2_10_na_na_na&as-pos=2&as-type=RECENT&suggestionId=samsungs20%7CMobiles&requestId=7c628c13-e249-406c-81fb-8959e593bd6e&as-searchtext=samsungs20']")).click();
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	}

}
