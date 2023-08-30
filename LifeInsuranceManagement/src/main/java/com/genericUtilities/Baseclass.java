package com.genericUtilities;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.LIM.pom.HomePage;
import com.LIM.pom.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public DatabaseUtility dlib=new DatabaseUtility();
	public ExcelUtility elib=new ExcelUtility();
	public FileUtility flib=new FileUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	
	
	@BeforeSuite(alwaysRun = true)
	public void configBS() throws Throwable
	{
		dlib.connectToDB();
		System.out.println("---Connect to Database---");
	}
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	//public void configBC(String BROWSER)
	public void configBC() throws Throwable
	{
		String BROWSER=flib.readDataFromPropertyFile("browser");
		String URL=flib.readDataFromPropertyFile("url");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase(BROWSER))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("Invalid browser");
		}
		sdriver=driver;
		driver.get(URL);
		wlib.maximizeWindow(driver);
		wlib.waitForImplicitly(driver);
		
	}
	@BeforeMethod(alwaysRun = true)
	
	public void configBM() throws Throwable
	{
		LoginPage l=new LoginPage(driver);
		l.login(flib);
	}
	@AfterMethod(alwaysRun = true)
	public void configAM() throws InterruptedException
	{
	HomePage h=new HomePage(driver);
	Thread.sleep(1000);
	h.logout();
		
	}
	@AfterClass(alwaysRun = true)
	public void configAC()
	{
		driver.quit();
	}
	@AfterSuite(alwaysRun = true)
	public void configAS() throws SQLException
	{
		dlib.closeDB();
	}
}
