package mobiotics.lco.testCases;


import org.testng.annotations.Test;

import mobiotics.lco.Add_BroadcasterPayBouquet.Subcribe_AddBroadcasterPay;
import mobiotics.lco.commonPage.HomePage;
import mobiotics.lco.constatnts.BaseTest;






public class Select_Broadcast_Plane_005 extends BaseTest {
	
	@Test
	
	
	public void add_BroadCast_Pay() throws Exception {
		preCondition();
		Thread.sleep(5000);
		Subcribe_AddBroadcasterPay homePage=new HomePage().navigateToSubscribe_Broadcaster();
		//homePage.addBroadcasterPack_Bulk();
		homePage.singalAddBroadcasterPack();
		
		
		
		
		
		
}
}