package mobiotics.lco.commonPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mobiotics.lco.AddIndigitalPayBouquet.AddIndigitalPayBuquetPage;
import mobiotics.lco.Add_BroadcasterPayBouquet.Subcribe_AddBroadcasterPay;
import mobiotics.lco.ExpiryReport_Page.ExpiryReportPage;
import mobiotics.lco.Hardware_Retrack.Hardware_RetrackPage;
import mobiotics.lco.Plans_Reconnect.Plans_ReconnectPageForLive;
import mobiotics.lco.Profile.ProfilePage;
import mobiotics.lco.RenewPlanePage.RenewPage;

import mobiotics.lco.Report_ActivationReportPage.ActivationReportPage;
import mobiotics.lco.Report_BillsPage.Report_BillsPage;
import mobiotics.lco.Report_EKYCReportPage.Report_EKYCReportPage;
import mobiotics.lco.Report_ExpiryReportPage.Report_ExpiredReportPage;
import mobiotics.lco.Report_PaymentReportPage.Report_PaymentReportPage;
import mobiotics.lco.Report_RefundReport.Report_RefundReportPage;
import mobiotics.lco.Report_STBReplacementReport.Report_STBReplacementReportPage;
import mobiotics.lco.Subscribe_Add_BasePack.Subscribe_AddBasePage;
import mobiotics.lco.Subscriber_Ala_Carte_Page.Subscriber_Ala_Carte_Page;
import mobiotics.lco.Subscriber_Refund_Request.RefundRequestPage;
import mobiotics.lco.Subscribers_CustomerSelection.Subscribers_CustomerSelectionPage;
import mobiotics.lco.TestAutoRenewFeaturePage.AutoRenewPage;
import mobiotics.lco.changeBase_Pack.Plans_ChangeBasePack;
import mobiotics.lco.hardwareSTBReplacement.HardwareSTBReplacementPage;
import mobiotics.lco.modifyCustomer.Subscriber_ModifyCustomerPage;

import mobiotics.lco.subscriber_Tickets.Subscriber_TicketsPage;
import mobiotics.lcoAlertMsgPage.DashBoard_AlertMsgPage;
import mobitics.lco.Plans_Disconnect.Plans_DisconnectPageForLive;

public class HomePage extends Navigation_menu {
	
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[@class='dropdown-toggle' and text()='Dashboard ']")
	private WebElement dashboardMenu;
	
	@FindBy(xpath="//a[@class='dropdown-toggle' and text()='Subscribe  ']")
	private WebElement subscribeMenu;
	
	@FindBy(xpath="//a[@class='dropdown-toggle' and text()='Renew  ']")
	private WebElement renewMenu;
	
	@FindBy(xpath="//a[text()='Plans']")
	private WebElement plansMenu;
	
	@FindBy(partialLinkText="Credit  ")
	private WebElement creditMenu;
	
	@FindBy(xpath="//a[text()='Report  ']")
	private WebElement reportMenu;
	
	@FindBy(xpath="//a[text()='Hardware ']")
	private WebElement hardwareMenu;
	
	@FindBy(xpath="//a[text()='Subscriber ']")
	private WebElement subscriberMenu;
	
	@FindBy(xpath="//a[text()='Download ']")
	private WebElement DownloadMenu;

	@FindBy(xpath = "//a[text()='Profile']")
	private WebElement profile;
	
	@FindBy(xpath = "//a[text()='logout']")
	private WebElement logout;
	
	
	
	
	//---------------This is Dash-Bord menu---------------------------------------
	public void nevigateToDashBoard_DashBoard() {
		dashboardMenu.click();
	}
	
	//-----------------------------------This is Alert Msg Verification -----------------------
	public DashBoard_AlertMsgPage navigateToAlert_MsgPage() {
		dashboardMenu.click();
		waitTillElementIsVisible(Notification);
		Notification.click();
		
		return new DashBoard_AlertMsgPage();
	}
	

	//---------------------This is for Add Base pack-----------------------------------
	
	public Subscribe_AddBasePage navigateToSubscriber_AddBasePage()
	{
		subscribeMenu.click();// here we need to modified in the code
		waitTillElementIsVisible(subscribe_AddBasePack);
		subscribe_AddBasePack.click();
		return new Subscribe_AddBasePage();
	}
	
	//---------------------This is the Payment_menu PayForBox--------------------------------
	public AddIndigitalPayBuquetPage navigateToIndigitalPage() {
		subscribeMenu.click();
		waitTillElementIsVisible(subscribe_AddIndigital_Pay);
		subscribe_AddIndigital_Pay.click();
		return new AddIndigitalPayBuquetPage();
	}
	
	//---------------------This is for the AddBroadcaster Pay--------------------
	
	
	public Subcribe_AddBroadcasterPay navigateToSubscribe_Broadcaster() {
		subscribeMenu.click();
		waitTillElementIsVisible(subscribe_AddBroadcaster);
		subscribe_AddBroadcaster.click();
		return new Subcribe_AddBroadcasterPay();
		
	}
	
	//--------------------------This is to navigate to Ala-Carte page-----------------------
	
	public Subscriber_Ala_Carte_Page navigateToSubscriber_AlaCarte() {
		subscribeMenu.click();
		waitTillElementIsVisible(subscribe_AddALaCarte);
		subscribe_AddALaCarte.click();
		return new Subscriber_Ala_Carte_Page();
	}
	
	//--------------------Thius is Renew Plan-------------------
	
	public RenewPage navigateToRenewPage() {
		waitTillElementIsVisible(renewMenu);
		renewMenu.click();
		waitTillElementIsVisible(renew_RenewPlans);
		renew_RenewPlans.click();
		return new RenewPage();
	}
	
	//---------------------This is Auto-Renew---------------------
	
	public AutoRenewPage navigateToAutoRenewPage() {
		waitTillElementIsVisible(renewMenu);
		renewMenu.click();
		
		waitTillElementIsVisible(sechdule_AutoRenew);
		sechdule_AutoRenew.click();
		return new AutoRenewPage();
		
	}
	
	//------------------This is Disconnect Page------------------
	
	public Plans_DisconnectPageForLive navigateToPlans_DisconnectPage() {
		plansMenu.click();
		waitTillElementIsVisible(plans_Disconnect);
		plans_Disconnect.click();
		return new Plans_DisconnectPageForLive();
	}
	
	//----------------This page is navigate to reconnect in live--------------------
	
	public Plans_ReconnectPageForLive navigateToPlansReconnectLive()
	{
		plansMenu.click();
		waitTillElementIsVisible(plans_Reconnect);
		plans_Reconnect.click();
		return new Plans_ReconnectPageForLive();
		
		
		
	}
	
	
	//------------------This is the Change Base Pack------------------
	
	
	public Plans_ChangeBasePack navigateToChangeBasePack() {
	
		plansMenu.click();
		waitTillElementIsVisible(plans_ChangeBasePack);
		plans_ChangeBasePack.click();
		return new Plans_ChangeBasePack();
		
	}
	
	//--------------------This is the Hardware Retrack Services-----------
	
	public Hardware_RetrackPage navigateToRetrackServicesPage()
	{
		hardwareMenu.click();
		waitTillElementIsVisible(hardware_Retrack);
		hardware_Retrack.click();
		return new Hardware_RetrackPage();
	}
	
	//----------------------This is STB Replacement---------------------------
	
	public HardwareSTBReplacementPage navigateToSTBReplacement()
	{
		waitTillElementIsVisible(hardwareMenu);
		hardwareMenu.click();
		waitTillElementIsVisible(hardware_STBReplacement);
		hardware_STBReplacement.click();
		return new HardwareSTBReplacementPage();
	}
	
	//----------------This is Modify Customer-------------
	public Subscriber_ModifyCustomerPage navigateToModifyCustomer()
	{
		waitTillElementIsVisible(subscriberMenu);
		subscriberMenu.click();
		waitTillElementIsVisible(subscriber_modifyCustomer);
		subscriber_modifyCustomer.click();
		return new Subscriber_ModifyCustomerPage();
	}
	
	//-------------------This is Subscriber > Tickets----------
	public Subscriber_TicketsPage navigateToTicketsPage()
	{
		waitTillElementIsVisible(subscriberMenu);
		subscriberMenu.click();
		waitTillElementIsVisible(subscriber_Tickets);
		subscriber_Tickets.click();
		return new Subscriber_TicketsPage();
	}
	
	//------------------This is Subscriber > Customer Selection-----------
	public Subscribers_CustomerSelectionPage navigateToCustomerSelectionPage()
	{
		waitTillElementIsVisible(subscriberMenu);
		subscriberMenu.click();
		waitTillElementIsVisible(subscriber_CustomerSelection);
		subscriber_CustomerSelection.click();
		return new Subscribers_CustomerSelectionPage();
	}
	
	//--------------------This is Profile-------------
	public ProfilePage navigateToProfilePage()
	{
		waitTillElementIsVisible(profile);
		profile.click();
		return new ProfilePage();
	}
	
	
	//----------------------This Logout----------------
	public void logout()
	{
		logout.click();
	}
	
	//---------------------------This is to navigate to Report>Refund Report------------
		public Report_RefundReportPage navigateToRefundReportPage()
		{
			reportMenu.click();
			Report_RefundReport.click();
			return new Report_RefundReportPage();
		}
		
		//--------------------------This is to navigate to Report_ActivationReport--------------------
		public ActivationReportPage navigateToActivationReport()
		{
			reportMenu.click();
			waitTillElementIsVisible(Report_ActivationReport);
			Report_ActivationReport.click();
			return new ActivationReportPage();
		}	
	
	
		//----------------------------This is to navigate to Report>Bills page------------
		public Report_BillsPage navigateToBillsPage()
		{
			reportMenu.click();
			waitTillElementIsVisible(Report_Bills);
			Report_Bills.click();
			return new Report_BillsPage();
		}
		
		
		//-------------------------This is to navigate to Report > EKYC Report-------------
		public Report_EKYCReportPage navigateToEKYCReportPage()
		{
			reportMenu.click();
			Report_EKycReport.click();
			return new Report_EKYCReportPage();
		}

		//------------------------This is to navaigate to the Report_ExpiresReport--------------------
		public Report_ExpiredReportPage navigateToExpiredReport()
		{
			reportMenu.click();
			waitTillElementIsVisible(Report_ExpiredReport);
			Report_ExpiredReport.click();
			return new Report_ExpiredReportPage();
		}
	
	
	
		//--------------------------This is to navaigate to the Report_ExpiryReport-------------------
		public ExpiryReportPage navigateToExpiryReport()
		{
			reportMenu.click();
			waitTillElementIsVisible(Report_ExpiryReport);
			Report_ExpiryReport.click();
			return new ExpiryReportPage();
		}
	
	
		//--------------------------This is to navigate to Report > Payment Report page-----------
		
		public Report_PaymentReportPage navigateToPaymentReportPage()
		{
			reportMenu.click();
			report_PaymentReport.click();
			return new Report_PaymentReportPage();
		}
		
		//------------------This is to navigate to Report > STB Replacement report Page---------------
		public Report_STBReplacementReportPage navigateToSTBReplacementreportPage()
		{
			waitTillElementIsClickable(reportMenu);
			reportMenu.click();
			waitTillElementIsClickable(STBReplacementReport);
			STBReplacementReport.click();
			return new Report_STBReplacementReportPage();
		}
		
		
		//-------------------------this is for the subscriber_Refund Request---------------------------------
		
		
		public RefundRequestPage navigateToRefundRequest()
		{
		waitTillElementIsClickable(subscriberMenu);
		subscriberMenu.click();
		waitTillElementIsVisible(subscriberMenu);
		subscriber_RefundRequest.click();
		return new RefundRequestPage();
		}
		
		
		//----------------------------Code Has Done==-----------
		
	
	
	
	
}
