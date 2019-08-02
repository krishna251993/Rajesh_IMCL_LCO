package mobiotics.lco.testCases;

import org.testng.annotations.Test;

import mobiotics.lco.Report_BillsPage.Report_BillsPage;
import mobiotics.lco.commonPage.HomePage;
import mobiotics.lco.constatnts.BaseTest;

public class TC_Report_Bills extends BaseTest{
	
	@Test
	public void billsTestMethod() throws Exception
	{
		preCondition();
		Report_BillsPage rb = new HomePage().navigateToBillsPage();
		rb.testBills();
	}

}
