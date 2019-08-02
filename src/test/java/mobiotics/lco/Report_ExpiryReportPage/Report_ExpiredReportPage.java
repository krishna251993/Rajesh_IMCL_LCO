package mobiotics.lco.Report_ExpiryReportPage;


import java.awt.Robot;
import java.awt.event.KeyEvent;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import mobiotics.lco.commonPage.BasePage;


public class Report_ExpiredReportPage extends BasePage{
	
	
	
	public Report_ExpiredReportPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	static final Logger logger = Logger.getLogger(Report_ExpiredReportPage.class);
	
	@FindBy(xpath = "//h1[text()='Expired Report']")
	private WebElement pageTitle;
	
	@FindBy(xpath = "//select[@name='expiry']")
	private WebElement selectExpiredOn;

	
	@FindBy(xpath = "//td[text()='No expired data.']")
	private WebElement noExpiryDataMsg;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()]")
	private WebElement expiredDateTxt;
	
	@FindBy(xpath = "//button[text()='Expired Report Download']")
	private WebElement downloadButton;
	
	public void selectExpiredDate()
	{
		Select selectlist = new Select(selectExpiredOn);
		selectlist.selectByIndex(2);
		
	}
	
	
	
	public void testExpiredReport() throws Exception
	{
		Assert.assertEquals(pageTitle.getText(), "Expired Report");
		selectExpiredDate();
		Thread.sleep(2000);
		try {
			if(noExpiryDataMsg.isDisplayed())
			{
				logger.info(noExpiryDataMsg.getText());
				Assert.assertEquals(noExpiryDataMsg.getText(), "No expired data.");
				return;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		logger.info("Plan Expired On: "+expiredDateTxt.getText());
		downloadButton.click();
		Runtime run = Runtime.getRuntime();
		run.exec(System.getProperty("user.dir")+"\\Drivers\\saveReport.exe");
		
		
	}
	
	
	
	
	

}
