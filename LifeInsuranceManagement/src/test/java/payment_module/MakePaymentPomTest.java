package payment_module;

import org.testng.annotations.Test;
import com.LIM.pom.AddPaymentPage;
import com.LIM.pom.HomePage;
import com.LIM.pom.PaymentInfoPage;
import com.genericUtilities.Baseclass;

public class MakePaymentPomTest extends Baseclass {

//	public static void main(String[] args) throws Throwable {
//		WebDriverManager.chromedriver().create();
//		WebDriver driver=new ChromeDriver();
//		WebDriverUtility wlib=new WebDriverUtility();
//		FileUtility flib=new FileUtility();
//		ExcelUtility elib=new ExcelUtility();
//		
////		driver.manage().window().maximize();
////		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		wlib.maximizeWindow(driver);
//		wlib.waitForImplicitly(driver);
//		
////		driver.get("http://rmgtestingserver/domain/Life_Insurance_Management_System/");
////		driver.findElement(By.name("username")).sendKeys("555");
////		driver.findElement(By.name("password")).sendKeys("666");
////		driver.findElement(By.xpath("//button[text()='login']")).click();
//		
//		String ul=flib.readDataFromPropertyFile("url");
//		driver.get(ul);
//		LoginPage l=new LoginPage(driver);
//		l.login(flib);
//		
////		driver.findElement(By.linkText("PAYMENTS")).click();
////		driver.findElement(By.linkText("Add Payment")).click();
////		driver.findElement(By.name("client_id")).sendKeys("1511988147");
////		driver.findElement(By.name("month")).sendKeys("Jan");
////		driver.findElement(By.name("amount")).sendKeys("1000");
////		driver.findElement(By.name("due")).sendKeys("5");
////		driver.findElement(By.name("fine")).sendKeys("200");
////		driver.findElement(By.xpath("//input[@type='submit']")).click();
//		
	
	@Test
	public void addPayment() throws Throwable
	{
		HomePage h=new HomePage(driver);
		h.clickPaymentModule();
		PaymentInfoPage p=new PaymentInfoPage(driver);
	    p.clickAddPaybtn();
	    AddPaymentPage app=new AddPaymentPage(driver);
	    app.addPayment(driver, elib);
	}

}
