package mobiotics.lco.modifyCustomer;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Factory;

import mobiotics.lco.commonPage.BasePage;
import mobiotics.lco.hardwareSTBReplacement.HardwareSTBReplacementPage;
import mobiotics.lco.utilities.DemoExcelLibrary3;

public class Subscriber_ModifyCustomerPage extends BasePage{
	
	private String path = "./ExcelPages/TestData.xlsx";
	
	public Subscriber_ModifyCustomerPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	static final Logger logger = Logger.getLogger(Subscriber_ModifyCustomerPage.class);
	
	@FindBy(xpath = "//h1[text()='Modify Customer']")
	private WebElement pageTitle;
	
	@FindBy(id = "customerno")
	private WebElement canNoTxtFld;
	
	@FindBy(id = "check")
	private WebElement checkBtn;
	
	@FindBy(id = "mobileno")
	private WebElement mobileNum;
	
	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(id = "aadharno")
	private WebElement aadharNo;
	
	@FindBy(name = "idprooffile")
	private WebElement uploadIdProof;
	
	@FindBy(id = "uploadidproof")
	private WebElement idProofUploadBtn;
	
	@FindBy(xpath = "//p[@class='idproof-upload-status text-center text-success']")
	private WebElement idProofUploadSuccessMsg;
	
	@FindBy(name = "addrprooffile")
	private WebElement addressProofUpload;
	
	@FindBy(id = "uploadaddrproof")
	private WebElement addressProofUploadBtn;
	
	@FindBy(xpath = "//p[@class='addrproof-upload-status text-center text-success']")
	private WebElement addProofUploadSuccessMsg;
	
	@FindBy(id = "update")
	private WebElement updatebTn;
	
	@FindBy(xpath = "//p[@class='text-success success']")
	private WebElement successMsg;
	
	@FindBy(xpath = "//p[@class='text-error error']")
	private WebElement errMsg;
	
	@FindBy(xpath = "//p[@class='text-error text-center error']")
	private WebElement informationErrMsg;
	
	
	
	
	public void testModifyCustomer() throws InterruptedException
	{
		Assert.assertEquals(pageTitle.isDisplayed(), true);
		String canNumber = DemoExcelLibrary3.getexcelData("can.stb.smc", 1, 12, path);
		canNoTxtFld.sendKeys(canNumber);
		checkBtn.click();
		Thread.sleep(2000);
		if(!(errMsg.getText().equals("")))
		{
			logger.info(errMsg.getText());
			return;
		}
		mobileNum.clear();
		mobileNum.sendKeys("7724083837");
		email.clear();
		email.sendKeys("abc@123.com");
		aadharNo.clear();
		aadharNo.sendKeys("954389769018");
		uploadIdProof.sendKeys(System.getProperty("user.dir")+"/images/Screenshot_1.png");
		waitTillElementIsClickable(idProofUploadBtn);
		idProofUploadBtn.click();
		Assert.assertEquals(idProofUploadSuccessMsg.isDisplayed(), true, "Id proof is not uploaded successfully");
		addressProofUpload.sendKeys(System.getProperty("user.dir")+"/images/Screenshot _2.png");
		waitTillElementIsClickable(addressProofUploadBtn);
		addressProofUploadBtn.click();
		Assert.assertEquals(addProofUploadSuccessMsg.isDisplayed(), true, "Address Proof is not uploaded successfully");
		Thread.sleep(3000);
		updatebTn.click();
		
		Thread.sleep(4000);
		
		
			if(!(informationErrMsg.getText().equals("")))
			{
				logger.info(informationErrMsg.getText());
				return;
			}
			
			else if(!(errMsg.getText().equals("")))
			{
				logger.info(errMsg.getText());
			}
			
			else if(successMsg.getText().contains("Updated Successfully"))
			{
				logger.info(successMsg.getText());
			}
		
		
		
	}

}
