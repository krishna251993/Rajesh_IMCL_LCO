package mobiotics.lco.ExpiryReport_Page;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import mobiotics.lco.commonPage.BasePage;

public class ExpiryReportPage extends BasePage {
	

	
	public ExpiryReportPage(){
		
		PageFactory.initElements(driver, this);
	}
	
	static final Logger logger = Logger.getLogger(ExpiryReportPage.class);
	
	@FindBy(xpath = "//h1[text()='Expiry Report']")
	private WebElement pageTitle;
	
	@FindBy(xpath = "//select[@name='expiry']")
	private WebElement selectDaysList;
	
	@FindBy(xpath = "//td[text()='No expiry data.']")
	private WebElement noExpiryDataMsg;
	
	@FindBy(xpath = "(//tbody/tr/td[last()-1])[1]")
	private WebElement planStartDate;
	
	@FindBy(xpath = "(//tbody/tr/td[last()])[1]")
	private WebElement planExpiryDate;
	
	@FindBy(xpath = "//button[text()='Expiry Report Download']")
	private WebElement downloadButton;
	
	public String getPageTitle()
	{
		return pageTitle.getText();
	}
	
	public void selectDays()
	{
		Select selectList = new Select(selectDaysList);
		selectList.selectByIndex(2);
	}
	
	
	public void testExpiryReport() throws Exception
	{
		Assert.assertEquals(getPageTitle(), "Expiry Report");
		selectDays();
		
		Thread.sleep(2000);
		try {
			if(noExpiryDataMsg.isDisplayed())
				logger.info(noExpiryDataMsg.getText());
				Assert.assertEquals(noExpiryDataMsg.getText(), "No expiry data.");
				
			
			return;
		}
		catch (Exception e) {
		}
		
		//logger.info("Plan start date: "+planStartDate.getText());
		logger.info("Plan End date: "+planExpiryDate.getText());
		
		downloadButton.click();
		Runtime run = Runtime.getRuntime();
		run.exec(System.getProperty("user.dir")+"\\Drivers\\saveReport.exe");
		
	}
	
	
	
	
	

}
