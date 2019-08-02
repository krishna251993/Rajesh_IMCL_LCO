package mobiotics.lco.changeBase_Pack;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import mobiotics.lco.Plans_Reconnect.Plans_ReconnectPageForLive;
import mobiotics.lco.commonPage.BasePage;
import mobiotics.lco.utilities.DemoExcelLibrary3;

public class Plans_ChangeBasePack extends BasePage{

	private String path = "./ExcelPages/TestData.xlsx";
	
	public Plans_ChangeBasePack() {
		PageFactory.initElements(driver, this);
	}
	
	
	static final Logger logger=Logger.getLogger(Plans_ChangeBasePack.class);
	
	
	@FindBy(xpath="//h1[@class='pull-leftinput']")
	private WebElement changeBasePackTitle;
	
	@FindBy(id="bulkmodalsubscribe")
	private WebElement bulkChangeBasePack;
	
	@FindBy(xpath="//input[@type='file']")
	private WebElement fileUpload;
	
	@FindBy(id="upload")
	private WebElement uploadBtn;
	
	@FindBy(xpath="//label[@class='upload-status text-success']")
	private WebElement uploadSuccess;
	
	@FindBy(xpath="//button[@class='btn btn-danger create']")
	private WebElement changeBasePack;
	
	@FindBy(id="change-base-close")
	private WebElement closeBtn;
	
	private String bulkChangeBasePackFile=System.getProperty("user.dir")+"/ExcelPages/BulkChangeBasePack.csv";
	
	//------------------FOr single------------
	
	@FindBy(name = "subscriberid")
	private WebElement CANnoTxtField;
	
	@FindBy(id = "subscriberid")
	private WebElement canNOGoBtn;
	
	@FindBy(xpath = "//tbody/tr[1]")
	private WebElement errMsg;
	
	@FindBy(xpath = "(//input[@type='radio'][@name='planlist'])[1]")
	private WebElement selectBasePackFrm1stRow;
	
	@FindBy(id = "confirm-subscribe")
	private WebElement confirmSelectBtn;
	
	@FindBy(xpath = "(//h1[@class='pull-left'])[1]")
	private WebElement selectedPkgTitle;
	
	@FindBy(id = "confirmcart")
	private WebElement subscribeBtn;
	
	@FindBy(xpath = "//div[@class='form-group status-text']")
	private WebElement subscriptionStatus;
	
	@FindBy(xpath = "//tbody[@id='individual-progress']/tr[1]")
	private WebElement subscriptionDetails;
	
	
	
	
	
	public void changeBasepackInBulk() {
		if(changeBasePackTitle.getText().equals("Change Base Pack")) {
		
			Assert.assertTrue(true);
			logger.info("user is in change base pack page");
			waitTillElementIsClickable(bulkChangeBasePack);
			bulkChangeBasePack.click();
			fileUpload.sendKeys(bulkChangeBasePackFile);
			waitTillElementIsVisible(uploadBtn);
			uploadBtn.click();
			
			waitTillElementIsVisible(changeBasePack);
			changeBasePack.click();
			waitTillElementIsClickable(closeBtn);
			closeBtn.click();
			
			
		}
	}
	
	public void changeBasePackInSingle() throws InterruptedException
	{
		Assert.assertEquals(changeBasePackTitle.getText(), "Change Base Pack", "This is not the Change Base Pack Page");
		String canNumber = DemoExcelLibrary3.getexcelData("can.stb.smc", 1, 8, path);
		CANnoTxtField.sendKeys(canNumber);
		canNOGoBtn.click();
		Thread.sleep(2000);
		
		
		try {
			if(selectBasePackFrm1stRow.isDisplayed())
			{
				selectBasePackFrm1stRow.click();
				confirmSelectBtn.click();
				Thread.sleep(3000);
				Assert.assertEquals(selectedPkgTitle.getText(), "Selected Package Summary");
				Thread.sleep(10000);
				logger.info("Selected Package Summary get displayed");
				subscribeBtn.click();
				
				Thread.sleep(5000);
				
				logger.info("Subscription Status is:-----");
				logger.info(subscriptionStatus.getText());
				
				Thread.sleep(2000);
				logger.info("Subscription details------------");
				logger.info(subscriptionDetails.getText());
				
			}
		}
		
		catch (Exception e) {
			
			logger.warn(errMsg.getText());
			
		}
		
		
			
		
		
		
	}
	
	
	
	
}
