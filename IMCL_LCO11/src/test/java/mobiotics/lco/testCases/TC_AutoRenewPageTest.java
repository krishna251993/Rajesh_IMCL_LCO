package mobiotics.lco.testCases;

import org.testng.annotations.Test;

import mobiotics.lco.TestAutoRenewFeaturePage.AutoRenewPage;
import mobiotics.lco.commonPage.HomePage;
import mobiotics.lco.constatnts.BaseTest;

public class TC_AutoRenewPageTest extends BaseTest {
	
	@Test
	public void testAutoRenew() throws Exception {
		
		preCondition();
		Thread.sleep(5000);
		AutoRenewPage homepage=new HomePage().navigateToAutoRenewPage();
		//homepage.BulkAutoRenewFeature();
		homepage.singleAutoRenew();
	}

}
