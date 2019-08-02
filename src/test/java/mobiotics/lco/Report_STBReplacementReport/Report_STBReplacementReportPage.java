package mobiotics.lco.Report_STBReplacementReport;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import generic.DateHelper2;

import mobiotics.lco.commonPage.BasePage;
import mobiotics.lco.utilities.DemoExcelLibrary3;

public class Report_STBReplacementReportPage extends BasePage{
	
	private String path = "./ExcelPages/TestData.xlsx";
	private DateHelper2 dh  = new DateHelper2();
	
	//live---private String fromDateXp1 = "/html/body/div[4]/div[1]/div[2]/div/div[1]/div[2]/table/tbody/tr[";
	private String fromDateXp1 = "/html/body/div[5]/div[1]/div[2]/div/div[1]/div[2]/table/tbody/tr[";
	private String fromDateXp2 = "]/td[";
	
	
	public Report_STBReplacementReportPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	static final Logger logger = Logger.getLogger(Report_STBReplacementReportPage.class);
	
	@FindBy(tagName = "h1")
	private WebElement pageTitle;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-calendar'])[1]")
	private WebElement fromDateCal;
	
	@FindBy(xpath = "(//th[@class='month']/span)[1]")
	private WebElement monthFrom;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-left'])[1]")
	private WebElement priviousClkFrmMonth;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-right'])[1]")
	private WebElement nxtClkFrmMonth;
	
	@FindBy(id = "refresh")
	private WebElement goBtnCal;
	
	@FindBy(id = "status")
	private WebElement statusDropdown;
	
	@FindBy(xpath = "//input[@placeholder='Search By CAN/STB/SMC']")
	private WebElement customerIdTxtField;
	
	@FindBy(xpath = "//input[@placeholder='Search By CAN/STB/SMC']/following-sibling::button")
	private WebElement custIdGoBtn;
	
	@FindBy(xpath = "//input[@placeholder='Search By Old STB Number']")
	private WebElement oldSTBTxtField;
	
	@FindBy(xpath = "//input[@placeholder='Search By Old STB Number']/following-sibling::button")
	private WebElement oldSTBGoBtn;
	
	
	@FindBy(xpath = "//input[@placeholder='Search By New STB Number']")
	private WebElement newSTBTxtField;
	
	@FindBy(xpath = "//input[@placeholder='Search By New STB Number']/following-sibling::button")
	private WebElement newSTBGoBtn;
	
	@FindBy(xpath = "//input[@placeholder='Search By Old SMC Number']")
	private WebElement oldSMCTxtField;
	
	@FindBy(xpath = "//input[@placeholder='Search By Old SMC Number']/following-sibling::button")
	private WebElement oldSMCGoBtn;
	
	@FindBy(xpath = "//table[@class='table table-striped']/thead/tr")
	private WebElement recordHeader;
	
	@FindBy(xpath = "//table[@class='table table-striped']//tbody/tr[1]")
	private WebElement firstRecord;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[1]")
	private WebElement custIdDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[2]")
	private WebElement oldSTBDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[3]")
	private WebElement newSTBDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[4]")
	private WebElement oldSMCDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[last()-1]")
	private WebElement statusDisplaying;
	
	@FindBy(xpath = "//h4[contains(text(),'No STB Replacement')]")
	private WebElement noSTBReplacementMsg;
	
	@FindBy(xpath = "//button[text()='STB Replacement Report Download']")
	private WebElement downloadButton;
	
	public void selectDates()
	{
		fromDateCal.click();
		String fromDate = "2019/04/01";
		String fromDateArr[] = fromDate.split("/");
		dh.selectMonth(priviousClkFrmMonth, nxtClkFrmMonth, monthFrom.getText(), Integer.parseInt(fromDateArr[1]));
		dh.selectDate(fromDateXp1, fromDateXp2, Integer.parseInt(fromDateArr[2]));
		waitTillElementIsVisible(goBtnCal);
		goBtnCal.click();
	}
	
	public void selectStatus(String status)
	{
		Select listStatus = new Select(statusDropdown);
		listStatus.selectByVisibleText(status);
	}
	
	public void enterCustomerId(String customerId)
	{
		customerIdTxtField.sendKeys(customerId);
		waitTillElementIsVisible(custIdGoBtn);
		custIdGoBtn.click();
	}
	
	public void enterOldSTBNo(String oldSTBNo)
	{
		oldSTBTxtField.sendKeys(oldSTBNo);
		waitTillElementIsVisible(oldSTBGoBtn);
		oldSTBGoBtn.click();
	}
	
	public void enterNewSTBNo(String newSTBno)
	{
		newSTBTxtField.sendKeys(newSTBno);
		waitTillElementIsVisible(newSTBGoBtn);
		newSTBGoBtn.click();
	}
	
	public void enterOldSMCNo(String oldSMCNo)
	{
		oldSMCTxtField.sendKeys(oldSMCNo);
		waitTillElementIsVisible(oldSMCGoBtn);
		oldSMCGoBtn.click();
	}
	
	
	public void testSTBReplacementReport() throws Exception
	{
		logger.info("Page Title is: "+pageTitle.getText());
		Assert.assertEquals(pageTitle.getText(), "Swap Report");
		selectDates();
		
		Thread.sleep(4000);
		String firstRecordData = firstRecord.getText();
		
		try {
			if(firstRecordData.contains("No STB Replacement") || firstRecordData.contains("Invalid "))
			{
				logger.info(firstRecordData);
				return;
			}
		} catch (Exception e) {

		}
		
		
		String customerId = DemoExcelLibrary3.getexcelData("can.stb.smc", 1, 18, path);
		enterCustomerId(customerId);
		waitTillElementIsVisible(firstRecord);
		firstRecordData = firstRecord.getText();
		try {
			if(firstRecordData.contains("No STB Replacement") || firstRecordData.contains("Invalid "))
			{
				logger.info(firstRecordData);
				return;
			}
		} catch (Exception e) {

		}
		waitTillElementIsVisible(statusDisplaying);
		String status = statusDisplaying.getText();
		selectStatus(status);
		String oldSTBNo = oldSTBDisplaying.getText();
		enterOldSTBNo(oldSTBNo);
		String newSTBNo = newSTBDisplaying.getText();
		enterNewSTBNo(newSTBNo);
		String oldSMCNo = oldSMCDisplaying.getText();
		enterOldSMCNo(oldSMCNo);
		
		
		logger.info("Entered information: ");
		logger.info("status: "+status);
		logger.info("Customer Id: "+customerId);
		logger.info("Old STB Number: "+oldSTBNo);
		logger.info("New STB Number: "+newSTBNo);
		logger.info("Old SMC Number: "+oldSMCNo);
		logger.info(recordHeader.getText());
		logger.info(firstRecord.getText());
		
		Assert.assertEquals(statusDisplaying.getText(), status);
		Assert.assertEquals(custIdDisplaying.getText(), customerId);
		Assert.assertEquals(oldSTBDisplaying.getText(), oldSTBNo);
		Assert.assertEquals(newSTBDisplaying.getText(), newSTBNo);
		Assert.assertEquals(oldSMCDisplaying.getText(), oldSMCNo);
		downloadButton.click();
		Runtime run = Runtime.getRuntime();
		run.exec(System.getProperty("user.dir")+"\\Drivers\\saveReport.exe");
		logger.info("Test case is passed for STB Replacement Report");
		
		
	}

}
