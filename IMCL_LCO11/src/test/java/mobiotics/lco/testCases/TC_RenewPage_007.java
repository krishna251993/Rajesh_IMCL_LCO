package mobiotics.lco.testCases;

import org.testng.annotations.Test;

import mobiotics.lco.RenewPlanePage.RenewPage;
import mobiotics.lco.commonPage.HomePage;
import mobiotics.lco.constatnts.BaseTest;

public class TC_RenewPage_007 extends  BaseTest {
	
	@Test
	
	public void renewPlan() throws Exception {
		preCondition();
		Thread.sleep(5000);
		RenewPage homePage=new HomePage().navigateToRenewPage();
		homePage.renewPlaneInBulk();
		//homePage.singleRenewPlane();
	}
		
}
