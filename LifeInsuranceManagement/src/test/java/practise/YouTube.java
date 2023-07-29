package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class YouTube {
	
	@Test
	public static void openYouTube() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/");
	    driver.findElement(By.xpath("//input[@id='search' or @name='search_query' ]")).sendKeys("samsung s20");;
		//WebDriverWait wait=new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.visibilityOfAllElements(ele));
	    //driver.findElement(By.xpath("//input[@id='search' or @name='search_query' ]")).sendKeys(" ");
		driver.findElement(By.id("search-icon-legacy")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@id='video-title'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("((//div[@id='shorts-player']//video[@class='video-stream html5-main-video']/ancestor::ytd-player/following-sibling::div//button[@id='button'])[1]")).click();
		driver.close();

	   
	}

}
