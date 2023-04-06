package client_module;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.LIM.pom.AddClientPage;
import com.LIM.pom.HomePage;
import com.LIM.pom.LoginPage;
import com.LIM.pom.UpdateDeleteClientPage;
import com.genericUtilities.Baseclass;
import com.genericUtilities.FileUtility;
import com.genericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class POMEditClientTest extends Baseclass {

//	public static void main(String[] args) throws Throwable {
//		FileUtility flib=new FileUtility();
//		WebDriverUtility wlib=new WebDriverUtility();
//			
//		//Login to the application
//		WebDriverManager.chromedriver().create();
//		WebDriver driver=new ChromeDriver();
//		wlib.maximizeWindow(driver);
//	    wlib.waitForImplicitly(driver);
//	    
//		String ul=flib.readDataFromPropertyFile("url");
//		LoginPage l=new LoginPage(driver);
//		driver.get(ul);
//	    l.login(flib);

//	    
	    //clicking particular client for edit operation	
		@Test(groups = {"smoke","regression"})
		public void editClient()
		{ 
	       HomePage h=new HomePage(driver);
           h.clickClientModule();
	       UpdateDeleteClientPage udcp=new UpdateDeleteClientPage(driver);
	       String id = udcp.editClient(driver,"1670561663","Bevin");
	       System.out.println(id);
	       wlib.waitForPageLoad(driver);

	    
		//After updating validating the client information in client status page
		   h.clickClientModule();
		   AddClientPage acp = new AddClientPage(driver);
		   udcp.validateEditedClient(driver, id, "Bevin");	
	    }

}
