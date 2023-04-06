package practise;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IccWebTable {

	public static void main(String[] args) {
		WebDriver driver=WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		List<WebElement> element = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		ArrayList<String> al=new ArrayList<String>();
		for(WebElement name:element)
		{
			al.add(name.getText());
		}
       System.out.println("team"+"       "+"Rating");
       for(String teams:al)
       {
    	   String rating="//span[.='"+teams+"']/../..//td[5]";
    	   String rat=driver.findElement(By.xpath(rating)).getText();
    	   System.out.println(teams+"     "+rat);
       }
       driver.close();
	}

}
