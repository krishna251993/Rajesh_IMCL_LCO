package mobitics.lco.Plans_Disconnect;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import mobiotics.lco.commonPage.BasePage;
import mobiotics.lco.utilities.DemoExcelLibrary3;

public class Plans_DisconnectPageForLive extends BasePage{

	
	private String path = "./ExcelPages/TestData.xlsx";

	public Plans_DisconnectPageForLive(){
		
		PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(Plans_DisconnectPageForLive.class);
	
	@FindBy(tagName = "h1")
	private WebElement disconnectPageTitle;
	
	@FindBy(xpath="//input[@placeholder='Enter CAN/SMC/STB']")
	private WebElement canEnter;
	
	@FindBy(id="subscriberid")
	private WebElement goBtn;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()]/button")
	private WebElement disconnectBtn1;
	
//	@FindBy(xpath="(//tr/td[5]/button)[1]")
//	private WebElement disconnectBtnRow1;
	
	@FindBy(xpath = "(//input[@name='planlist'])[1]")
	private WebElement chkBoxForPlan1;
	
	@FindBy(xpath="//h4[text()='Failed To Disconnect Plan.']")
	WebElement failed_Status;	

	@FindBy(id = "confirm-subscribe")
	private WebElement confirmButton;
	
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]")
	private WebElement firstRow;
	
	
//----select package summary page elements----------------
	
	@FindBy(id = "confirmcart")
	private WebElement disconnectButtonSummaryPage;
	
	@FindBy(xpath = "//div[@class='planreport table-responsive']//tbody/tr[1]/td[2]")
	private WebElement disconnectStatus;
	
//--------------------Bulk---------------
	@FindBy(id = "bulkdisconnectbutton")
	private WebElement bulkDisconnectBtn;
	
	@FindBy(xpath = "//h4[text()='Bulk Disconnect']")
	private WebElement bulkPopUpTitle;
	
	@FindBy(xpath = "//input[@type='file']")
	private WebElement uplooadFld;
	
	@FindBy(id = "upload")
	private WebElement uploadBtn;
	
	@FindBy(xpath = "//label[text()='Upload success']")
	private WebElement uploadSuccessMsg;
	
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitBulk;
	
	@FindBy(xpath = "//p[@class='error text-danger']")
	private WebElement errorAfterUpload;
	
	@FindBy(xpath = "//p[@class='success-message text-success']")
	private WebElement successMsgBulk;
	
	
	
	
	
	
	public String getDisconnectPgeTitle() {
		//waitTillElementIsVisible(disconnectPageTitle);
		return disconnectPageTitle.getText();
	}
	
	public void enterCan(String cannum) {
		waitTillElementIsVisible(canEnter);
		canEnter.sendKeys(cannum);
	}
	
	public void clicGoBtn() {
		waitTillElementIsVisible(goBtn);
		goBtn.click();
	}
	
	public void selectPlan() {
		waitTillElementIsVisible(chkBoxForPlan1);
		chkBoxForPlan1.click();
		confirmButton.click();
	}
	
	public void disconnectPack()
	{
		waitTillElementIsVisible(disconnectButtonSummaryPage);
		disconnectButtonSummaryPage.click();
	}
	
	
	public boolean failedStatus() {
		waitTillElementIsVisible(failed_Status);
		return failed_Status.isDisplayed();
		
	}
	
	public void disconnectPlansSingle() throws InterruptedException
	{
		
		logger.info("Page Title is: "+disconnectPageTitle.getText());
		Assert.assertEquals(disconnectPageTitle.getText(), "Disconnect Plans");
		String canNumber = DemoExcelLibrary3.getexcelData("can.stb.smc", 1, 6, path);
		//System.out.println(canNumber);
		enterCan(canNumber);
		Thread.sleep(1000);
		clicGoBtn();
		
		Thread.sleep(3000);
		
		String resultedData = firstRow.getText();
		if(resultedData.contains("no active plans") || resultedData.contains("invalid") || resultedData.contains("Please include valid"))
		{
			logger.info(resultedData);
			return;
		}
		
		
		try {
			disconnectBtn1.click();
			Thread.sleep(4000);
			waitTillElementIsVisible(firstRow);
			logger.info(firstRow.getText());
			return;
			
		} catch (Exception e) {
			
		}
		
		try {
			
			if(confirmButton.isDisplayed())
			{
				selectPlan();
			}
			
		} catch (Exception e) {
			
		}
		
		disconnectPack();
		Thread.sleep(3000);
		if(disconnectStatus.getText().equalsIgnoreCase("SUCCESS"))
		{
			logger.info("Plan is disconnected successfully");
		}
		else
		{
			logger.info("Plan is not disconnected successfully");
		}	
		
	}
	
	public void disconnectPlansBulk() throws InterruptedException
	{
		logger.info("Page Title is: "+disconnectPageTitle.getText());
		Assert.assertEquals(disconnectPageTitle.getText(), "Disconnect Plans");
		bulkDisconnectBtn.click();
		Thread.sleep(2000);
		Assert.assertEquals(bulkPopUpTitle.isDisplayed(), true);
		uplooadFld.sendKeys(System.getProperty("user.dir")+"/ExcelPages/bulkdisconnecttemplate.csv");
		uploadBtn.click();
		Thread.sleep(1000);
		Assert.assertEquals(uploadSuccessMsg.isDisplayed(), true, "File is not uploaded successfully");
		submitBulk.click();
		Thread.sleep(4000);
		
		try {
			logger.info(errorAfterUpload.getText());
		} catch (Exception e) {
			
		}
		
		try {
			logger.info(successMsgBulk.getText());
		} catch (Exception e) {
			
		}
		
	
		
	}
	
}
