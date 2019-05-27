package mobiotics.lco.Report_RefundReport;

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

public class Report_RefundReportPage extends BasePage{
	
	private String path = "./ExcelPages/TestData.xlsx";
	//Live----private String dateXp1 = "/html/body/div[4]/div[2]/div[2]/div/div[1]/div[2]/table/tbody/tr[";
	private String dateXp1 = "/html/body/div[5]/div[2]/div[2]/div/div[1]/div[2]/table/tbody/tr[";
	private String dateXp2 = "]/td[";
	private DateHelper2 dh = new DateHelper2();
	
	public Report_RefundReportPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	static final Logger logger = Logger.getLogger(Report_RefundReportPage.class);
	
	@FindBy(tagName = "h1")
	private WebElement pageTitle;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-calendar'])[1]")
	private WebElement fromDateCal;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-left'])[1]")
	private WebElement priviousMonthFromCal;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-right'])[1]")
	private WebElement nxtMnthClkFrmCal;
	
	@FindBy(xpath = "(//th[@class='month']/span)[1]")
	private WebElement monthFromDate;
	
	@FindBy(id="refresh")
	private WebElement goBtnCal;
	
	@FindBy(xpath = "//input[@name='paymentid']")
	private WebElement paymentIdTxtField;
	
	@FindBy(xpath = "(//button[@class='btn btn-default'])[1]")
	private WebElement goBtnForpaymentId;
	
	@FindBy(xpath = "//button[text()='Refund Download']")
	private WebElement refundDownloadBtn;
	
	@FindBy(xpath = "//td[text()='No Refund.']")
	private WebElement noRefundMsg;
	
	@FindBy(xpath = "//button[text()='Refund Download'")
	private WebElement downloadButton;
	
	
	public void selectDates()
	{
		fromDateCal.click();
		String fromDate = "2019/04/01";
		String fromDateArr[] = fromDate.split("/");
		dh.selectMonth(priviousMonthFromCal, nxtMnthClkFrmCal, monthFromDate.getText(), Integer.parseInt(fromDateArr[1]));
		dh.selectDate(dateXp1, dateXp2, Integer.parseInt(fromDateArr[2]));
		goBtnCal.click();
	}
	
	public void searchByPaymentId()
	{
		String paymentId = DemoExcelLibrary3.getexcelData("can.stb.smc", 1, 17, path);
		paymentIdTxtField.sendKeys(paymentId);
		goBtnForpaymentId.click();
	}
	
	public void downloadReport() throws Exception
	{
		if(downloadButton.isEnabled())
		{
			downloadButton.click();
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_LEFT);
			Thread.sleep(500);
			r.keyRelease(KeyEvent.VK_LEFT);
			r.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(500);
			r.keyRelease(KeyEvent.VK_ENTER);
		}
		
	}
	
	public void testRefundReport() throws Exception
	{
		selectDates();
		Thread.sleep(5000);
		try {
			if(noRefundMsg.isDisplayed())
			{
				logger.info(noRefundMsg.getText());
				Assert.assertEquals(noRefundMsg.getText(), "No Refund.");
				return;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		searchByPaymentId();
		downloadReport();
		Runtime run = Runtime.getRuntime();
		run.exec(System.getProperty("user.dir")+"\\Drivers\\saveReport.exe");
		
	}
	
	
	
	//write code for refund verification when there is some refund
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
