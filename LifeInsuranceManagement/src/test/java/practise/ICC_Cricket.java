package practise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ICC_Cricket {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().create();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		
		List<WebElement> country = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		List<WebElement> matches = driver.findElements(By.xpath("//tbody/tr/td[3]"));
		List<WebElement> points = driver.findElements(By.xpath("//tbody/tr/td[4]"));
		List<WebElement> ratings = driver.findElements(By.xpath("//tbody/tr/td[5]"));
		for(int i=0;i<country.size();i++)
		{
			System.out.println(country.get(i).getText()+" "+matches.get(i).getText()+" "+points.get(i).getText()+" "+ratings.get(i).getText());
		}
     driver.close();

	}

}
