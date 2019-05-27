package mobiotics.lco.testCases;

import org.testng.annotations.Test;

import mobiotics.lco.commonPage.HomePage;
import mobiotics.lco.constatnts.BaseTest;
import mobiotics.lcoAlertMsgPage.DashBoard_AlertMsgPage;


public class TC_NavigateToAlertPage_002 extends BaseTest {
	
	
	
	
	@Test
	public void alertPage() throws Exception {
		
		preCondition();
		
		DashBoard_AlertMsgPage homePage=new HomePage().navigateToAlert_MsgPage();
		
		homePage.AlerPageverification();
	
	
	}
	

}
