package nominee_module;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNomineeTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().create();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver/domain/Life_Insurance_Management_System/");
		driver.findElement(By.name("username")).sendKeys("555");
		driver.findElement(By.name("password")).sendKeys("666");
		driver.findElement(By.xpath("//button[text()='login']")).click();
		driver.findElement(By.linkText("NOMINEE")).click();
		driver.findElement(By.linkText("Add Nominee")).click();
		driver.findElement(By.name("client_id")).sendKeys("1678779039");
		driver.findElement(By.name("name")).sendKeys("Kitten");
		driver.findElement(By.name("sex")).sendKeys("male");
		driver.findElement(By.name("birth_date")).sendKeys("13.08.2021");
		driver.findElement(By.name("nid")).sendKeys("1234567895432");
		driver.findElement(By.name("relationship")).sendKeys("Daughter");
		driver.findElement(By.name("priority")).sendKeys("High");
		driver.findElement(By.name("phone")).sendKeys("3216541234");
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.close();
	}

}
