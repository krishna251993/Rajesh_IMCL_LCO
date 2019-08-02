package mobiotics.lco.RenewPlanePage;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generic.Utility;
import mobiotics.lco.commonPage.BasePage;
import mobiotics.lco.testCases.TC_RenewPage_007;
import mobiotics.lco.utilities.DemoExcelLibrary3;

public class RenewPage extends BasePage {

	public RenewPage() {
		PageFactory.initElements(driver, this);
	}
	static final Logger logger=Logger.getLogger(TC_RenewPage_007.class);

	@FindBy(xpath="//input[@placeholder='Enter CAN/SMC/STB' and @name='subscriberid']")
	private WebElement enterCan;
	
	@FindBy(id="subscriberid")
	private WebElement goBtn;
	
	@FindBy(xpath="//h1[@class='pull-leftinput']")
	private WebElement renewPage;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private List<WebElement> checkBoxes;
	
	@FindBy(xpath="(//div[@class='alert alert-danger top-error text-center'])[1]")
	WebElement errorPopUp;
	
	@FindBy(id="confirm-subscribe")
	private WebElement confirmSelect;
	
	@FindBy(id="bulkmodalsubscribe")
	private WebElement bulkRenew;
	
	
	@FindBy(xpath="//input[@type='file']")
	private WebElement fileUpload;

	@FindBy(id="upload")
	private WebElement upload;
	
	@FindBy(xpath="//button[text()='Renew']")
	private WebElement Renew;
	
	@FindBy(id="renew-close")
	private WebElement renewClose;
	
	@FindBy(xpath="//label[@class='upload-status text-success']")
	private WebElement uploadSuccess;
	
	@FindBy(xpath="/html/body/div[6]/div[2]/div[2]/div[1]/table/tbody/tr/td[1]")
	private WebElement planName;
	
	@FindBy(xpath="/html/body/div[6]/div[2]/div[2]/div[1]/table/tbody/tr/td[2]")
	private WebElement subscriptionAmount;
	
	@FindBy(xpath="/html/body/div[6]/div[2]/div[2]/div[1]/table/tbody/tr/td[3]")
	private WebElement NCFPrice;
	
	@FindBy(xpath="/html/body/div[6]/div[2]/div[2]/div[1]/table/tbody/tr/td[4]")
	private WebElement expiryDate;
	
	@FindBy(xpath="(//label[@id='amount2'])[2]")
	private WebElement tax;
	
	@FindBy(xpath="(//label[@id='amount3'])")
	private WebElement totalPrice;
	
	@FindBy(id="confirmcart")
	private WebElement subscribeBtn;
	
	private String bulkFilePath=System.getProperty("user.dir")+"/ExcelPages/BulkRenew.csv";
	private String dataPath="./ExcelPages/TestData.xlsx";

	private String xp1="(//input[@type='checkbox'])[";
	private String xp2="]";
	
	public void clickRandomCheckBox() {
		
		int size=checkBoxes.size();
		logger.info("Total number of renew option is available="+size);
		for (int i = 2; i < size; i++) {
			//WebElement radioButton=checkBoxes.get(i);
			WebElement radioButton=driver.findElement(By.xpath(xp1+i+xp2));
			if(radioButton.isEnabled()) {
				radioButton.click();
				//break;
			}
			else {
				continue;
			}
			break;
			
		}
		
	}
	
	
	//-----------------------For Bulk Renew----------------------
	
	
	public void renewPlaneInBulk() throws InterruptedException {
		if(renewPage.getText().equals("Renew Subscriptions")) {
			Assert.assertTrue(true);
			logger.info("user is going renew the plane in bulk");
			waitTillElementIsVisible(bulkRenew);
			bulkRenew.click();
			
			logger.info("user clicked on the bulk Button");
			
			//waitTillElementIsVisible(fileUpload);
			fileUpload.sendKeys(bulkFilePath);
			logger.info("File Uploaded successfully");
			waitTillElementIsVisible(upload);
			upload.click();
			
			
			logger.info("upload button clicked");
			
			waitTillElementIsVisible(uploadSuccess);
			if(uploadSuccess.getText().equals("Upload success")) {
				logger.info(uploadSuccess.getText());
				waitTillElementIsVisible(Renew);
				Renew.click();
				logger.info("user clicked on");
				Thread.sleep(10000);
				waitTillElementIsVisible(renewClose);
				renewClose.click();
				
				
			}else {
				logger.info("upload got failed due to"+uploadSuccess.getText());
				
			}
			
		}else {
			Assert.assertTrue(false);
			//put the code for the capture screen shot so that i will add the screen shot after the test case will get failed
				}
		
		
	}
	
	
	
	
	//----------------------------for the Single Renew----------------
      public void singleRenewPlane() throws InterruptedException {
		
		if(renewPage.getText().equals("Renew Subscriptions")) {
			Assert.assertTrue(true);
			logger.info("user is going to renew the plane singaly");
			
			String canForRenew=DemoExcelLibrary3.getexcelData("can.stb.smc", 1, 4, dataPath);
			waitTillElementIsVisible(enterCan);
			enterCan.sendKeys(canForRenew);
			logger.info("user enters "+canForRenew+" for renew");
			waitTillElementIsVisible(goBtn);
			goBtn.click();
			
			Thread.sleep(2000);
			clickRandomCheckBox();
			Thread.sleep(5000);
			
			logger.info("user checked the checkBox for renew the plane");
			waitTillElementIsVisible(confirmSelect);
			
			confirmSelect.click();
			waitTillElementIsVisible(subscriptionAmount);
			String subscriptionPrice=subscriptionAmount.getText();
			waitTillElementIsVisible(NCFPrice);
			String ncfPrice=NCFPrice.getText();
			waitTillElementIsVisible(tax);
			String Tax=tax.getText();
			waitTillElementIsVisible(totalPrice);
			String TotalPrice=totalPrice.getText();
			float TotalPrice_float=Utility.StringToFloat(TotalPrice);
			
			
			float cal_totalPrice =Utility.StringToFloat(ncfPrice)+Utility.StringToFloat(subscriptionPrice)+Utility.StringToFloat(Tax);
			
			logger.info("--------------------Renew Plane Discription----------------");
			
			waitTillElementIsVisible(planName);
			logger.info("plan name-"+planName.getText());
			waitTillElementIsVisible(expiryDate);
			logger.info("Expiry Date-"+expiryDate.getText());
			
			logger.info("subscrption Price-"+subscriptionPrice);
			logger.info("NCF Price-"+ncfPrice);
			logger.info("GST Tax-"+Tax);
			logger.info("TOTAL PRICE on portal-"+TotalPrice_float);
			
			logger.info("Total Price By calculation-"+cal_totalPrice);
			
			if(cal_totalPrice==TotalPrice_float) {
				logger.info("calculated price is exactly same with the portal price");
				
			}
			
			else {
				
				logger.warn("calculated price is not equal to portal price");
			}
		
			waitTillElementIsVisible(subscribeBtn);
			System.out.println("got");
			subscribeBtn.click();
		}
		
		
		
		
		else {
			
			logger.warn("user is not in RENES page");
			
			//write code for capture screen shots
			Assert.assertTrue(false);
			
		}
		
	}
		
}
