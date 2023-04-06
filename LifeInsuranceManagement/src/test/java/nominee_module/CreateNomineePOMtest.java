package nominee_module;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.LIM.pom.AddNomineePage;
import com.LIM.pom.HomePage;
import com.LIM.pom.NomineeInfoPage;
import com.genericUtilities.Baseclass;
@Listeners(com.genericUtilities.ListenerImplementation.class)
public class CreateNomineePOMtest extends Baseclass {

//	public static void main(String[] args) throws Throwable {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver= new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		//login
//		FileUtility flib=new FileUtility();
//		ExcelUtility elib=new ExcelUtility();
//		
//		String ul=flib.readDataFromPropertyFile("url");
//		driver.get(ul);
//		LoginPage l=new LoginPage(driver);
//		l.login(flib);
	
     //click nominee module
	// @Test(retryAnalyzer=com.genericUtilities.RetryImplementation.class)
	@Test
	 public void addNominee() throws Throwable
	 {
		HomePage h=new HomePage(driver);
		h.clickNomineeModule();
		
		NomineeInfoPage nif=new NomineeInfoPage(driver);
		nif.clickAddnomineebtn();
		
		AddNomineePage anp=new AddNomineePage(driver);
		anp.addNominee(driver,elib);
		System.out.println("Nominee is added");
	 }
		
		
//		driver.findElement(By.name("client_id")).sendKeys("1678779039");
//		driver.findElement(By.name("name")).sendKeys("Kitten");
//		driver.findElement(By.name("sex")).sendKeys("male");
//		driver.findElement(By.name("birth_date")).sendKeys("13.08.2021");
//		driver.findElement(By.name("nid")).sendKeys("1234567895432");
//		driver.findElement(By.name("relationship")).sendKeys("Daughter");
//		driver.findElement(By.name("priority")).sendKeys("High");
//		driver.findElement(By.name("phone")).sendKeys("3216541234");
		//WebDriverWait wait=new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		//driver.close();
	

}
