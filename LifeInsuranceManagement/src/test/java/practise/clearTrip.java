package practise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class clearTrip {
	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		/*driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[name()='svg']//*[local-name()='path' and @stroke='#1A1A1A']")).click();
		driver.findElement(By.xpath("(//button/child::div[1]/div/span)[2]")).click();
		driver.findElement(By.xpath("(//*[name()='svg']//*[local-name()='g' and @fill-rule='evenodd'])[2]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Where from?']")).click();
		driver.findElement((By.xpath("//p[contains(text(),'BLR')]"))).click();
		driver.findElement(By.xpath("//input[@placeholder='Where to?']")).click();
		driver.findElement((By.xpath("//p[contains(text(),'(GOI)')]"))).click();
		driver.findElement(By.xpath("(//button/child::div)[3]")).click();
		driver.findElement(By.xpath("((//div[@class='DayPicker-Month'])[1]/div/div[4]/../..//abbr[text()='S'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Search flights']")).click();*/
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://www.cleartrip.com/");
		//driver.findElement(By.xpath("//div[@class='px-1   flex flex-middle nmx-1 pb-1']")).click();
		//driver.findElement(By.xpath("//div[@class='px-1   flex flex-middle nmx-1 pb-1']")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"Where from?\"]")).sendKeys("BLR");
		driver.findElement(By.xpath("(//p[contains(.,'Bangalore')])[1]")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"Where to?\"]")).sendKeys("Goa");
		driver.findElement(By.xpath("//p[contains(.,'Goa, IN - Mopa Airport (GOX)')]/../../div[2]")).click();;
		driver.findElement(By.xpath("(//button[@class='flex flex-middle  t-all fs-2 focus:bc-secondary-500 bg-transparent bc-neutral-100 c-pointer pr-2 pl-3 pt-2 pb-2 ba br-4 h-8 c-neutral-900'])[1]")).click();
		driver.findElement(By.xpath("//div[@class='flex flex-middle p-relative homeCalender']/button[1]")).click();
		//driver.findElement(By.xpath("//div[@class='flex-1 ta-left']")).click();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='p-1 day-gridContent fs-14 fw-500 flex flex-middle flex-column flex-center flex-top' and contains(.,'14')])[2]"));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(.,'Search flights')]")).click();
		Thread.sleep(3000);
		List<WebElement> flights = driver.findElements(By.xpath("//div[@class='flex flex-column ms-grid-column-1 flex-center mt-4'] /div/div/div[3]/p[1]"));
		List<WebElement> timings = driver.findElements(By.xpath("//div[@class='ms-grid-column-1 flex flex-center ms-grid-row-1 flex-middle']/p"));
		int count=flights.size();
		System.out.println("Flights             Timings");
		for(int i=0;i<count;i++)
		{
			System.out.println(flights.get(i).getText()+"          "+timings.get(i).getText());
		}

			
			}


	}


