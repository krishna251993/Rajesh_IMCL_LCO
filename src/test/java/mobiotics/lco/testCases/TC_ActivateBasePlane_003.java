package mobiotics.lco.testCases;

import org.testng.annotations.Test;



import mobiotics.lco.Subscribe_Add_BasePack.Subscribe_AddBasePage;
import mobiotics.lco.commonPage.HomePage;
import mobiotics.lco.constatnts.BaseTest;



public class TC_ActivateBasePlane_003 extends BaseTest {
	
	@Test
	public void ActivateBasePlane() throws Exception {
		
			preCondition();
			Subscribe_AddBasePage homePage=new HomePage().navigateToSubscriber_AddBasePage();
			homePage.AddBase_PackInBulk();
			//homePage.singalAddBasePackActivation();
	}
}

	


