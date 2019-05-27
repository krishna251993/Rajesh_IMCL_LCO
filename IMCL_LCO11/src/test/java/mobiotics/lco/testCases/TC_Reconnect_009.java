package mobiotics.lco.testCases;


import org.testng.annotations.Test;

import mobiotics.lco.Plans_Reconnect.Plans_ReconnectPageForLive;
import mobiotics.lco.commonPage.HomePage;
import mobiotics.lco.constatnts.BaseTest;


public class TC_Reconnect_009 extends BaseTest{

	
	@Test
	public void reconnctPlane() throws Exception {
		preCondition();
		Plans_ReconnectPageForLive homePage=new HomePage().navigateToPlansReconnectLive();
		homePage.reconnectPlan_Bulk();
		//homePage.testReconnectPlans_Single();
		
		
		
	}
}
