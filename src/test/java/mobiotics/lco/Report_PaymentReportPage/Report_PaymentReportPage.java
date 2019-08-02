package mobiotics.lco.Report_PaymentReportPage;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import generic.DateHelper2;

import mobiotics.lco.commonPage.BasePage;
import mobiotics.lco.utilities.DemoExcelLibrary3;

public class Report_PaymentReportPage extends BasePage{
	
	//String dateXp1 = "/html/body/div[4]/div[1]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[";
	String dateXp1 = "/html/body/div[5]/div[1]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[";
	String dateXp2 = "]/td[";
	
	//in test div[4]
	//in live div[5] for xpath of date
	
	private String path = "./ExcelPages/TestData.xlsx";
	private DateHelper2 dh = new DateHelper2();
	
	public Report_PaymentReportPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	static final Logger logger = Logger.getLogger(Report_PaymentReportPage.class);
	
	@FindBy(tagName = "h1")
	private WebElement pageTitle;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-calendar'])[1]")
	private WebElement fromDateCal;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-left'])[1]")
	private WebElement peviousMnthClikFrmDate;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-right'])[1]")
	private WebElement nxtMnthClikFrmDate;
	
	@FindBy(xpath = "(//th[@class='month']/span)[1]")
	private WebElement monthFrom;
	
	@FindBy(id = "refresh")
	private WebElement goBtnCal;
	
	@FindBy(id = "status")
	private WebElement paymentStatusList;
	
	@FindBy(id = "gwprovider")
	private WebElement paymentGateWayList;
	
	@FindBy(id = "paymenttype")
	private WebElement paymentTypeList;
	
	@FindBy(id = "paymentmode")
	private WebElement paymentModeList;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]")
	private WebElement firstRecorddisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()]")
	private WebElement statusDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-1]")
	private WebElement purposeDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[5]")
	private WebElement bankModeDisplaying;
	
	@FindBy(xpath = "//td[text()='No payments.']")
	private WebElement noPaymentMsg;
	
	@FindBy(xpath = "//button[text()='Payments Download']")
	private WebElement downloadButton;
	
	public void selectDates()
	{
		fromDateCal.click();
		String fromDate = "2019/04/01";
		System.out.println(fromDate);
		String fromDateArr[] = fromDate.split("/");
		dh.selectMonth(peviousMnthClikFrmDate, nxtMnthClikFrmDate, monthFrom.getText(), Integer.parseInt(fromDateArr[1]));
		dh.selectDate(dateXp1, dateXp2, Integer.parseInt(fromDateArr[2]));
		goBtnCal.click();
	}
	
	public void selectStatus(String status)
	{
		Select listStatus = new Select(paymentStatusList);
		listStatus.selectByVisibleText(status);
	}
	
	public void selectGateway(String gateway)
	{
		Select listStatus = new Select(paymentGateWayList);
		listStatus.selectByVisibleText(gateway);
	}
	
	public void selectPurpose(String purpose)
	{
		Select listStatus = new Select(paymentTypeList);
		listStatus.selectByVisibleText(purpose);
	}
	
	public void selectMode(String mode)
	{
		Select listStatus = new Select(paymentModeList);
		listStatus.selectByVisibleText(mode);
	}
	
	
	public void testPaymentReport() throws Exception
	{
		selectDates();
		
		Thread.sleep(5000);
		try {
			if(noPaymentMsg.isDisplayed())
			{
				logger.info(noPaymentMsg.getText());
				return;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		waitTillElementIsVisible(statusDisplaying);
		String status = statusDisplaying.getText();
		selectStatus(status);
		Thread.sleep(3000);
		String gateway = "PAYTM";
		selectGateway(gateway);
		waitTillElementIsVisible(purposeDisplaying);
		String purpose = purposeDisplaying.getText();
		selectPurpose(purpose);
		
		Thread.sleep(4000);
		
		logger.info(firstRecorddisplaying.getText());
		
		logger.info("Payment status entered: "+status+" displaying: "+statusDisplaying.getText());
		Assert.assertEquals(statusDisplaying.getText(), status);
		logger.info("Gateway selected: "+gateway+" displaying: "+bankModeDisplaying.getText());
		Assert.assertEquals(bankModeDisplaying.getText(), gateway);
		logger.info("Purpose selected: "+purpose+" purpose displaying: "+purposeDisplaying.getText());
		Assert.assertEquals(purposeDisplaying.getText(), purpose);
		downloadButton.click();
		Runtime run = Runtime.getRuntime();
		run.exec(System.getProperty("user.dir")+"\\Drivers\\saveReport.exe");
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
