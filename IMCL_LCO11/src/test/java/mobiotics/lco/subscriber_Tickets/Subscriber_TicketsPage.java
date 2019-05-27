package mobiotics.lco.subscriber_Tickets;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import generic.DateHelper;
import mobiotics.lco.commonPage.BasePage;
import mobiotics.lco.hardwareSTBReplacement.HardwareSTBReplacementPage;
import mobiotics.lco.utilities.DemoExcelLibrary3;

public class Subscriber_TicketsPage extends BasePage{
	
	private String path = "./ExcelPages/TestData.xlsx";
	private DateHelper dh = new DateHelper();
	
	public Subscriber_TicketsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	static final Logger logger = Logger.getLogger(Subscriber_TicketsPage.class);
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-calendar'])[1]")
	private WebElement fromDateCal;
	
	@FindBy(id = "refresh")
	private WebElement dateGoBtn;
	
	
	@FindBy(name = "ticketid")
	private WebElement ticketIdTxFld;
	
	@FindBy(xpath = "//input[@name='ticketid']/following-sibling::button")
	private WebElement ticketIdGoBtn;
	
	@FindBy(name = "customerno")
	private WebElement customerNoTxtFld;
	
	@FindBy(xpath = "//input[@name='customerno']/following-sibling::button")
	private WebElement customerNoGoBtn;
	
	@FindBy(id = "status")
	private WebElement ticketStatus;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[1]")
	private WebElement ticketIdText;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[5]")
	private WebElement customerNoDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[6]")
	private WebElement ticketStatusDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[contains(text(),'No Tickets')]")
	private WebElement noTicketsMsg;
	
	public void selectDates(String date, String month)
	{
		fromDateCal.click();
		dh.selectDate(date);
		dh.selectMonth(month);
		dateGoBtn.click();
	}
	
	public void searchByTicketId(String ticketId)
	{
		ticketIdTxFld.sendKeys(ticketId);
		ticketIdGoBtn.click();
	}
	
	public void searchByCustomerNo(String customerNo)
	{
		customerNoTxtFld.sendKeys(customerNo);
		customerNoGoBtn.click();
	}
	
	public void searchByStatus(String status)
	{
		Select statusList = new Select(ticketStatus);
		statusList.deselectByVisibleText(status);
	}
	
	public void testTickets() throws InterruptedException
	{
		selectDates("01", "01");
		Thread.sleep(2000);
		try {
			logger.info(noTicketsMsg.getText()+" for the selected dates.");
		}
		catch (Exception e) {
			
			String customerNo = DemoExcelLibrary3.getexcelData("can.stb.smc", 1, 14, path);
			searchByCustomerNo(customerNo);
			Assert.assertEquals(customerNoDisplaying.getText(), customerNo, "Entered customer number and customer no. displaying are not same");
			Thread.sleep(2000);
			String ticketId = ticketIdText.getText();
			String ticketStatusText = ticketStatusDisplaying.getText();
			customerNoTxtFld.clear();
			searchByTicketId(ticketId);
			Assert.assertEquals(ticketIdText.getText(), ticketId, "Entered ticket Id and displaying Ticket ids are not same");
			ticketIdTxFld.clear();
			
			searchByStatus(ticketStatusText);
			Thread.sleep(2000);
			Assert.assertEquals(ticketStatusDisplaying.getText(), ticketStatusText, "Selected Ticket status and displaying Ticket status are not same");
			
			Thread.sleep(3000);
			searchByCustomerNo(customerNo);
			searchByTicketId(ticketId);
			searchByStatus(ticketStatusText);
			Thread.sleep(3000);
			Assert.assertEquals(customerNoDisplaying.getText(), customerNo, "Entered customer number and customer no. displaying are not same");
			Assert.assertEquals(ticketIdText.getText(), ticketId, "Entered ticket Id and displaying Ticket ids are not same");
			Assert.assertEquals(ticketStatusDisplaying.getText(), ticketStatusText, "Selected Ticket status and displaying Ticket status are not same");
			logger.info("Test Case for Subscriber_Tickets is passed");
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
