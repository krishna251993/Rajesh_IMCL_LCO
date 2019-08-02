package mobiotics.lco.testCases;

import org.testng.annotations.Test;

import mobiotics.lco.Report_PaymentReportPage.Report_PaymentReportPage;
import mobiotics.lco.commonPage.HomePage;
import mobiotics.lco.constatnts.BaseTest;

public class TC_Report_PaymentReport extends BaseTest{
	
	
	@Test
	public void paymentReportTestMethod() throws Exception
	{
		preCondition();
		Report_PaymentReportPage rp = new HomePage().navigateToPaymentReportPage();
		rp.testPaymentReport();
		
		
	}

}
