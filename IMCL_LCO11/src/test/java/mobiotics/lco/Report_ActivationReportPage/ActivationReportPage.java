package mobiotics.lco.Report_ActivationReportPage;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import generic.DateHelper2;

import mobiotics.lco.commonPage.BasePage;

import mobiotics.lco.utilities.DemoExcelLibrary3;

public class ActivationReportPage extends BasePage {
	
private String path = "./ExcelPages/TestData.xlsx";

//live---private String dateXp1 = "/html/body/div[4]/div[2]/div[4]/div/div[1]/div[2]/table/tbody/tr[";
private String dateXp1 = "/html/body/div[5]/div[2]/div[4]/div/div[1]/div[2]/table/tbody/tr[";
private String dateXp2 = "]/td[";

	DateHelper2 dh = new DateHelper2();
	public ActivationReportPage(){
		
		PageFactory.initElements(driver, this);
	}
	
	static final Logger logger = Logger.getLogger(ActivationReportPage.class);	
	
	@FindBy(xpath = "//h1[text()='Activations Report']")
	private WebElement pageTitle;
	
	@FindBy(id="status")
	private WebElement status;
	
	@FindBy(id="type")
	private WebElement type;
	
	@FindBy(xpath = "//input[@placeholder='Search By CAN/STB/SMC']")
	private WebElement canNumTxtField;
	
	@FindBy(xpath = "//input[@placeholder='Search By CAN/STB/SMC']/following-sibling::button")
	private WebElement canNoGoBTn;
	
	@FindBy(xpath = "(//button[text()='Go'])[1]")
	private WebElement goButton;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-calendar'])[1]")
	private WebElement fromDateCal;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-left'])[1]")
	private WebElement previousMonthFromCal;
	
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-right'])[1]")
	private WebElement nextMonthFromCal;
	
	@FindBy(xpath = "(//tbody/tr[2]/td[3])[1]")
	private WebElement date;
	
	@FindBy(id="refresh")
	private WebElement dateGo;
	
	@FindBy(xpath = "(//table[@class='table table-striped']/tbody/tr/td[2])[1]") 
	private WebElement subscriberIdListing;
	
	@FindBy(xpath = "//tr[@class='2587783'][1]/td[last()]")
	private WebElement activationTypeListed;
	
	@FindBy(xpath = "//tbody/tr[@class='3063313'][1]/td[9]")
	private WebElement statusListed;
	
	@FindBy(xpath = "//td[text()='No activations.']")
	private WebElement failedMsg;
	
	@FindBy(xpath = "//button[text()='Activations Download']")
	private WebElement downloadButton;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()]")
	private WebElement typeText;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()-1]")
	private WebElement statusText;
	
	@FindBy(id = "arcdownload")
	private WebElement archieveDownload;
	
	@FindBy(xpath = "//button[text()='Download']")
	private WebElement downloadArcBtn;
	
	@FindBy(xpath = "(//button[@class='close'])[last()]")
	private WebElement closeArc;
	
	public void selectFromDate()
	{
		String fromDate = "2019-04-01";
		System.out.println(fromDate);
		String fromDateArr[] = fromDate.split("-");
		fromDateCal.click();
		waitTillElementIsVisible(nextMonthFromCal);
		dh.selectMonth(previousMonthFromCal, nextMonthFromCal, "May", Integer.parseInt(fromDateArr[1]));
		dh.selectDate(dateXp1, dateXp2, Integer.parseInt(fromDateArr[2]));
		goButton.click();
		
	}
	
	public void enterCanNumber(String canNo)
	{
		canNumTxtField.sendKeys(canNo);
		waitTillElementIsClickable(canNoGoBTn);
		canNoGoBTn.click();
	}
	
	public void selectType(String typeActivation)
	{
		Select typeList = new Select(type);
		typeList.selectByVisibleText(typeActivation);
	}
		
	public void selectStatus(String activationStatus)
	{
		Select statusList = new Select(status);
		statusList.selectByVisibleText(activationStatus);
	}
	
	public String verifyCanNumber()
	{
		waitTillElementIsVisible(subscriberIdListing);
		return subscriberIdListing.getText();
	}

	public void downloadReport() throws Exception
	{
		if(downloadButton.isEnabled())
		{
			downloadButton.click();
			
			Robot r = new Robot();
			
			r.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
			r.keyRelease(KeyEvent.VK_ENTER);
			
			
		}
		
	}
	
	
	public void activationReportTest() throws InterruptedException, IOException
	{
		selectFromDate();
		String canNo = DemoExcelLibrary3.getexcelData("can.stb.smc", 1, 16, path);
		enterCanNumber(canNo);
		Thread.sleep(5000);
//		try {
//			if(failedMsg.isDisplayed())
//			{
//				logger.info(failedMsg.getText());
//				Assert.assertEquals(failedMsg.getText(), "No activations.");
//				return;
//			}
//			
//			
//		} catch (Exception e) {
//			
//		}
		
		
		String canNumberDisplaying = verifyCanNumber();
		logger.info("Entered CAN Number is: "+canNo+" and activation report is displaying for the CAN number is: "+canNumberDisplaying);
		Assert.assertEquals(canNumberDisplaying, canNo);
		downloadButton.click();
		Runtime run = Runtime.getRuntime();
		run.exec(System.getProperty("user.dir")+"\\Drivers\\saveReport.exe");
		
//		waitTillElementIsClickable(archieveDownload);
//		archieveDownload.click();
//		waitTillElementIsClickable(downloadArcBtn);
//		downloadArcBtn.click();
//		run.exec(System.getProperty("user.dir")+"\\Drivers\\saveReport.exe");
//		
//		waitTillElementIsClickable(closeArc);
//		closeArc.click();
		
	}
	
	
	

}
