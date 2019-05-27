package mobiotics.lco.testCases;


import org.testng.annotations.Test;

import mobiotics.lco.changeBase_Pack.Plans_ChangeBasePack;
import mobiotics.lco.commonPage.HomePage;
import mobiotics.lco.constatnts.BaseTest;


public class TC_ChangeBasePack_010 extends BaseTest{
	
	@Test
	public void changeBasePack() throws Exception {
		
		preCondition();
		Plans_ChangeBasePack pcb = new HomePage().navigateToChangeBasePack();
		Thread.sleep(2000);
		pcb.changeBasepackInBulk();
		//pcb.changeBasePackInSingle();
		
		}
	
	

}
