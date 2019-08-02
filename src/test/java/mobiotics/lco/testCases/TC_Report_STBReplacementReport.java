package mobiotics.lco.testCases;

import org.testng.annotations.Test;

import mobiotics.lco.Report_STBReplacementReport.Report_STBReplacementReportPage;
import mobiotics.lco.commonPage.HomePage;
import mobiotics.lco.constatnts.BaseTest;

public class TC_Report_STBReplacementReport extends BaseTest{
	
	@Test
	public void stbreplacementReportTestMethod() throws Exception
	{
		preCondition();
		Report_STBReplacementReportPage rsp = new HomePage().navigateToSTBReplacementreportPage();
		rsp.testSTBReplacementReport();
	}

}
