package mobiotics.lco.testCases;

import org.testng.annotations.Test;

import mobiotics.lco.Report_ActivationReportPage.ActivationReportPage;
import mobiotics.lco.commonPage.HomePage;
import mobiotics.lco.constatnts.BaseTest;

public class TC_Report_ActivationReport extends BaseTest {

	
	@Test
	public void activationReport() throws Exception
	{
		preCondition();
		ActivationReportPage ar = new HomePage().navigateToActivationReport();
		ar.activationReportTest();
}
}