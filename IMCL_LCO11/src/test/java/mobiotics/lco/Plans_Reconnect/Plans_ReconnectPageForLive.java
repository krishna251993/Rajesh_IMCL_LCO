package mobiotics.lco.Plans_Reconnect;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generic.Utility;
import mobiotics.lco.commonPage.BasePage;
import mobiotics.lco.utilities.DemoExcelLibrary3;

public class Plans_ReconnectPageForLive extends BasePage {

	
private String path = "./ExcelPages/TestData.xlsx";
	
	public Plans_ReconnectPageForLive() {
		
		PageFactory.initElements(driver, this);
	}
	
static final Logger logger=Logger.getLogger(Plans_ReconnectPageForLive.class);
	
	
	@FindBy(id="bulkreconnectbutton")
	private WebElement bulkReconnect;

	@FindBy(xpath = "//h1[text()='Reconnect Plans']")
	private WebElement reconnectPageTitle;
	
	@FindBy(xpath = "//input[@placeholder='Enter CAN/SMC/STB']")
	private WebElement canNumTxtField;
	
	@FindBy(xpath="(//input[@name='planlist'])")
	private List<WebElement> checkBoxes;
	
	private String xp1="(//input[@name='planlist'])[";
	
	private String xp2="]";
	
	@FindBy(id = "subscriberid")
	private WebElement goButton;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()]/button")
	private WebElement reconnectBtn1;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]")
	private WebElement firstRow;
	
//	@FindBy(xpath="//tbody/tr[1]/td[5]")
//	private WebElement reconnnectBtnR1;
	
	@FindBy(xpath = "(//input[@name='planlist'])[1]")
	private WebElement selectPlanchkBox;
	
	@FindBy(id = "confirm-subscribe")
	private WebElement confirmSelect;

	//-----These are selected Package Summary page---------
	
	
	@FindBy(id = "confirmcart")
	private WebElement reconnectButtonSummaryPage;
	
	@FindBy(xpath = "(//div[@class='planreport table-responsive']//tbody/tr[1]/td[2])[1]")
	private WebElement reconnectStatus;
	
	@FindBy(xpath = "//div[@class='planreport table-responsive']//tbody/tr[1]/td[last()]")
	private WebElement errorCode;
	
	@FindBy(xpath="//input[@type='file']")
	private WebElement fileUpload;
	
	@FindBy(id = "upload")
	private WebElement uploadBtn;
	
	@FindBy(xpath = "//label[text()='Upload success']")
	private WebElement uploadSuccessMsg;
	
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement bulkSubmit;
	
	@FindBy(xpath = "//button[@class='btn btn-default'][text()='Close']")
	private WebElement bulkPopUpClose;
	
	public String getPageTitle()
	{
		waitTillElementIsVisible(reconnectPageTitle);
		return reconnectPageTitle.getText();
	}
	
	public void enterCanNumber(String canNo)
	{
		waitTillElementIsVisible(canNumTxtField);
		canNumTxtField.sendKeys(canNo);
		waitTillElementIsClickable(goButton);
		goButton.click();
		
	}
	
	
	/*
	 * public void clickReconnect() { waitTillElementIsVisible(reconnnectBtnR1);
	 * reconnnectBtnR1.click(); }
	 */
	
	public void selectPlans()
	{
		waitTillElementIsVisible(selectPlanchkBox);
		selectPlanchkBox.click();
		confirmSelect.click();
	}
	
	public void reconnectPlans()
	{
		waitTillElementIsClickable(reconnectButtonSummaryPage);
		reconnectButtonSummaryPage.click();
	}
	
	
	public void testReconnectPlans_Single() throws InterruptedException {
	
		String pageTitle = getPageTitle();
		logger.info(pageTitle);
		Assert.assertEquals(pageTitle, "Reconnect Plans");
		String canNo = DemoExcelLibrary3.getexcelData("can.stb.smc", 1, 7, path);
		enterCanNumber(canNo);
		
		Thread.sleep(3000);
		
		String resultedData = firstRow.getText();
		if(resultedData.contains("no disconnected plans") || resultedData.contains("invalid") || resultedData.contains("Please include valid"))
		{
			logger.info(resultedData);
			return;
		}
		
		try {
			reconnectBtn1.click();
			Thread.sleep(4000);
			waitTillElementIsVisible(firstRow);
			logger.info(firstRow.getText());
			return;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		int totalPlans=getNumberOfCheckBoxes(checkBoxes);
		
		runRandomXpath(xp1, Utility.getRandomNumber(1, totalPlans), xp2);
		waitTillElementIsVisible(confirmSelect);
		confirmSelect.click();
		waitTillElementIsVisible(reconnectButtonSummaryPage);
		reconnectButtonSummaryPage.click();
		logger.info(reconnectStatus);
		
		
		
		
		
		if((reconnectStatus.getText()).equalsIgnoreCase("SUCCESS"))
		{
			logger.info("Plan is reconnected successfully");
		}
		
		else
		{
			logger.info("Plan is not reconnected successfully");
			logger.info(errorCode.getText());
		}
	
		
		
	}
	
	
	
	
	//----------------------Re-Connect Plan in bulk----------------
	
	
	
	public void reconnectPlan_Bulk() throws IOException, InterruptedException {
		
		String pageTitle = getPageTitle();
		logger.info(pageTitle);
		Assert.assertEquals(pageTitle, "Reconnect Plans");
		Thread.sleep(3000);
		//waitTillElementIsClickable(bulkReconnect);
		bulkReconnect.click();
		Thread.sleep(2000);
		//waitTillElementIsVisible(fileUpload);
		fileUpload.sendKeys(System.getProperty("user.dir")+"/ExcelPages/BulkReconnect.csv");
		uploadBtn.click();
		Thread.sleep(2000);
		Assert.assertEquals(uploadSuccessMsg.isDisplayed(), true, "File is not uploaded successfully");
		bulkSubmit.click();
		Thread.sleep(1000);
		Assert.assertEquals(bulkSubmit.getAttribute("class"), "btn btn-danger create disabled", "Bulk Reconnect request has not been sent Successfully");
		bulkPopUpClose.click();
		logger.info("Bulk Reconnect Test is passed");
		
		
		Thread.sleep(5000);
		
		
		
		
		
	}
	
	
	
	
}
