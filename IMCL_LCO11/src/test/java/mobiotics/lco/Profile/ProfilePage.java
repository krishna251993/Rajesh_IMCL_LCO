package mobiotics.lco.Profile;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import mobiotics.lco.commonPage.BasePage;
import mobiotics.lco.modifyCustomer.Subscriber_ModifyCustomerPage;

public class ProfilePage extends BasePage{
	
	private String path = "./ExcelPages/TestData.xlsx";
	
	public ProfilePage()
	{
		PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(ProfilePage.class);
	
	@FindBy(xpath = "//h1[text()='LCO Detail']")
	private WebElement pageTitle;
	
	@FindBy(name = "email")
	private WebElement emailTxtFld;
	
	@FindBy(name = "mobileno")
	private WebElement mobileNoRTxtFld;
	
	@FindBy(name = "gstno")
	private WebElement gstNoTxtFld;
	
	@FindBy(id = "panno")
	private WebElement pannoTxtFld;
	
	@FindBy(xpath = "//a[text()='Change password']")
	private WebElement changePasswordLink;
	
	@FindBy(id = "oldpassword")
	private WebElement oldPasswordTxtFld;
	
	@FindBy(id = "newpassword")
	private WebElement newPasswordTxtFld;
	
	@FindBy(xpath = "//input[@value='Update']")
	private WebElement updateBtn;
	
	@FindBy(xpath = "(//div[@class='alert alert-success top-success text-center fixed-top'])[2]")
	private WebElement successMsg;
	
	@FindBy(xpath = "(//div[@class='alert alert-danger top-error text-center fixed-top'])[2]")
	private WebElement alertMsg;
	
	@FindBy(xpath = "//a[text()='Cancel']")
	private WebElement cancelLink;
	
	
	public void updateLCOProfile()
	{
		Assert.assertEquals(pageTitle.isDisplayed(), true, "This is not the correct Page");
		emailTxtFld.clear();
		emailTxtFld.sendKeys("abc@mobiotics.com");
		mobileNoRTxtFld.clear();
		mobileNoRTxtFld.sendKeys("8947988775");
		gstNoTxtFld.clear();
		gstNoTxtFld.sendKeys("123456789012345");
//		pannoTxtFld.clear();
//		pannoTxtFld.sendKeys("AXX456");
//		changePasswordLink.click();
//		Assert.assertEquals(oldPasswordTxtFld.isDisplayed(), true, "Not displaying Old password Text Field");
//		Assert.assertEquals(newPasswordTxtFld.isDisplayed(), true, "Not displaying New Password Text Fields");
		updateBtn.click();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
