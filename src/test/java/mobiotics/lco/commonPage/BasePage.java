	package mobiotics.lco.commonPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;




import generic.Property;
import mobiotics.lco.constatnts.AutomationConstants;
import mobiotics.lco.constatnts.BaseTest;

public class BasePage {
	
	//log=log.getLogger("LOC_ Logger");
	//PropertyConfigurator.configure("Log4j.properties");
	//public Logger log=log.getLogger("LOC_ Logger");
	//PropertyConfigurator.configure("Log4j.properties");
	public Logger log=Logger.getLogger(this.getClass());
	public WebDriver driver;
	public String configFile;
	public long timeout;
	
	
	public BasePage() {
		this.driver=BaseTest.driver;
		configFile=AutomationConstants.CONFIG_PATH+AutomationConstants.CONFIG_FILE;
		timeout=Long.parseLong(Property.getPropertyValue(configFile, "EXPLICIT"));
		
	}
	
	public  void waitTillElementIsVisible(WebElement element)
	{
		
		 new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitTillElementIsClickable(WebElement element)
	{
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void verifyURLis(String expectedUrl)
	{
		new WebDriverWait(driver, timeout).until(ExpectedConditions.urlToBe(expectedUrl));
		
	}
	 public boolean verifyURLhas(String expectedURL) {
		 return new WebDriverWait(driver, timeout).until(ExpectedConditions.urlContains(expectedURL));
		 
	 }
	 
	 public void moveToElement(WebElement element) {
		 Actions actions=new Actions(driver);
		 actions.moveToElement(element).perform();
	 }
	 
	 public void runRandomXpath(String xp1,int num,String xp2) {
			driver.findElement(By.xpath(xp1+num+xp2)).click();
		}
	 
	 public int getNumberOfCheckBoxes(List<WebElement> checkBoxes) {
		 return checkBoxes.size();
	 }
	
}
