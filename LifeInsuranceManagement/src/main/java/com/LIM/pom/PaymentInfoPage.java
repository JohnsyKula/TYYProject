package com.LIM.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentInfoPage {
	@FindBy(linkText="Add Payment")
	private WebElement addpaymentbtn;
	
	public PaymentInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickAddPaybtn()
	{
		addpaymentbtn.click();
	}

}
