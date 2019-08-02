package mobiotics.lco.Report_EKYCReportPage;


import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generic.DateHelper2;
import mobiotics.lco.commonPage.BasePage;
import mobiotics.lco.utilities.DemoExcelLibrary3;

public class Report_EKYCReportPage extends BasePage{
	
	private String path = "./ExcelPages/TestData.xlsx";
	private DateHelper2 dh  = new DateHelper2();
	static final Logger logger = Logger.getLogger(Report_EKYCReportPage.class);
	//Live--private String fromDateXp1 = "/html/body/div[4]/div[1]/div[2]/div/div[1]/div[2]/table/tbody/tr[";
	private String fromDateXp1 = "/html/body/div[5]/div[1]/div[2]/div/div[1]/div[2]/table/tbody/tr[";
	private String fromDateXp2 = "]/td[";
	
	
	public Report_EKYCReportPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(tagName = "h2")
	private WebElement pageTitle;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-calendar'])[1]")
	private WebElement fromDateCal;
	
	@FindBy(xpath = "(//th[@class='month']/span)[1]")
	private WebElement monthFrom;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-left'])[1]")
	private WebElement priviousMonthClickFrom;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-right'])[1]")
	private WebElement nextMonthClickFrom;
	
	@FindBy(id = "refresh")
	private WebElement goBtnCal;
	
	@FindBy(xpath = "//input[@placeholder='Search By Customer Number']")
	private WebElement customerIdTxtField;
	
	@FindBy(xpath = "//input[@placeholder='Search By Customer Number']/following-sibling::button")
	private WebElement goBtnCustomerId;
	
	@FindBy(xpath = "(//table[@class='table table-striped']/tbody/tr/td[2])[1]")
	private WebElement customerIdDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/thead")
	private WebElement recordHeader;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]")
	private WebElement firstRecord;
	
	@FindBy(linkText = "Id Proof")
	private WebElement idProofLink;
	
	@FindBy(linkText = "Address Proof")
	private WebElement addressProofLink;
	
	@FindBy(xpath = "//button[text()='Ekyc report Download']")
	private WebElement downloadButton;
	
	public void selectDates(String fromDate)
	{
		fromDateCal.click();
		String fromDateArr[] = fromDate.split("-");
		dh.selectMonth(priviousMonthClickFrom, nextMonthClickFrom, monthFrom.getText(), Integer.parseInt(fromDateArr[1]));
		dh.selectDate(fromDateXp1, fromDateXp2, Integer.parseInt(fromDateArr[0]));
		goBtnCal.click();
	}
	
	public void enterCustomerNo(String customerNo) throws InterruptedException
	{
		customerIdTxtField.sendKeys(customerNo);
		//Write code for elemient isClickable()
		Thread.sleep(2000);
		goBtnCustomerId.click();
	}
	
	
	public void testEKYCReport() throws Exception
	{
		logger.info("Page Title - "+pageTitle.getText());
		Assert.assertEquals(pageTitle.getText(), "Ekyc Report");
		String fromDate = "01-04-2019";
		selectDates(fromDate);
		Thread.sleep(5000);
		try {
			if(firstRecord.getText().contains("No reports"))
			{
				logger.info(firstRecord.getText());
				return;
			}
		} catch (Exception e) {
			
		}
		
		String customerNo = DemoExcelLibrary3.getexcelData("can.stb.smc", 1, 19, path);
		enterCustomerNo(customerNo);
		Thread.sleep(4000);
		try {
			if(firstRecord.getText().contains("No reports"))
			{
				logger.info(firstRecord.getText());
				return;
			}
		} catch (Exception e) {
			
		}
		
		logger.info("Entered information: ");
		logger.info("From Date: "+fromDate);
		logger.info("Customer ID: "+customerNo);
		
		
		logger.info(recordHeader.getText());
		logger.info(firstRecord.getText());
		Assert.assertEquals(customerIdDisplaying.getText(), customerNo);
		
		String parentWindowId = driver.getWindowHandle();
		idProofLink.click();
		//Write code for screenshot
		driver.switchTo().window(parentWindowId);
		
		addressProofLink.click();
		//Write code for screenshot
		driver.switchTo().window(parentWindowId);
		
		downloadButton.click();
		Runtime run = Runtime.getRuntime();
		run.exec(System.getProperty("user.dir")+"\\Drivers\\saveReport.exe");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
