package mobiotics.lco.testCases;

import org.testng.annotations.Test;

import mobiotics.lco.ExpiryReport_Page.ExpiryReportPage;
import mobiotics.lco.commonPage.HomePage;
import mobiotics.lco.constatnts.BaseTest;

public class TC_ExpiryReportPageTest extends BaseTest{
	
	@Test
	public void expiryReportTest() throws Exception
	{
		preCondition();
		ExpiryReportPage ep = new HomePage().navigateToExpiryReport();
		ep.testExpiryReport();
		
		
	}

}
