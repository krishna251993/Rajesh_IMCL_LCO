package mobiotics.lco.testCases;

import org.testng.annotations.Test;

import mobiotics.lco.Report_EKYCReportPage.Report_EKYCReportPage;
import mobiotics.lco.commonPage.HomePage;
import mobiotics.lco.constatnts.BaseTest;

public class TC_Report_EKYCReport extends BaseTest{

	
	@Test
	public void ekycReportTestMethod() throws Exception
	{
		preCondition();
		Report_EKYCReportPage re = new HomePage().navigateToEKYCReportPage();
		re.testEKYCReport();
	}
	
}
