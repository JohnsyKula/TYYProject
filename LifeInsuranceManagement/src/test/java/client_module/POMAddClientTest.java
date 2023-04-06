package client_module;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.LIM.pom.AddClientPage;
import com.LIM.pom.ClientInfoPage;
import com.LIM.pom.HomePage;
import com.genericUtilities.Baseclass;
import com.genericUtilities.JavaUtility;

public class POMAddClientTest extends Baseclass {
//	public static void main(String[] args) throws Throwable {
	    //creating object for generic utilities
//		ExcelUtility elib=new ExcelUtility();
//		FileUtility flib=new FileUtility();
//		WebDriverUtility wlib=new WebDriverUtility();
//		JavaUtility jlib=new JavaUtility();
//		
//		WebDriverManager.chromedriver().create();
//		WebDriver driver=new ChromeDriver();
//		wlib.maximizeWindow(driver);
//		wlib.waitForImplicitly(driver);
//		
//		
//		//login to application using pom &read datafrom property file
//		
//		String ul=flib.readDataFromPropertyFile("url");
//		driver.get(ul);
//		LoginPage l=new LoginPage(driver);
//		l.login(flib);

	
	@Test(groups = "smoke")
	public void addClient() throws Throwable
	{
		JavaUtility jlib=new JavaUtility();
		HomePage h=new HomePage(driver);
		h.clickClientModule();
		ClientInfoPage c=new ClientInfoPage(driver);
		c.clickaddclientbtn();
		String clientID = driver.findElement(By.xpath("//input[@name='client_id']")).getAttribute("value");
		elib.writeDataIntoExcel("EditClient", 0, 0, clientID);
		System.out.println(clientID);
		Assert.fail();
		AddClientPage add=new AddClientPage(driver);
		add.addClient(driver, elib, jlib);
		
	}


}
