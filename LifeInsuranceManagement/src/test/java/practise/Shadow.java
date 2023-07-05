package practise;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Shadow {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("chrome://downloads/");
		driver.manage().window().maximize();
		//JavascriptExecutor j=(JavascriptExecutor)driver;
		WebElement search = (WebElement)((JavascriptExecutor)driver).executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('downloads-toolbar').shadowRoot.querySelector('cr-toolbar').shadowRoot.querySelector('cr-toolbar-search-field').shadowRoot.querySelector('input')");
	    search.sendKeys("Offer Letter");
	}

}
