package mobiotics.lco.AddIndigitalPayBouquet;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.Utility;
import mobiotics.lco.commonPage.BasePage;
import mobiotics.lco.utilities.DemoExcelLibrary3;

public class AddIndigitalPayBuquetPage extends BasePage {
	
	public AddIndigitalPayBuquetPage() {
		PageFactory.initElements(driver, this);
	}
	
	static final Logger logger = Logger.getLogger(AddIndigitalPayBuquetPage.class);
	
	@FindBy(xpath="//h1[@class='pull-leftinput']")
	WebElement addIndigitanElement;
	
	@FindBy(xpath="//input[@placeholder='Enter CAN/STB/SMC']")//input[@placeholder='Enter CAN/SMC/STB']
	WebElement enterCan;
	
	@FindBy(id="subscriberid")
	WebElement goButton;
	
	@FindBy(xpath = "//input[@style='text-align:left']")
	private List<WebElement> radioBtnsToAddBasePack;

	@FindBy(id = "confirm-subscribe")
	private WebElement clickOnConfirmButtonToAddBasePack;
	
	@FindBy(xpath = "//tbody[@class='cart-table']//td[2]")
	private WebElement contentPrice;
	
	
	@FindBy(xpath = "//tbody[@class='cart-table']//td[3]")
	private WebElement NCFPrice;
	
	@FindBy(id = "confirmcart")
	private WebElement clickToSubscribeBasePack;
	
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
	
	
	@FindBy(xpath = "//*[@id=\"individual-progress\"]/tr/td[4]")
	private WebElement statusOfThePlan;
	
	@FindBy(xpath = "//*[@id=\"individual-progress\"]/tr/td[5]")
	private WebElement ReasonMsg;
	
	//To check the radio button
	
		private String xp1 = "(//input[@style='text-align:left'])[";

		private String xp2 = "]";
	
		
		 
		public void ranXpath(int num) {
			WebElement radioBtn=driver.findElement(By.xpath(xp1 + num + xp2));
			if(radioBtn.isEnabled()) {
				driver.findElement(By.xpath(xp1 + num + xp2)).click();
			}
			else {
				logger.info("the selected plan is not clickable");
			}
			
		}
	
	
		public int countNoOfIndigitalPackPresent() {
			return radioBtnsToAddBasePack.size();
		}
		
		private String dataPath="./ExcelPages/TestData.xlsx";
		
		public void  AddIndigitalPack_InBulk() {
			waitTillElementIsVisible(clickonbullkbutton);
			clickonbullkbutton.click();
			
			logger.info("I have clicked on bulk Button");
			
			choosefiletoUpload.sendKeys(System.getProperty("user.dir")+"/ExcelPages/bulkactivatetemplate (1).csv");
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
	
	//-------------------------Singal Add indigital Pay bouquet------------------
		
		
		public void singalAddIndigitalPayBouquet_Activation() {
			
			
			waitTillElementIsVisible(enterCan);
			String canForindigitalPack=DemoExcelLibrary3.getexcelData("can.stb.smc", 1, 1, dataPath);
			enterCan.sendKeys(canForindigitalPack); 
			
			logger.info("user inter the "+canForindigitalPack+" To add BasePack");
			waitTillElementIsVisible(goButton);
			goButton.click();
			
			/*
			if(clickOnConfirmButtonToAddBasePack.isEnabled()) {
				waitTillElementIsVisible(clickOnConfirmButtonToAddBasePack);
				clickOnConfirmButtonToAddBasePack.click();
				logger.info("User Click on the confirm button");
			}
			*/
			 {
				waitTillElementIsVisible(custName);
				System.out.println(custName.getText());
				logger.info("Customer Name-->"+custName);
				
				
				logger.info("Number of Indigital pack Available is available="+countNoOfIndigitalPackPresent());
				
					System.out.println(Utility.getRandomNumber(1, countNoOfIndigitalPackPresent()));
					int randomNO=Utility.getRandomNumber(1, countNoOfIndigitalPackPresent());
					System.out.println(Utility.getRandomNumber(1, countNoOfIndigitalPackPresent()));
					ranXpath(randomNO);
					waitTillElementIsVisible(clickOnConfirmButtonToAddBasePack);
					clickOnConfirmButtonToAddBasePack.click();
				
				
					logger.info("User Click on the confirm button");
					waitTillElementIsVisible(planName);
					System.out.println(" Product Name is " + planName.getText() + " Price Of The Plan "
							+ contentPrice.getText() + " Expiry Date Is On " );
					
					
					logger.info(" Product Name is " + planName.getText() + " Price Of The Plan "
							+ contentPrice.getText());
				

					clickToSubscribeBasePack.click();
			}
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
