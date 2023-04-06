package com.LIM.pom;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.genericUtilities.ExcelUtility;
import com.genericUtilities.JavaUtility;

public class AddClientPage {
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
	
	@FindBy(name="nominee_name")
	private WebElement nomineename;
	
	@FindBy(name="nominee_sex")
	private WebElement nomineesex;
	
	@FindBy(name="nominee_birth_date")
	private WebElement nomineebirthdate;
	
	@FindBy(name="nominee_relationship")
	private WebElement nomineerelationship;
	
	@FindBy(name="priority")
	private WebElement priority;
	
	@FindBy(name="nominee_phone")
	private WebElement nomineephone;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitbtn;
	
	@FindBy(xpath = "//input[@name='client_id']")
	private WebElement cid;
	
	
	
	public AddClientPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void addClient(WebDriver driver,ExcelUtility elib,JavaUtility jlib) throws IOException, Throwable
	{
		HashMap<String, String> map = elib.readMultipleData("Client");
		int randomno = jlib.random();
		for(Entry<String, String> i:map.entrySet())
		{
			if(i.getKey().equals("name"))
			{
			   driver.findElement(By.name(i.getKey())).sendKeys(i.getValue()+randomno);
			}
			else
			{
				driver.findElement(By.name(i.getKey())).sendKeys(i.getValue());
			}
			submitbtn.click();
		}
		String expectedResult="INSERT CLIENT";
		String actuvalResult = driver.findElement(By.xpath("//div/h1")).getText();
		Assert.assertEquals(expectedResult, actuvalResult,"Client is added successfully");
		   /*System.out.println("Client is added successfully");
		else
			System.out.println("Client is not added");*/
	
	
	}
}


