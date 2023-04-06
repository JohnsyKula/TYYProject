package practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import com.mysql.cj.jdbc.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RmgYantraAutomation {

	public static void main(String[] args) throws IOException, InterruptedException, SQLException {
		Connection con=null;
		String expectedRes="LifeInsurance";
		ResultSet result=null;
		FileInputStream fis = new FileInputStream("./src/test/resources/RmgCommendata.properties");
		Properties p=new Properties();
		p.load(fis);
		String ul=p.getProperty("url");
		String un=p.getProperty("username");
		String pw=p.getProperty("password");
	
		
		//login to the application
		try {
		WebDriverManager.chromedriver().create();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(ul);
		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pw);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//creating project
	    driver.findElement(By.linkText("Projects")).click();
	    driver.findElement(By.xpath("//span[text()='Create Project']")).click();
	    driver.findElement(By.name("projectName")).sendKeys("LifeInsurance");
	    driver.findElement(By.name("createdBy")).sendKeys("Johnsy");
	    WebElement dropdown = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
	    Select s=new Select(dropdown);
	    s.selectByVisibleText("On Gogin");
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	    driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	    driver.close();
	    
	    //database connectivity
	    Driver driver1=new Driver();
	    DriverManager.registerDriver(driver1);
	    con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%","root");
	    Statement state = con.createStatement();
		String query="select* from project;";
	    result = state.executeQuery(query);
	    System.out.println(result);
	 
		boolean flag=false;
		while(result.next())
		{
		    String actuvalRes = result.getString(4);
		    System.out.println(actuvalRes);
		   if(actuvalRes.contains(expectedRes));
		    {
		    	flag=true;
		    	break;
                
		    }
		}
		    if(flag)
		    {
		    	System.out.println("Project is created successfully");
		    }
		    else
		    {
		    	System.out.println("project is not created");
		    }
		}
		catch(Exception e)
		{
			
		}
		finally {
		         con.close(); 
		}
		}
	}


