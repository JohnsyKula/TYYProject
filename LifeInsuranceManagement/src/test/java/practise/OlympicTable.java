package practise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OlympicTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().create();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		String self="//h1[text()='Medal Table']";
		List<WebElement> country = driver.findElements(By.xpath(""+self+"/following::span[@data-cy='country-name']"));
		List<WebElement> gold = driver.findElements(By.xpath(""+self+"/following::div[@title='Gold']/span"));
		List<WebElement> silver = driver.findElements(By.xpath(""+self+"/following::div[@title='Silver']/span"));
		List<WebElement> bronze = driver.findElements(By.xpath(""+self+"/following::div[@title='Bronze']/span"));
		List<WebElement> total = driver.findElements(By.xpath(""+self+"/following::div[@title='Bronze']/span/following::div[1]"));
		
        int count=gold.size();
        System.out.println(count);
        for(int i=0;i<gold.size();i++)
        {
        System.out.println(country.get(i).getText()+" "+gold.get(i).getText()+"    "+silver.get(i).getText()+"   "+bronze.get(i).getText()+total.get(i).getText());
        }
        driver.close();
	}

}
