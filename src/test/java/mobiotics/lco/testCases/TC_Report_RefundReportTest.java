package mobiotics.lco.testCases;

import org.testng.annotations.Test;

import mobiotics.lco.Report_RefundReport.Report_RefundReportPage;
import mobiotics.lco.commonPage.HomePage;
import mobiotics.lco.constatnts.BaseTest;

public class TC_Report_RefundReportTest  extends BaseTest{
	
	@Test
	public void refundReportTest() throws Exception
	{
		preCondition();
		Report_RefundReportPage rp = new HomePage().navigateToRefundReportPage();
		rp.testRefundReport();
	}

}
