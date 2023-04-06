package com.LIM.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NomineeInfoPage {
	
 @FindBy(xpath="//a[text()='Add Nominee']")
 private WebElement addnomineeBtn;
 
 @FindBy(linkText="Client Status")
 private WebElement clientstatuslink;
 
 public NomineeInfoPage(WebDriver driver)
 {
	 PageFactory.initElements(driver, this);
 }

public WebElement getAddnomineeBtn() {
	return addnomineeBtn;
}

public WebElement getClientstatuslink() {
	return clientstatuslink;
	
}
public void clickAddnomineebtn()
{
	addnomineeBtn.click();
}
public void afterDeleteValidateClientInNIP(WebDriver driver,String id)
{
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
		System.out.println("Client is not deleted");
}

}
