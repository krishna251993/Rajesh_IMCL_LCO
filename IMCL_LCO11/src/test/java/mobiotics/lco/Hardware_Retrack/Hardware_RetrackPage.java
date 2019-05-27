package mobiotics.lco.Hardware_Retrack;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import mobiotics.lco.commonPage.BasePage;
import mobiotics.lco.utilities.DemoExcelLibrary3;
import mobitics.lco.Plans_Disconnect.Plans_DisconnectPageForLive;

public class Hardware_RetrackPage extends BasePage{
	
	private String path = "./ExcelPages/TestData.xlsx";

	public Hardware_RetrackPage(){
		
		PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(Hardware_RetrackPage.class);
	
	@FindBy(tagName = "h1")
	private WebElement pageTitle;
	
	
	@FindBy(name = "deviceid")
	private WebElement deviceIdTxtFld;
	
	@FindBy(xpath = "//button[text()='Send']")
	private WebElement sendBtn;
	
	@FindBy(xpath = "//p[@class='text-error error message']")
	private WebElement errMsg;
	
	@FindBy(xpath = "//p[@class='text-success success message']")
	private WebElement successMsg;
	
	public void testRetackServices() throws InterruptedException
	{
		Assert.assertEquals(pageTitle.getText(), "Retrack Service");
		String canNumber = DemoExcelLibrary3.getexcelData("can.stb.smc", 1, 9, path);
		deviceIdTxtFld.sendKeys(canNumber);
		sendBtn.click();
		Thread.sleep(3000);
		
		try {
			if(successMsg.getText().equalsIgnoreCase("Retrack Successfull"))
			
			logger.info(successMsg.getText());
			
			else {
				
				logger.info(errMsg.getText());
			}
				
			
		} catch (Exception e) {
			
			
		}
	}
	
	
	
	
	
	
	
	
	

}
