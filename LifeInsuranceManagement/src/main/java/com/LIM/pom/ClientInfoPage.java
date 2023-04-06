package com.LIM.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientInfoPage {
	
	@FindBy(linkText="Add Client")
	private WebElement addClientButton;
	
	@FindBy(linkText="Client Status")
	private WebElement clientStatusLink;
	
	@FindBy(linkText="Edit")
	private WebElement editLink;
	
	
	
	
	public ClientInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickaddclientbtn()
	{
		addClientButton.click();
	}
	
	public void clientStatus()
	{
		clientStatusLink.click();
	}
	
	public void editLink()
	{
		editLink.click();
	}

}
