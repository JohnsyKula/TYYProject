package com.LIM.pom;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateDeleteClientPage {
	
	@FindBy(name="client_password")
	private WebElement clientpw;
	
	@FindBy(name="name")
	private WebElement clientname;
	
	@FindBy(name="fileToUpload")
	private WebElement fileupload;
	
	@FindBy(name="sex")
	private WebElement sex;
	
	@FindBy(name="birth_date")
	private WebElement dateofbirth;
	
	@FindBy(name="maritial_status")
	private WebElement maritialstatus;
	
	@FindBy(name="nid")
	private WebElement nationalid;
	
	@FindBy(name="phone")
	private WebElement phoneno;
	
	@FindBy(name="address")
	private WebElement clientaddress;
	
	@FindBy(name="policy_id")
	private WebElement policyid;
	
	@FindBy(xpath="//input[@value='UPDATE']")
	private WebElement updateButton;
	
	@FindBy(linkText="Delete Client")
	private WebElement deleteClientlink;
	
	public UpdateDeleteClientPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
    
	public void deleteClientlink()
	{
		deleteClientlink.click();
	}
	

	public String editClient(WebDriver driver,String id,String name) {
		driver.findElement(By.xpath("//td[text()='"+id+"']/../td[8]/a[text()='Edit']")).click();
		clientname.clear();
		clientname.sendKeys(name);
		//WebDriverWait wait=new WebDriverWait(driver,20);
		//wait.until(ExpectedConditions.elementToBeClickable(By.name("submit")));
		//wlib.elementToBeClickable(driver, updateButton);
		updateButton.click();
		return id;
	}
	public void validateEditedClient(WebDriver driver,String id,String name)
	{
		driver.findElement(By.xpath("//td[text()='"+id+"']/../td[7]/a[text()='Client Status']")).click();
	    String text=clientname.getAttribute("value");
	    System.out.println(text);
	    if(text.equals(name))
	      System.out.println("Client information is updated successfully");
	    else
	    	System.out.println("Client information is not updated");
	}
	public void deleteClient(WebDriver driver) throws InterruptedException
	{
		int count=20;
	
	   for(int i=20;i<=count;i++)
	    {
		    List<WebElement> clientid = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		    count=clientid.size();
		    String id = clientid.get(i).getText();
	        System.out.println(id);
	        driver.findElement(By.xpath("//td[text()='"+id+"']/../td[8]/a[text()='Edit']")).click();
	  
	        deleteClientlink();
	        //validation
		    HomePage h=new HomePage(driver);
		    h.clickClientModule();
			List<WebElement> clientID = driver.findElements(By.xpath("//tbody/tr/td[1]"));
			int count1 = clientID.size();
			int flag=0;
			for(int j=0;j<count1;j++)
			{
				String text = clientID.get(j).getText();
				if(text.equals(id))
					flag++;
			}
			if(flag==0)
				System.out.println("Client is deleted successfully");
			else
				System.out.println("Client is not deleted");
		    break;
	    }
			/*After deleting validating in nominee information page
		    HomePage h=new HomePage(driver);
			h.clickNomineeModule();
			List<WebElement> clientID = driver.findElements(By.xpath("//tbody/tr/td[1]"));
			int count = clientID.size();
			int flag=0;
			for(int j=0;j<count;j++)
			{
				String text = clientID.get(j).getText();
				if(text.equals(id))
					flag++;
			}
			if(flag==0)
				System.out.println("Client is deleted successfully");
			else
				System.out.println("Client is not deleted");*/
	
	}

}
