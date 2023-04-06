package client_module;
import org.testng.annotations.Test;

import com.LIM.pom.HomePage;
import com.LIM.pom.UpdateDeleteClientPage;
import com.genericUtilities.Baseclass;

public class POMDeleteClientTest extends Baseclass {

//	public static void main(String[] args) throws Throwable {
//		FileUtility flib=new FileUtility();
//		WebDriverUtility wlib=new WebDriverUtility();
//		
//		//Login to the application
//		WebDriverManager.chromedriver().create();
//		WebDriver driver=new ChromeDriver();
//		wlib.maximizeWindow(driver);
//		wlib.waitForImplicitly(driver);
//		
//		String ul=flib.readDataFromPropertyFile("url");		
//		driver.get(ul);
//		LoginPage l=new LoginPage(driver);
//		l.login(flib);
	
      @Test(groups = "smoke")
      public void deleteClient() throws InterruptedException
      {
		HomePage h=new HomePage(driver);
		h.clickClientModule();
	    UpdateDeleteClientPage udc=new UpdateDeleteClientPage(driver);
		udc.deleteClient(driver);
      }
	}


