package mobiotics.lco.testCases;



import org.testng.annotations.Test;

import mobiotics.lco.Subscriber_Ala_Carte_Page.Subscriber_Ala_Carte_Page;
import mobiotics.lco.commonPage.HomePage;
import mobiotics.lco.constatnts.BaseTest;



//need to be test this test case when i will get fresh CAN number

public class Add_A_Al_Carte_Pack_006 extends BaseTest {
	
	@Test
	public void activateAddAlA_Carte() throws Exception {
		
		preCondition();
		Thread.sleep(3000);
		Subscriber_Ala_Carte_Page homePage=new HomePage().navigateToSubscriber_AlaCarte();
		
		
		homePage.singalAdd_AlaCarte_Pack();
		
	}

}
