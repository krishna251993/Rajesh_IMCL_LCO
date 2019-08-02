package mobiotics.lco.testCases;





import org.testng.annotations.Test;


import mobiotics.lco.commonPage.HomePage;
import mobiotics.lco.constatnts.BaseTest;

import mobitics.lco.Plans_Disconnect.Plans_DisconnectPageForLive;

public class TC_DisconnectPlane_008 extends BaseTest {
	@Test
	
	public void DisconnectPlan() throws Exception {
		preCondition();
		
		Thread.sleep(2000);
		Plans_DisconnectPageForLive homePage= new HomePage().navigateToPlans_DisconnectPage();
		homePage.disconnectPlansSingle();
		//homePage.disconnectPlansBulk();
		
	}
	
	
	

}
