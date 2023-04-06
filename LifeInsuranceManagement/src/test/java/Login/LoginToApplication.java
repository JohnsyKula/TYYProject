package Login;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginToApplication {
	public static void main(String[] args) throws IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		FileInputStream fis=new FileInputStream("./src/test/resources/Commendata.properties");
		Properties p=new Properties();
	    p.load(fis);
	    String ul=p.getProperty("url");
	    String un=p.getProperty("username");
	    String pw=p.getProperty("password");
		driver.get(ul);
		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pw);
		driver.findElement(By.xpath("//button[text()='login']")).click();
		driver.close();
	}

}
