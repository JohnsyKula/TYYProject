package practise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartScenario {
	public static void main(String[] args) throws InterruptedException {

	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.flipkart.com/");
	  driver.findElement(By.xpath("//button[text()='✕']")).click();
	  driver.findElement(By.name("q")).sendKeys("iphone");
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
      Thread.sleep(5000);
	  List<WebElement> list = driver.findElements(By.xpath("//div[@class='lrtEPN _17d0yO']"));
	  
	  int len = list.size();
	  System.out.println(len);
	  for(int i=0;i<len;i++)
	  {
		  String text = list.get(i).getText();
		  System.out.println(text);
		  if(text.contains("iphone 14 pro"))
		  {
			 list.get(i).click();
			  break;
		  }
	  }
	  int total=0;
	  for(; ;)
	  {
		  Thread.sleep(5000);
		  List<WebElement> pagelist = driver.findElements(By.xpath("//div[@class='_2kHMtA']"));
		  int pagetot=pagelist.size();
		  total=total+pagetot;
		  
	  try {
		  driver.findElement(By.xpath("//span[text()='Next']")).click();
	  }
	  
      catch(Exception e)
	  {
    	  System.out.println(total);
    	  break;
	  }
	  }
	  String text = driver.findElement(By.xpath("//span[contains(.,'results for')]")).getText();
	  System.out.println(text);
	  if(total==56)
		  System.out.println("Success");
	  else
		  System.out.println("Not success");
	}

}
