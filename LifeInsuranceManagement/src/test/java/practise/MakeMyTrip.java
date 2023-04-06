package practise;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author johns
 *
 */
public class MakeMyTrip {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.makemytrip.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
	driver.findElement(By.id("fromCity")).click();
	driver.findElement(By.xpath("//p[text()='Bengaluru, India']")).click();
	driver.findElement(By.id("toCity")).click();
	driver.findElement(By.xpath("//p[text()='Chennai, India']")).click();
	
	//fetching system date and pass as a current travel date
	Date cdate=new Date();
	System.out.println(cdate);
	String[] d = cdate.toString().split(" ");
	String day=d[0];
	String month=d[1];
	String date=d[2];
	String year=d[5];
    String dptDate=day+" "+month+" "+date+" "+year;
    driver.findElement(By.xpath("//div[@aria-label='"+dptDate+"']")).click();
    while(true)
    {
    	String txt = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[1]/div")).getText();
        if(txt.equals("May2023"))
          break;
        else
        	driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
    }
    String expdate = "11";
	List<WebElement> dates = driver.findElements(By.xpath("(//div[@class='DayPicker-Body'])[1]/../div[3]//p"));
    for(WebElement i:dates)
    {
    	String actdate = i.getText();
    	if(expdate.equals(actdate))
    	{
    		i.click();
    	    break;
    	}
    }
    driver.findElement(By.xpath("//div[@data-cy='flightTraveller']")).click();
    driver.findElement(By.xpath("//p[@data-cy='adultRange']/following::ul[1]/li[2]")).click();
    driver.findElement(By.xpath("//p[@data-cy='adultRange']/following::ul[2]/li[2]")).click();
    driver.findElement(By.xpath("//p[@data-cy='adultRange']/following::ul[3]/li[2]")).click();
    driver.findElement(By.xpath("//button[@data-cy='travellerApplyBtn']")).click();
    driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']")).click();
    Thread.sleep(3000);
    driver.close();
	}

}
