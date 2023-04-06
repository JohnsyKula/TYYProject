package com.LIM.pom;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.genericUtilities.ExcelUtility;

public class AddPaymentPage {
	@FindBy(name="client_id")
	private WebElement clientid;
	
	@FindBy(name="month")
	private WebElement monthtxt;
	
	@FindBy(name="amount")
	private WebElement amounttxt;
	
	@FindBy(name="due")
	private WebElement duetxt;
	
	@FindBy(name="fine")
	private WebElement finetxt;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitbtn; 
	
	public AddPaymentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void addPayment(WebDriver driver,ExcelUtility elib) throws Throwable
	{
		HashMap<String, String> map = elib.readMultipleData("Payment");
		for(Entry<String, String> i:map.entrySet())
		{
			driver.findElement(By.name(i.getKey())).sendKeys(i.getValue());
			submitbtn.click();
		}
		System.out.println("Payment is added is successfully");
	}
}
