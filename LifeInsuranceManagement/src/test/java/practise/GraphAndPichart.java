package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import freemarker.core.JavaScriptOutputFormat;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GraphAndPichart {
	@Test
	public static void GraphGetText() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://emicalculator.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,600)");
		Actions a=new Actions(driver);
	    WebElement ele = driver.findElement(By.xpath("(//*[name()='svg']//*[local-name()='tspan' and @style='font-weight:bold'])[1]"));
	    a.moveToElement(ele).perform();
	    String text = driver.findElement(By.xpath("//*[name()='tspan' and contains(text(),'Principal Loan Amount:')]")).getText();
        System.out.println(text);
        j.executeScript("window.scrollBy(0,400)");
        Thread.sleep(2000);
        WebElement ele1=driver.findElement(By.xpath("(//*[name()='path'  and @fill='#B8204C'])[2]"));
        a.moveToElement(ele1).perform();
        String text1=driver.findElement(By.xpath("//*[name()='g' and @class='highcharts-label highcharts-tooltip highcharts-color-undefined']//*[name()='text']")).getText();
        System.out.println(text1);
        driver.close();
	}

}
