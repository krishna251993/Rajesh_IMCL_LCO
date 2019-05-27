package mobiotics.lco.Subscribers_CustomerSelection;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import mobiotics.lco.commonPage.BasePage;
import mobiotics.lco.subscriber_Tickets.Subscriber_TicketsPage;
import mobiotics.lco.utilities.DemoExcelLibrary3;

public class Subscribers_CustomerSelectionPage extends BasePage{
	
	private String path = "./ExcelPages/TestData.xlsx";
	public Subscribers_CustomerSelectionPage()
	{
		PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(Subscribers_CustomerSelectionPage.class);
	
	@FindBy(id = "customeridsearch")
	private WebElement customerIDTxtFld;
	
	@FindBy(xpath = "//button[text()='Download Report']")
	private WebElement downloadReportBtn;
	
	@FindBy(xpath = "//select[@class='form-control lang']")
	private WebElement selectLang;
	
	@FindBy(xpath = "//tbody[@class='baseplan']//input[1]")
	private WebElement selectBasePlan;
	
	@FindBy(xpath = "//input[@type='file']")
	private WebElement uploadFileFld;
	
	@FindBy(id = "upload")
	private WebElement uploadBtn;
	
	@FindBy(xpath = "//label[text()='Upload success']")
	private WebElement uploadSuccessMsg;
	
	@FindBy(xpath = "//button[text()='SUBMIT']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//p[@class='error text-danger']")
	private WebElement errMsg;
	
	@FindBy(xpath = "//p[@class='success text-danger']")
	private WebElement successMsg;
	
	public void testCustomerSelection() throws InterruptedException, IOException
	{
		String customerId = DemoExcelLibrary3.getexcelData("can.stb.smc", 1, 15, path);
		customerIDTxtFld.sendKeys(customerId);
		downloadReportBtn.click();
		Runtime run = Runtime.getRuntime();
		run.exec(System.getProperty("user.dir")+"/Drivers/saveReport.exe");
		
		Thread.sleep(2000);
		Select languageList = new Select(selectLang);
		languageList.selectByVisibleText("HINDI");
		try
		{
			selectBasePlan.click();
		}
		catch (Exception e) {
			
			logger.info("Base Plan is not getting displayed");
		}
		uploadFileFld.sendKeys(System.getProperty("user.dir")+"/ExcelPages/Customer_Order_Report.csv");
		uploadBtn.click();
		Thread.sleep(1000);
		Assert.assertEquals(uploadSuccessMsg.isDisplayed(), true, "File is not uploaded successfully");
		logger.info(uploadSuccessMsg.getText()+" for customer order file");
		submitBtn.click();
		Thread.sleep(2000);
		if(!(successMsg.getText().equals("")))
		{
			logger.info(successMsg.getText());
		}
		else
		{
			logger.info(errMsg.getText());
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
