package com.genericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
    public void waitForImplicitly(WebDriver driver)
    {
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void waitForPageLoad(WebDriver driver)
    {
    	driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
    }
    public void elementToBeVisible(WebDriver driver,WebElement element)
    {
    	WebDriverWait wait=new WebDriverWait(driver,10);
    	wait.until(ExpectedConditions.visibilityOf(element));		
    }
    public void elementToBeClickable(WebDriver driver,WebElement element)
    {
    	WebDriverWait wait=new WebDriverWait(driver,10);
    	wait.until(ExpectedConditions.elementToBeClickable(element));		
    }
    public void select(WebElement element,String value)
    {
    	Select s=new Select(element);
    	s.selectByValue(value);
    }
    public void select(WebElement element,int index)
    {
    	Select s=new Select(element);
    	s.selectByIndex(index);
    }
    public void select(String text,WebElement element)
    {
    	Select s=new Select(element);
    	s.selectByVisibleText(text);
    }
    public void mousehover(WebDriver driver,WebElement element)
    {
    	Actions a=new Actions(driver);
    	a.moveToElement(element).perform();
    }
    
    public void dragAndDrop(WebDriver driver,WebElement src,WebElement dst)
    {
    	Actions a=new Actions(driver);
        a.dragAndDrop(src, dst);
    }
    
    public void doubleClickAction(WebDriver driver)
    {
    	Actions a=new Actions(driver);
        a.doubleClick().perform();
    }
    
    public void rightClick(WebDriver driver)
    {
    	Actions a=new Actions(driver);
        a.contextClick().perform();
    }
    public void enterKeyPress(WebDriver driver)
    {
    	Actions a=new Actions(driver);
    	a.sendKeys(Keys.ENTER).perform();
    }
    public void enterKey(WebDriver driver) throws AWTException
    {
    	Robot r=new Robot();
    	r.keyPress(KeyEvent.VK_ENTER);
    }
    public void enterRelease(WebDriver driver) throws AWTException
    {
    	Robot r=new Robot();
    	r.keyRelease(KeyEvent.VK_ENTER);
    }
    
    public void switchToFrame(WebDriver driver,int index)
    {
    	driver.switchTo().frame(index);
    }
    
    public void switchToFrame(WebDriver driver,String nameOrId)
    {
    	driver.switchTo().frame(nameOrId);
    }
    
    public void switchToFrame(WebDriver driver,WebElement address)
    {
    	driver.switchTo().frame(address);
    }
    
    public void acceptAlert(WebDriver driver)
    {
    	driver.switchTo().alert().accept();
    }
    
    public void cancelAlert(WebDriver driver)
    {
    	driver.switchTo().alert().dismiss();
    }
    
    public void switchToWindow(WebDriver driver,String partialTitle)
    {
    	//1.use get window handles to capture all window id's
    	Set<String> windows = driver.getWindowHandles();
    	
    	//2.iterate through the windows
    	Iterator<String> it = windows.iterator();
    	
        //3.check whether there is next window
    	while(it.hasNext())
    	{
    		//4.capture current window id
    		String winID=it.next();
    		
    		//5.switch to current window and capture title
    		String currentWinTitle=driver.switchTo().window(winID).getTitle();
    		
    		//6.check whether current window is expected
    		if(currentWinTitle.contains(partialTitle))
    		{
    			break;
    		}
    	}
    }
    
    public static String getScreenShot(WebDriver driver,String screenShotName) throws IOException
    {
    	TakesScreenshot ts=(TakesScreenshot)driver;
    	File src=ts.getScreenshotAs(OutputType.FILE);
    	String path=".\\screenshot\\"+screenShotName+".png";
    	File dst=new File(path);
    	FileUtils.copyFile(src, dst);
    	return path;
    	
    }
    
    public void scrollBarAction(WebDriver driver)
    {
    	JavascriptExecutor j=(JavascriptExecutor)driver;
    	j.executeScript("window.scrollBy(0,800)", "");
    }
    
    public void scrollAction(WebDriver driver,WebElement element)
    {
    	JavascriptExecutor j=(JavascriptExecutor)driver;
    	int y=element.getLocation().getY();
    	j.executeScript("window.scrollBy(0,"+y+")", element);
        //j.executeScript("argument[0].scrollIntoView()", element);
    }  
}
