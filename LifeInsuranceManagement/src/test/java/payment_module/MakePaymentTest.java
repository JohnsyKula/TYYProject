package payment_module;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakePaymentTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().create();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver/domain/Life_Insurance_Management_System/");
		driver.findElement(By.name("username")).sendKeys("555");
		driver.findElement(By.name("password")).sendKeys("666");
		driver.findElement(By.xpath("//button[text()='login']")).click();
		driver.findElement(By.linkText("PAYMENTS")).click();
		driver.findElement(By.linkText("Add Payment")).click();
		driver.findElement(By.name("client_id")).sendKeys("1511988147");
		driver.findElement(By.name("month")).sendKeys("Jan");
		driver.findElement(By.name("amount")).sendKeys("1000");
		driver.findElement(By.name("due")).sendKeys("5");
		driver.findElement(By.name("fine")).sendKeys("200");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.close();
	}

}
