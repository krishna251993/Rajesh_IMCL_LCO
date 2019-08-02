package mobiotics.lco.TestAutoRenewFeaturePage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import generic.Property;
import generic.Utility;
import mobiotics.lco.commonPage.BasePage;
import mobiotics.lco.utilities.DemoExcelLibrary3;

public class AutoRenewPage extends BasePage{
	
	public static final Logger logger=Logger.getLogger(AutoRenewPage.class);
	
	public AutoRenewPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="bulkmodalsubscribe")
	private WebElement bulkSechdule;
	
	@FindBy(xpath="//input[@type='file']")
	private WebElement fileUpload;
	
	@FindBy(id="upload")
	private WebElement uploadBtn;
	
	@FindBy(xpath="//label[@class='upload-status text-success']")
	private WebElement uploadSuccess;
	
	@FindBy(xpath="//button[@class='btn btn-danger create']")
	private WebElement sechduleBtn;
	
	@FindBy(id="schedule-close")
	private WebElement closeBtn;
	
	@FindBy(xpath="//input[@placeholder='Enter CAN/SMC/STB' and @name='subscriberid']")
	private WebElement enterCan;
	
	@FindBy(id="subscriberid")
	private WebElement goBtn;
	
	@FindBy(xpath="//h1[@class='pull-leftinput']")
	private WebElement autoRenewPage;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private List<WebElement> checkBoxes;
	//BST00014PP
	@FindBy(id="BST00014PP")
	private WebElement selectDropDown;
	
	@FindBy(id="confirm-subscribe")
	private WebElement confirmSelect;
	
	@FindBy(xpath="//*[@id=\"confirm-modal\"]/div/div/div[2]/div/table/tbody/tr/td[1]")
	private WebElement planeName;
	
	@FindBy(xpath="//*[@id=\"confirm-modal\"]/div/div/div[2]/div/table/tbody/tr/td[2]")
	private WebElement AutoRenewPeriod;
	
	@FindBy(id="confirm_selection")
	private WebElement confirmSechdule;
	
	@FindBy(xpath="(//*[@id='individual-progress']/tr/td[1])[2]")
	private WebElement AccountNumber;
	
	@FindBy(xpath="(//*[@id='individual-progress']/tr/td[2])[2]")
	private WebElement PlanName;
	
	@FindBy(xpath="(//*[@id='individual-progress']/tr/td[3])[2]")
	private WebElement RenewalStatus;
	
	@FindBy(id="modal-close")
	private WebElement close;

	@FindBy(id="validity_error_message")
	private WebElement validityErrorMsg;
	
	private String  validityEMsg="//*[@id='validity_error_message']";
	
	private String bulkAutoRenewPath=System.getProperty("user.dir")+"/ExcelPages/BulkAutoRenew.csv";
	private String dataPath="./ExcelPages/TestData.xlsx";
	
	private String xp1="(//input[@type='checkbox'])[";
	private String xp2="]";
	
	
	
	
	public int countNumberOfCheckBoxes() {
		return checkBoxes.size();
	}
	
	
	
	public void selectRenewalPeriod(String value) {
		Select select=new Select(selectDropDown);
		select.selectByValue(value);
		
	}
	
	
	public void BulkAutoRenewFeature() {
		if(autoRenewPage.getText().equals("Schedule Plans for Auto Renew"))
		{
			Assert.assertTrue(true);
			logger.info("user is going renew the plane in bulk");
			waitTillElementIsVisible(bulkSechdule);
			bulkSechdule.click();
			
			logger.info("user clicked on the bulk Button for the Bulk AutoRenew");
			
			fileUpload.sendKeys(bulkAutoRenewPath);
			logger.info("File Uploaded successfully");
			waitTillElementIsVisible(uploadBtn);
			uploadBtn.click();
			
            logger.info("upload button clicked");
			
			waitTillElementIsVisible(uploadSuccess);
			if(uploadSuccess.getText().equals("Upload success")) 
			{
				logger.info(uploadSuccess.getText());
				waitTillElementIsVisible(sechduleBtn);
				sechduleBtn.click();
				waitTillElementIsVisible(closeBtn);
				closeBtn.click();
				logger.info("After click on the sechdule Button user click on the close button");
				
			}else {
				logger.info("upload got failed due to"+uploadSuccess.getText());
			}
			
		}else {
			Assert.assertTrue(false);
			//put the code for the capture screen shot so that i will add the screen shot after the test case will get failed
				}
	}
	
	//---------------------------for single Auto-renew----------------
	
	public void singleAutoRenew() {
		if(autoRenewPage.getText().equals("Schedule Plans for Auto Renew"))
		{
			Assert.assertTrue(true);
			
			logger.info("user is in auto renew page");
			
			String canForAutoRenew=DemoExcelLibrary3.getexcelData("can.stb.smc", 1, 5, dataPath);
			waitTillElementIsVisible(enterCan);
			enterCan.sendKeys(canForAutoRenew);
			
			logger.info("user enters "+canForAutoRenew+" for Auto renew");
			waitTillElementIsVisible(goBtn);
			goBtn.click();
			
			waitTillElementIsVisible(selectDropDown);
			
			selectRenewalPeriod("1");
			
			int checkboxes=countNumberOfCheckBoxes();
			
			int num=Utility.getRandomNumber(1, checkboxes);
			
			System.out.println(num);
			
			runRandomXpath(xp1, 1, xp2);
			
			logger.info("user checked the check Box");
			
			waitTillElementIsVisible(confirmSelect);
			
			confirmSelect.click();
			
			waitTillElementIsVisible(planeName);
			logger.info("plan Name-"+planeName.getText());
			waitTillElementIsVisible(AutoRenewPeriod);
			logger.info("Auto renew period-"+AutoRenewPeriod.getText());
			
			waitTillElementIsVisible(confirmSechdule);
			confirmSechdule.click();
			
			if(Property.IsTestElementPresent(driver, validityEMsg)) {
				
				
				
				
				waitTillElementIsVisible(AccountNumber);
				logger.info("Account Number-"+AccountNumber.getText());
				
				logger.info("Plan Name-"+planeName.getText());
				
				logger.info("Renewal status-"+RenewalStatus.getText());
				
				waitTillElementIsVisible(close);
				close.click();
				
				
			}
			
			else {
				
				waitTillElementIsVisible(validityErrorMsg);
				logger.info("Auto renewal unsuccess-"+validityErrorMsg.getText());
				waitTillElementIsVisible(close);
				close.click();
			
				
					
			}
			
			
			
			
			
			
		}
	}
	
	
}
