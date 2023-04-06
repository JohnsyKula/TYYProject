package com.LIM.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
    //declaration
	@FindBy(linkText="CLIENTS")
	private WebElement clientModule;
	
	@FindBy(linkText="AGENTS")
	private WebElement agentModule;
	
	@FindBy(linkText="POLICY")
	private WebElement policyModule;
	
	@FindBy(linkText="NOMINEE")
	private WebElement nomineeModule;
	
	@FindBy(linkText="PAYMENTS")
	private WebElement paymentsModule;
	
	@FindBy(xpath="//a[@class='btn btn-danger']")
	private WebElement logoutbtn;
	
	
	//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//utilization
	public void clickClientModule()
	{
		clientModule.click();
	}
	
	public void clickNomineeModule()
	{
		nomineeModule.click();
	}

	public void clickPaymentModule()
	{
		paymentsModule.click();
	}
	
	public void logout() throws InterruptedException
	{
		logoutbtn.click();
	}
	
}
