package mobiotics.lco.Report_BillsPage;

import java.util.List;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import mobiotics.lco.commonPage.BasePage;
import mobiotics.lco.utilities.DemoExcelLibrary3;

public class Report_BillsPage extends BasePage{
	
	private String path = "./ExcelPages/TestData.xlsx";
	
	public Report_BillsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	static final Logger logger = Logger.getLogger(Report_BillsPage.class);
	
	@FindBy(xpath = "//h1[text()='Bills']")
	private WebElement pageTitle;
	
	@FindBy(id = "year")
	private WebElement yearDropdown;
	
	@FindBy(id="month")
	private WebElement monthDrodown;
	
	@FindBy(xpath = "(//tbody/tr/td[1])[1]")
	private WebElement yearDisplaying;
	
	@FindBy(xpath = "(//tbody/tr/td[2])[1]")
	private WebElement monthDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]")
	private WebElement firstRow;
	
	@FindBy(xpath="//h4[contains(text(),'No bill exists')]")
	private WebElement noBillsMsg;
	
	@FindBy(xpath = "(//tbody/tr/td[3])[1]")
	private WebElement documentNameDisplaying;
	
	@FindBy(xpath = "(//tbody/tr/td[4])[1]")
	private WebElement billDownloadLink;
	
	
	
	public void selectYear(String year)
	{
		Select listYear = new Select(yearDropdown);
		List<WebElement> listOfYears = listYear.getOptions();
		if(listOfYears.size()<=1)
		{
			logger.info(firstRow.getText());
			return;
		}
		listYear.deselectByVisibleText(year);
	}
	
	public void selectMonth(String month)
	{
		Select listMonth = new Select(monthDrodown);
		listMonth.selectByVisibleText(month);
	}
	
	public void testBills() throws Exception
	{
		waitTillElementIsVisible(pageTitle);
		Assert.assertEquals(pageTitle.getText(), "Bills");
		logger.info("Bills Page");
		String year = "2019";
		selectYear(year);
		String month = "04";
		try {
			if(monthDrodown.isDisplayed())
			{
				selectMonth(month);
			}
			
		} catch (Exception e) {
			return;
		}
		
		
		Thread.sleep(5000);
		try {
			if(noBillsMsg.isDisplayed())
			{
				System.out.println(noBillsMsg.getText());
				logger.info(noBillsMsg.getText());
				
			}
		} catch (Exception e) {
			return;
		}
		
		Assert.assertEquals(yearDisplaying.getText(), year);
		Assert.assertEquals(monthDisplaying.getText(), month);
		logger.info(yearDisplaying.getText());
		logger.info(monthDisplaying.getText());
		logger.info(documentNameDisplaying.getText());
		
		
		//write code to download bill.pdf
		
	}

	
	
}
