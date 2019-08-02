package mobiotics.lco.Subscriber_Refund_Request;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generic.DateHelper2;
import mobiotics.lco.commonPage.BasePage;
import mobiotics.lco.utilities.DemoExcelLibrary3;

public class RefundRequestPage extends BasePage{
	
	
	
	private String path = "./ExcelPages/TestData.xlsx";
	DateHelper2 dh = new DateHelper2();
	public RefundRequestPage()
	{
	PageFactory.initElements(driver, this);
	}

	static final Logger logger = Logger.getLogger(RefundRequestPage.class);

	private String packStartDateXp1 = "//*[@id='start_date']/div[2]/table/tbody/tr[";
	private String packStartDateXp2 = "]/td[";

	private String packEndDateXp1 = "//*[@id='end_date\']/div[2]/table/tbody/tr[";
	private String packEndDateXp2 = "]/td[";

	private String packDisconnectDateXp1 = "//*[@id='disc_date']/div[2]/table/tbody/tr[";
	private String packDisconnectDateXp2 = "]/td[";

	@FindBy(xpath = "//button[text()='Refund Request']")
	private WebElement refundRequestBtn;

	@FindBy(xpath = "//h4[text()='Refund Request Form ']")
	private WebElement refundReqForm;

	@FindBy(xpath="//input[@id='email']")
	WebElement email;

	@FindBy(xpath="//input[@name='customerid']")
	WebElement customerId;

	@FindBy(xpath="//input[@name='packagename']")
	WebElement packageNameField;

	@FindBy(name = "packagerate")
	WebElement packageRate;

	@FindBy(xpath="(//span/i[@class='glyphicon glyphicon-calendar'])[2]")
	WebElement packageStartCal;

	@FindBy(xpath = "(//a[@class='previous']/following-sibling::span)[3]")
	private WebElement packStartMont;

	@FindBy(xpath="(//i[@class='glyphicon glyphicon-chevron-left'])[3]")
	WebElement previousMonthShiftPckStrt;

	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-right'])[3]")
	private WebElement nextMonthShiftPckStrt;

	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-calendar'])[3]")
	private WebElement packEndDateCal;

	@FindBy(xpath = "(//a[@class='previous']/following-sibling::span)[5]")
	private WebElement packEndMonth;

	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-left'])[5]")
	private WebElement previousMonthShiftPckEnd;

	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-right'])[5]")
	private WebElement nxtMonthShiftPckEnd;

	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-calendar'])[4]")
	private WebElement packDisconnectDateCal;

	@FindBy(xpath = "(//a[@class='previous']/following-sibling::span)[7]")
	private WebElement packMonth;

	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-left'])[7]")
	private WebElement previousMonthShiftPckDisc;
	//=======================================================================


	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-right'])[7]")
	private WebElement nextMonthShiftPckDisc;

	@FindBy(xpath = "//input[@value='GO']")
	private WebElement goBtn;

	@FindBy(name = "reason")
	private WebElement reasonTxtFld;

	@FindBy(name = "utilized_days")
	private WebElement nonUtilizedDays;

	@FindBy(name = "refundamount_withouttax")
	private WebElement refundAmountWithoutTax;

	@FindBy(name = "refundamount_withtax")
	private WebElement refundAmountWithTax;

	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitBtn;

	@FindBy(xpath = "//p[contains(text(),'Start Date Cannot greater than End Date')]")
	private WebElement strtDateGreaterThanEndErr;

	@FindBy(xpath = "//p[contains(text(),'no of utilization is greater than 4 days')]")
	private WebElement disconnectAftr4DaysErr;

	@FindBy(xpath = "//p[contains(text(), 'The refund shall be processed within 15 days of receipt')]")
	private WebElement successMsg;

	@FindBy(xpath = "//p[contains(text(),'Enter the Reason')]")
	private WebElement enterReasonErr;

	
	
	public void goToRefundRequestForm()
	{
	refundRequestBtn.click();
	}

	 public void enterInformation(String emailId, String custId, String packName, String packRate) 
	 { 
	 email.clear(); 
	 email.sendKeys(emailId);
	 customerId.clear();
	 customerId.sendKeys(custId);
	 packageNameField.clear();
	 packageNameField.sendKeys(packName);
	 packageRate.clear();
	 packageRate.sendKeys(packRate);
	 }

	 
	 public void selectDates(String startDate, String endDate, String disconnectDate) throws InterruptedException
	 {
	 packageStartCal.click();
	 String startDateArr[] = startDate.split("-");
	 dh.selectMonth(previousMonthShiftPckStrt, nextMonthShiftPckStrt, packStartMont.getText(), Integer.parseInt(startDateArr[1]));
	 dh.selectDate(packStartDateXp1, packStartDateXp2, Integer.parseInt(startDateArr[2]));

	 waitTillElementIsVisible(packEndDateCal);
	 waitTillElementIsClickable(packEndDateCal);
	 packEndDateCal.click();
	 String endDateArr[] = endDate.split("-");
	 dh.selectMonth(previousMonthShiftPckEnd, nxtMonthShiftPckEnd, packEndMonth.getText(), Integer.parseInt(endDateArr[1]));
	 dh.selectDate(packEndDateXp1, packEndDateXp2, Integer.parseInt(endDateArr[2]));

	 waitTillElementIsClickable(packDisconnectDateCal);
	 packDisconnectDateCal.click();
	 String disconnectDateArr[] = disconnectDate.split("-");
	 dh.selectMonth(previousMonthShiftPckDisc, nextMonthShiftPckDisc, packMonth.getText(), Integer.parseInt(disconnectDateArr[1]));
	 dh.selectDate(packDisconnectDateXp1, packDisconnectDateXp2, Integer.parseInt(disconnectDateArr[2]));

	 Thread.sleep(1000);

	 goBtn.click();

	 }

	 public void checkErrAndSubmit(String reason, String startDate, String endDate, String disconnectDate, double packRate) 
	 {
	 try {
	 if(disconnectAftr4DaysErr.isDisplayed())
	 {
	 logger.warn(disconnectAftr4DaysErr.getText());
	 //Assert.assertTrue(false);
	 return;
	 }
	 } catch (Exception e) {

	 }

	 try {
	 if(strtDateGreaterThanEndErr.isDisplayed())
	 {
	 logger.warn(strtDateGreaterThanEndErr.getText());
	 //Assert.assertTrue(false);
	 return;
	 }
	 } catch (Exception e) {

	 }

	 checkCalculation(startDate, endDate, disconnectDate, packRate);

	 reasonTxtFld.clear();
	 reasonTxtFld.sendKeys(reason);

	 submitBtn.click();

	 try {
	 if(successMsg.isDisplayed())
	 {
	 logger.info("Refund request has been sent successfully");
	 logger.info(successMsg.getText());
	 return;
	 }
	 } catch (Exception e) {

	 }

	 try {
	 if(enterReasonErr.isDisplayed())
	 {
	 logger.warn(enterReasonErr.getText());
	 return;
	 }
	 } 
	 catch (Exception e) {

	 }
	 }
	 
	 
	 
	 
	 public void checkCalculation(String startDate, String endDate, String disconnectDate, double packRate)
	 {
	 String noOfNonUtilisedDays = Long.toString(dh.findDifferenceBetweenDates(disconnectDate, endDate));
	 logger.info("No of non utilized days expected: "+noOfNonUtilisedDays);
	 logger.info(("No of non utilized days actual: "+(nonUtilizedDays.getAttribute("value"))));
	 Assert.assertEquals(nonUtilizedDays.getAttribute("value"), noOfNonUtilisedDays);
	 double refundwithoutTaxAct = Double.parseDouble(refundAmountWithoutTax.getAttribute("value"));
	 logger.info("Refund without tax Actual: "+refundwithoutTaxAct);
	 double refundwithoutTaxExp = dh.calculateAmount(startDate, endDate, disconnectDate, packRate);
	 logger.info("Refund Without Tax Expected: "+refundwithoutTaxExp);
	 Assert.assertEquals(refundwithoutTaxAct, refundwithoutTaxExp);

	 double refundWithTaxExp = Math.round(refundwithoutTaxExp*118)/100.0d;
	 logger.info("Refund amount with Tax Expected: "+refundWithTaxExp);
	 double refundWithTaxAct = Double.parseDouble(refundAmountWithTax.getAttribute("value"));
	 logger.info("Refund Amount With Tax Actual: "+refundWithTaxAct);




	 }

	 
	 public void testRefundRequest() throws InterruptedException
	 {
	 //goToRefundRequestForm();
	 //waitTillElementIsVisible(refundReqForm);
	 //Assert.assertTrue(refundReqForm.isDisplayed());
	 String emailId = DemoExcelLibrary3.getexcelData("RefundRequest", 1, 0, path);
	 logger.info("email Id: "+emailId);
	 String custId = DemoExcelLibrary3.getexcelData("RefundRequest", 1, 1, path);
	 logger.info("Customer Id: "+custId);
	 String packName = DemoExcelLibrary3.getexcelData("RefundRequest", 1, 2, path);
	 logger.info("Pack Name: "+packName);
	 double pckRateNo = DemoExcelLibrary3.getexcelDatanumber("RefundRequest", 1, 3, path);
	 String packRate = ""+pckRateNo;
	 logger.info("Pack Rate: "+packRate);

	 enterInformation(emailId, custId, packName, packRate);

	 String packStrtDate = DemoExcelLibrary3.getexcelData("RefundRequest", 1, 4, path);
	 logger.info("Pack start Date "+packStrtDate);
	 String packEndDate = DemoExcelLibrary3.getexcelData("RefundRequest", 1,5, path);
	 logger.info("Pack End Date: "+packEndDate);
	 String packDisconnectDate = DemoExcelLibrary3.getexcelData("RefundRequest", 1, 6, path);
	 logger.info("Pack Disconnect Date: "+packDisconnectDate);
	 selectDates(packStrtDate, packEndDate, packDisconnectDate);
	 String reason = DemoExcelLibrary3.getexcelData("RefundRequest", 1, 7, path);
	 checkErrAndSubmit(reason, packStrtDate, packEndDate, packDisconnectDate, pckRateNo);


	 }

	 
	 

	
	
	

}
