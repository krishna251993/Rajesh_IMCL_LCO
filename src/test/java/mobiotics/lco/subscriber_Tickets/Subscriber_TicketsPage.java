package mobiotics.lco.subscriber_Tickets;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import generic.DateHelper2;
import mobiotics.lco.commonPage.BasePage;

import mobiotics.lco.utilities.DemoExcelLibrary3;

public class Subscriber_TicketsPage extends BasePage{
	
	//in live---private String dateXp1 = "/html/body/div[4]/div[1]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[";
	private String dateXp1 = "/html/body/div[5]/div[1]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[";
	private String dateXp2 = "]/td[";
	
	private String path = "./ExcelPages/TestData.xlsx";
	private DateHelper2 dh = new DateHelper2();
	
	public Subscriber_TicketsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	static final Logger logger = Logger.getLogger(Subscriber_TicketsPage.class);
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-calendar'])[1]")
	private WebElement fromDateCal;
	
	@FindBy(xpath = "(//a[@class='previous']/following-sibling::span)[1]")
	private WebElement currentMonthFrom;
	
	@FindBy(id = "refresh")
	private WebElement dateGoBtn;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-left'])[1]")
	private WebElement previousMonthFrom;
	
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
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]")
	private WebElement firstRow;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[last()]/button")
	private WebElement closeButton;
	
	@FindBy(xpath = "//button[@class='btn btn-danger yes']")
	private WebElement yesBtnPopup;
	
	public void selectDates(String fromDate) throws InterruptedException
	{
		waitTillElementIsClickable(fromDateCal);
		fromDateCal.click();
		Thread.sleep(3000);
		String dateArr[] = fromDate.split("/");
		dh.selectMonth(previousMonthFrom, previousMonthFrom, currentMonthFrom.getText(), Integer.parseInt(dateArr[1]));
		Thread.sleep(3000);
		dh.selectDate(dateXp1, dateXp2, Integer.parseInt(dateArr[2]));
		waitTillElementIsClickable(dateGoBtn);
		dateGoBtn.click();
	}
	
	public void searchByTicketId(String ticketId)
	{
		waitTillElementIsVisible(ticketIdTxFld);
		ticketIdTxFld.sendKeys(ticketId);
		waitTillElementIsClickable(ticketIdGoBtn);
		ticketIdGoBtn.click();
	}
	
	public void searchByCustomerNo(String customerNo)
	{
		waitTillElementIsVisible(customerNoTxtFld);
		customerNoTxtFld.sendKeys(customerNo);
		waitTillElementIsClickable(customerNoGoBtn);
		customerNoGoBtn.click();
	}
	
	public void searchByStatus(String status)
	{
		waitTillElementIsVisible(ticketStatus);
		Select statusList = new Select(ticketStatus);
		statusList.selectByVisibleText(status);
	}
	
	public void testTickets() throws InterruptedException
	{
		selectDates("2019/04/01");
		Thread.sleep(2000);
		
		String firstRowData = firstRow.getText();
		if(firstRowData.contains("No Tickets"))
		{
			logger.info(firstRowData);
			return;
		}
		
		String customerNo = DemoExcelLibrary3.getexcelData("can.stb.smc", 1, 14, path);
		searchByCustomerNo(customerNo);
		Thread.sleep(4000);
		waitTillElementIsClickable(firstRow);
		if(firstRowData.contains("No Tickets"))
		{
			logger.info(firstRowData);
			return;
		}
		Assert.assertEquals(customerNoDisplaying.getText(), customerNo, "Entered customer number and customer no. displaying are not same");
		String ticketId = ticketIdText.getText();
		String ticketStatusText = ticketStatusDisplaying.getText();
		customerNoTxtFld.clear();
		searchByTicketId(ticketId);
		waitTillElementIsVisible(firstRow);
		Assert.assertEquals(ticketIdText.getText(), ticketId, "Entered ticket Id and displaying Ticket ids are not same");
		ticketIdTxFld.clear();
		searchByStatus(ticketStatusText);
		Thread.sleep(2000);
		waitTillElementIsVisible(firstRow);
		Assert.assertEquals(ticketStatusDisplaying.getText(), ticketStatusText, "Selected Ticket status and displaying Ticket status are not same");
		
		searchByTicketId(ticketId);
		Thread.sleep(2000);
		if(ticketStatusDisplaying.getText().equalsIgnoreCase("NEW"))
		{
			closeButton.click();
			waitTillElementIsClickable(yesBtnPopup);
			yesBtnPopup.click();
			Thread.sleep(2000);
			waitTillElementIsVisible(customerNoTxtFld);
			searchByCustomerNo(customerNo);
			Thread.sleep(2000);
			ticketStatusText = ticketStatusDisplaying.getText();
			Assert.assertEquals(ticketStatusText, "CLOSED", "Ticket is not closed successfully");
			
		}
		
		else
		{
			logger.info("Ticket Status is: "+ticketStatusText);
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
