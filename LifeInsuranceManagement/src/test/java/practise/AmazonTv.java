package practise;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


//Open the browser
//Enter the url(amazon)
//search tv click search button
//scroll bar and select readmi 108 cm tv & click
//it opens the new tab swith between the window
//print the product name & prize
public class AmazonTv {

	@Test
	
	public static void tv() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Tv");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
	    Thread.sleep(1000);
		int y = driver.findElement(By.xpath("//span[contains(text(),'Redmi 108 cm (43 inches)')]")).getLocation().getY();
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollTo(0,"+y+")");
		driver.findElement(By.xpath("//span[contains(text(),'Redmi 108 cm (43 inches)')]")).click();
		Set<String> allwh = driver.getWindowHandles();
		for(String i:allwh)
		{
		    driver.switchTo().window(i);
		}
		String text = driver.findElement(By.id("productTitle")).getText();
		System.out.println(text);
		//String prize=driver.findElement(By.xpath("//span[@id='productTitle']/../../../../div[10]//span[@aria-hidden='true']/span[2]")).getText();
		String prize=driver.findElement(By.xpath("//span[contains(text(),'Redmi 108 cm')]//ancestor::div[@id='centerCol']//descendant::span[@class='a-price-whole']")).getText();
        System.out.println(prize);
        driver.quit();
	}

}
