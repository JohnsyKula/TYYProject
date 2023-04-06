package com.LIM.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientStatusPage {

	
	@FindBy(linkText="CLIENTS")
	private WebElement clientModule;
	
	public ClientStatusPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getClientModule() {
		return clientModule;
	}
	
	
	public void clickOnClient()
	{
		clientModule.click();
	}
	
	
	
}
