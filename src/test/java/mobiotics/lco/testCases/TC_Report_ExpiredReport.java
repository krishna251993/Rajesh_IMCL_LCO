package mobiotics.lco.testCases;

import org.testng.annotations.Test;

import mobiotics.lco.Report_ExpiryReportPage.Report_ExpiredReportPage;
import mobiotics.lco.commonPage.HomePage;
import mobiotics.lco.constatnts.BaseTest;

public class TC_Report_ExpiredReport extends BaseTest{
	
	@Test
	public void expiredReportTest() throws Exception
	{
		preCondition();
		Report_ExpiredReportPage re = new HomePage().navigateToExpiredReport();
		re.testExpiredReport();
		
	}
	

}
