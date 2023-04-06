package com.LIM.pom;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtilities.ExcelUtility;

public class AddNomineePage {
		
	@FindBy(name="client_id")
	private WebElement clientid;
	
	@FindBy(name="name")
	private WebElement nomineename;
	
	@FindBy(name="sex")
	private WebElement sex;
	
	@FindBy(name="birth_date")
	private WebElement birthdate;
	
	@FindBy(name="nid")
	private WebElement nid;
	
	@FindBy(name="relationship")
	private WebElement relationship;
	
	@FindBy(name="priority")
	private WebElement priority;
	
	@FindBy(name="phone")
	private WebElement phone;
	
    @FindBy(xpath="//input[@type='submit']")
    private WebElement submitbtn;
    
	public AddNomineePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getClientid() {
		return clientid;
	}

	public WebElement getNomineename() {
		return nomineename;
	}

	public WebElement getSex() {
		return sex;
	}

	public WebElement getBirthdate() {
		return birthdate;
	}

	public WebElement getNid() {
		return nid;
	}

	public WebElement getRelationship() {
		return relationship;
	}

	public WebElement getPriority() {
		return priority;
	}

	public WebElement getPhone() {
		return phone;
	}

    public WebElement getSubmitbtn() {
		return submitbtn;
	}
	
	public void addNominee(WebDriver driver,ExcelUtility elib) throws IOException, Throwable
	{
		HashMap<String, String> map = elib.readMultipleData("Nominee");
		for(Entry<String, String> i:map.entrySet())
		{
		   driver.findElement(By.name(i.getKey())).sendKeys(i.getValue());	
		}
		submitbtn.click();
	}

}
