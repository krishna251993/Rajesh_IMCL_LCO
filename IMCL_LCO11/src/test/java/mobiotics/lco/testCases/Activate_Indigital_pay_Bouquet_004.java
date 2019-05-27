package mobiotics.lco.testCases;


import org.testng.annotations.Test;

import mobiotics.lco.AddIndigitalPayBouquet.AddIndigitalPayBuquetPage;
import mobiotics.lco.commonPage.HomePage;
import mobiotics.lco.constatnts.BaseTest;


public class Activate_Indigital_pay_Bouquet_004 extends BaseTest {
	
	@Test
	public void Activate_Indigital_Plane() throws Exception {
		preCondition();
		Thread.sleep(5000);
		AddIndigitalPayBuquetPage homePage=new HomePage().navigateToIndigitalPage();
		//homePage.AddIndigitalPack_InBulk();
		
		homePage.singalAddIndigitalPayBouquet_Activation();
		
		
		
	}
	
	



}
