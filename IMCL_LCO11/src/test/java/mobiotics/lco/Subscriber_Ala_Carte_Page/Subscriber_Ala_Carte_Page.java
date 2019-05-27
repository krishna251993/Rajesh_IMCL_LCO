package mobiotics.lco.Subscriber_Ala_Carte_Page;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generic.Utility;
import mobiotics.lco.commonPage.BasePage;
import mobiotics.lco.utilities.DemoExcelLibrary3;

public class Subscriber_Ala_Carte_Page extends BasePage {
	
	public Subscriber_Ala_Carte_Page() {
		PageFactory.initElements(driver, this);
	}
	
	static final Logger logger = Logger.getLogger(Subscriber_Ala_Carte_Page.class);

	@FindBy(xpath="//h1[@class='pull-leftinput']")
	WebElement alacarte_PackPackElement;
	
	@FindBy(xpath="//input[@placeholder='Enter CAN/STB/SMC']")//input[@placeholder='Enter CAN/SMC/STB']
	WebElement enterCan;
	
	@FindBy(id="subscriberid")
	WebElement goButton;
	
	@FindBy(xpath = "//input[@style='text-align:center']")
	private List<WebElement> radioBtnsToAddBasePack;

	@FindBy(id = "confirm-subscribe")
	private WebElement clickOnConfirmButtonToAddBasePack;
	
	@FindBy(xpath = "//tbody[@class='cart-table']//td[2]")
	private WebElement price;
	
	@FindBy(xpath = "//tbody[@class='cart-table']//td[3]")
	private WebElement ExpiryDate;
	
	@FindBy(id = "confirmcart")
	private WebElement clickToSubscribeAla_CartePack;
	
		
	@FindBy(xpath = "//button[@class='btn btn-danger create']")
	private WebElement ActivateButton;
	
	
	@FindBy(id = "add-basepack-close")
	private WebElement closeButton; 
	
	@FindBy(xpath = "//h4[@class='customername']")
	private WebElement custName;
	
	@FindBy(xpath = "//tbody[@class='cart-table']//td[1]")
	private WebElement planName;
	
	private String xp1 = "(//input[@type='checkbox'])[";

	private String xp2 = "]";	

	public void ranXpath(int num) {
		
		if(driver.findElement(By.xpath(xp1+num+xp2)).isEnabled()) {
			driver.findElement(By.xpath(xp1 + num + xp2)).click();
		}
		else {
			logger.info("The selected Ala-A-Carte pack is disabled");
		}
		
	}
	
	public int countNoOfAla_CaortePackPresent() {
		return radioBtnsToAddBasePack.size();
	}
	
	private String dataPath="./ExcelPages/TestData.xlsx";
	
	
	
	//---------------------------Singal  Add_Ala_Carte pack----------------------------------
	
	
	public void singalAdd_AlaCarte_Pack() {
		
		waitTillElementIsVisible(alacarte_PackPackElement);
		if(alacarte_PackPackElement.getText().equals("Add Ala-Carte")) {
			Assert.assertTrue(true);
			waitTillElementIsVisible(enterCan);
			String canFor_AlaCartePack=DemoExcelLibrary3.getexcelData("can.stb.smc", 1, 3, dataPath);			
			enterCan.sendKeys(canFor_AlaCartePack);
			waitTillElementIsClickable(goButton);
			goButton.click();
			
//			waitTillElementIsVisible(custName);
//			System.out.println(custName.getText());
//			logger.info("Customer Name-->"+custName);
//			
			logger.info("Number of A-la-carte available are ="+countNoOfAla_CaortePackPresent());
			
			int randomNum=Utility.getRandomNumber(1, countNoOfAla_CaortePackPresent());
	        System.out.println("Number of Ala-A-Carte Pack available="+randomNum);
	        
	        logger.info("Number of Ala-A-Carte pack is available-"+countNoOfAla_CaortePackPresent());
	        
	        ranXpath(randomNum);
			waitTillElementIsVisible(clickOnConfirmButtonToAddBasePack);
			clickOnConfirmButtonToAddBasePack.click();
			logger.info("User Click on the confirm button");
			
			waitTillElementIsVisible(planName);
			System.out.println(" Product Name is " + planName.getText() + " Price Of The Plan "
					+  " Expiry Date Is On "+ExpiryDate.getText() );
			
			
			logger.info(" Product Name is " + planName.getText() + 
					 " Expiry Date Is On "+ExpiryDate.getText());
			
			clickToSubscribeAla_CartePack.click();

		}
		
		else {
			Assert.assertTrue(false);
		}
		
				
	}
	
	
}
