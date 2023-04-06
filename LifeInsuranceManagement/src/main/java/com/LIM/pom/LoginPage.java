package com.LIM.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtilities.FileUtility;

public class LoginPage {
	
	//declaration
	@FindBy(name="username")
	private WebElement userName;
	
	@FindBy(name="password")
	private WebElement passWord;
	
	@FindBy(xpath="//button[text()='login']")
	private WebElement loginButton;
	
	//initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//utilization
	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return passWord;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	//business logic
	public void login(FileUtility flib) throws Throwable
	{
		
	    userName.sendKeys(flib.readDataFromPropertyFile("username"));	
	    passWord.sendKeys(flib.readDataFromPropertyFile("password"));
	    loginButton.click();
	    
	}

}
