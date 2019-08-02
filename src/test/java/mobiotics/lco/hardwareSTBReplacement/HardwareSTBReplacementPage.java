package mobiotics.lco.hardwareSTBReplacement;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import mobiotics.lco.Hardware_Retrack.Hardware_RetrackPage;
import mobiotics.lco.commonPage.BasePage;
import mobiotics.lco.utilities.DemoExcelLibrary3;

public class HardwareSTBReplacementPage extends BasePage{
	
	private String path = "./ExcelPages/TestData.xlsx";

	public HardwareSTBReplacementPage(){
		
		PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(HardwareSTBReplacementPage.class);
	
	@FindBy(xpath = "//h1[text()='STB Replacement']")
	private WebElement pageTitle;
	
	@FindBy(name = "customernumber")
	private WebElement canNoTxtFld;
	
	@FindBy(id = "check")
	private WebElement checkBtn;
	
	@FindBy(xpath = "(//input[@value='GOOD'])[2]")
	private WebElement selectReason;
	
	@FindBy(id = "newstbslno")
	private WebElement newSTBNoTxtFld;
	
	@FindBy(id = "newsmcslno")
	private WebElement newSMCNoTxtFld;
	
	@FindBy(xpath = "(//button[text()='STB Replacement'])[2]")
	private WebElement stbReplacementBtn;
	
	@FindBy(xpath = "//p[@class='text-error error']")
	private WebElement errMsg;
	
	@FindBy(xpath = "//p[@class='text-success success']")
	private WebElement successMsg;
	
	public void testSTBReplacement() throws InterruptedException
	{
		Assert.assertEquals(pageTitle.isDisplayed(), true, "STB Replacement Page is not getting displayed");
		String canNumber = DemoExcelLibrary3.getexcelData("can.stb.smc", 1, 10, path);
		canNoTxtFld.sendKeys(canNumber);
		checkBtn.click();
		Thread.sleep(2000);
			if(!(errMsg.getText().equals("")))
			{
				logger.info(errMsg.getText());
				return;
			}
		waitTillElementIsClickable(selectReason);
		selectReason.click();
		String newSTBeNO = DemoExcelLibrary3.getexcelData("can.stb.smc", 1, 11, path);
		newSTBNoTxtFld.sendKeys(newSTBeNO);
		String newSMCNo = DemoExcelLibrary3.getexcelData("can.stb.smc", 2, 11, path);
		newSMCNoTxtFld.sendKeys(newSMCNo);
		waitTillElementIsClickable(stbReplacementBtn);
		stbReplacementBtn.click();
		Thread.sleep(4000);
		
		try {
			if(!(successMsg.getText().equals(""))) 
			{
				logger.info(successMsg.getText());
			}
			
			else
			{
				logger.info(errMsg.getText());
			}
		} catch (Exception e) {
			
			
		}
	}
	
	
	
	
	

}
