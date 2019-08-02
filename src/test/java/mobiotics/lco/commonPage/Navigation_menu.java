package mobiotics.lco.commonPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Navigation_menu extends BasePage {
	public Navigation_menu() {
		PageFactory.initElements(driver, this);
		
	}
	
	//---------------------This is the Dashboard Menu------------------------
	
	
	@FindBy(partialLinkText="Summary Panel")
	public WebElement summeryPanel;
	
	@FindBy(partialLinkText="Notification")
	public WebElement Notification;
	
	//-----------------------------This is Subscribe -------------------------
	
	
	@FindBy(partialLinkText="Add Base Pack")
	public WebElement subscribe_AddBasePack;
	
	@FindBy(partialLinkText="Add Indigital Pay Bouquet")
	public WebElement subscribe_AddIndigital_Pay;
	
	@FindBy(xpath="//a[@href='lcoaddbroadcaster']")
	public WebElement subscribe_AddBroadcaster;
	
	@FindBy(partialLinkText="Add A-la-carte")
	public WebElement subscribe_AddALaCarte;
	
	//--------------------------------------This is Renew-----------------------------------------
	
	@FindBy(partialLinkText="Renew Plans")
	public WebElement renew_RenewPlans;
	
	@FindBy(partialLinkText="Schedule Auto Renew")
	public WebElement sechdule_AutoRenew;
	
	//-----------This is Plans----------------
	
	@FindBy(partialLinkText="Disconnect")
	public WebElement plans_Disconnect;
	
	@FindBy(partialLinkText="Reconnect")
	public WebElement plans_Reconnect;
	
	@FindBy(partialLinkText="Change Base Pack")
	public WebElement plans_ChangeBasePack;
	
	
	
	//----------------------------------This is the credit module------------------------------------------
	
	
	
	
	
	
	
	@FindBy(partialLinkText="Add Credit")
	public WebElement credit_AddCredit;
	
		
	
	//---------------------------------Report--------------------------------------------------------------
	@FindBy(partialLinkText="Activation Report")
	public WebElement Report_ActivationReport;
	
	@FindBy(partialLinkText="Expiry Report")
	public WebElement Report_ExpiryReport;
	
	@FindBy(partialLinkText = "Payment Report")
	public WebElement report_PaymentReport;
	
	@FindBy(xpath = "//a[text()='STB Replacement Report']")
	public WebElement STBReplacementReport;
	
	
	@FindBy(partialLinkText="Expired Report")
	WebElement Report_ExpiredReport;
	
	@FindBy(partialLinkText="Job Report")
	WebElement Report_Job_Report;
	
	@FindBy(partialLinkText="Bills")
	public WebElement Report_Bills;
	
	@FindBy(partialLinkText="Refund Report")
	public WebElement Report_RefundReport;
	
	@FindBy(partialLinkText="Ekyc Report")
	public WebElement Report_EKycReport;
	
	//-----------------------------------------------Hardware--------------------------------------------------------------
	
	@FindBy(partialLinkText="Retrack")
	public WebElement hardware_Retrack;
	
	@FindBy(partialLinkText="STB Replacement")
	public WebElement hardware_STBReplacement;
	
	//-------------------------------------------Subscriber---------------------------------------------------------------------
	
	@FindBy(partialLinkText="Modify Customer")
	public WebElement subscriber_modifyCustomer;
	
	@FindBy(partialLinkText="Subscriber Corner")
	public WebElement subscriber_SubscriberCorner;
	
	@FindBy(partialLinkText="Tickets")
	public WebElement subscriber_Tickets;
	
	@FindBy(partialLinkText="Customer Selection")
	public WebElement subscriber_CustomerSelection;
	
	@FindBy(partialLinkText="Refund Request")
	public WebElement subscriber_RefundRequest;
	
	
	//------------------------------------------------Download---------------------------------------------------------------------
	
	
	@FindBy(partialLinkText="GST")
	public WebElement download_GST;
	
	
		@FindBy(partialLinkText="GST FAQ")
		public WebElement download_GSTFaq;
		
		@FindBy(partialLinkText="Axis Bank Easy Pay Slip")
		public WebElement download_AxisBank;
		
		@FindBy(partialLinkText="LCO Portal User Guide")
		public WebElement download_lcoportalGuide;
		
		
		@FindBy(partialLinkText="MIB Letter")
		public WebElement download_MIBLetter;
		
		@FindBy(partialLinkText="MIB Advisory")
		public WebElement download_MibAdvisor;
		
		@FindBy(partialLinkText="Axis Bank Branch Deatils")
		public WebElement download_AxisBankBrachDetails;
		
	
		@FindBy(partialLinkText="Third Party Deposit Authorization")
		public WebElement download_ThirdParty;
		
		@FindBy(partialLinkText="Bank Authorization Annexure")
		public WebElement download_Authrozitation;
		
		@FindBy(partialLinkText="Axis EasyPay Circular")
		public WebElement download_AxiseasyPaySlip;
		
		@FindBy(partialLinkText="OSD Consent Letter")
		public WebElement download_OSDConstant;
	
		
		

}
