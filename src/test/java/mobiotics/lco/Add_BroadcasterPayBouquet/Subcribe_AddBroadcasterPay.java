package mobiotics.lco.Add_BroadcasterPayBouquet;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.Utility;
import mobiotics.lco.commonPage.BasePage;
import mobiotics.lco.utilities.DemoExcelLibrary3;

public class Subcribe_AddBroadcasterPay extends BasePage {
	
	public Subcribe_AddBroadcasterPay() {
		PageFactory.initElements(driver, this);
	}
	

	static final Logger logger = Logger.getLogger(Subcribe_AddBroadcasterPay.class);
	
	@FindBy(xpath="//h1[@class='pull-leftinput']")
	private WebElement addBroadCaster;
	
	@FindBy(xpath="//input[@placeholder='Enter CAN/STB/SMC']")//input[@placeholder='Enter CAN/SMC/STB']
	private WebElement enterCan;
	
	@FindBy(id="subscriberid")
	private WebElement goButton;
	
	@FindBy(xpath = "//input[@style='text-align:center']")
	private List<WebElement> radioBtnsToAddBasePack;
	
	@FindBy(id = "confirm-subscribe")
	private WebElement clickOnConfirmBroadcasterPack;
	
	
	@FindBy(xpath = "//tbody[@class='cart-table']//td[2]")
	private WebElement contentPrice;
	
	@FindBy(xpath = "//tbody[@class='cart-table']//td[3]")
	private WebElement expiryDate;
	
	@FindBy(id = "confirmcart")
	private WebElement clickToSubscribeBroadcasterPack;
	
	@FindBy(id = "bulkmodalsubscribe")
	private WebElement clickonbullkbutton;
	
	@FindBy(xpath = "//input[@type='file']")
	private WebElement choosefiletoUpload;
	
	@FindBy(id = "upload")
	private WebElement uploadButton;
	
	
	@FindBy(xpath = "//label[@class='upload-status text-success']")
	private WebElement uploadsuccess;
	
	@FindBy(xpath = "//button[@class='btn btn-danger create']")
	private WebElement ActivateButton;
	
	@FindBy(id = "add-basepack-close")
	private WebElement closeButton; 
	
	@FindBy(xpath = "//h4[@class='customername']")
	private WebElement custName;
	
	@FindBy(xpath = "//tbody[@class='cart-table']//td[1]")
	private WebElement planName;
	
	private String xp1="(//input[@style='text-align:center'])[";
	
	private String xp2 = "]";
	
	
	public void ranXpath(int num) {
		if(driver.findElement(By.xpath(xp1+num+xp2)).isEnabled()) {
			driver.findElement(By.xpath(xp1 + num + xp2)).click();
		}
		else {
			logger.info(num+" index is not present");
		}
		
	}
	
	
	public int countNoOfBroadcasterPackPresent() {
		return radioBtnsToAddBasePack.size();
	}
	
	private String dataPath="./ExcelPages/TestData.xlsx";
	
	public void addBroadcasterPack_Bulk() {
		waitTillElementIsVisible(clickonbullkbutton);
		clickonbullkbutton.click();
		
		logger.info("I have clicked on bulk Button");
		
		choosefiletoUpload.sendKeys(System.getProperty("user.dir")+"/ExcelPages/bulkactivatetemplate for Add Broadcaster.csv");
		logger.info("I have uploded the Bulk file");
		
		waitTillElementIsVisible(uploadButton);
		uploadButton.click();
		
		logger.info("about to click on the submit button");
		waitTillElementIsVisible(uploadsuccess);
		
		logger.info(uploadsuccess.getText());
		System.out.println(uploadsuccess.getText());
		
		if (uploadsuccess.getText().contentEquals("Upload success")) {
		
			waitTillElementIsVisible(ActivateButton);
			//Thread.sleep(5000);
			ActivateButton.click();
			logger.info("clicked on submit button");
			
			waitTillElementIsVisible(closeButton);
			closeButton.click();
			
		}
		
	
	}
	
	
	//-----------------------------Singal add broadcaster pack-------------
	
	public void singalAddBroadcasterPack() {
		waitTillElementIsVisible(enterCan);
		String canFor_broadcasterPack=DemoExcelLibrary3.getexcelData("can.stb.smc", 1, 1, dataPath);
		enterCan.sendKeys(canFor_broadcasterPack);
		
		logger.info("user inter the "+canFor_broadcasterPack+" To add BasePack");
		waitTillElementIsVisible(goButton);
		goButton.click();
		
		waitTillElementIsVisible(custName);
		System.out.println(custName.getText());
		logger.info("Customer Name-->"+custName);
		
		logger.info("Number of Broadcaster pack Available is available="+countNoOfBroadcasterPackPresent());
		int RandomNo=Utility.getRandomNumber(1, countNoOfBroadcasterPackPresent());
		System.out.println(RandomNo);
		
		ranXpath(RandomNo);
		waitTillElementIsVisible(clickOnConfirmBroadcasterPack);
		clickOnConfirmBroadcasterPack.click();
		
		logger.info("User Click on the confirm button");
		waitTillElementIsVisible(planName);
		System.out.println(" Product Name is " + planName.getText() + " Price Of The Plan "
				+ contentPrice.getText() + " Expiry Date Is On " );
		
		
		logger.info(" Product Name is " + planName.getText() + " Price Of The Plan "
				+ contentPrice.getText());
		
		clickToSubscribeBroadcasterPack.click();

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
