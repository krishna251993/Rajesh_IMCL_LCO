package mobiotics.lco.testCases;

import org.testng.annotations.Test;

import mobiotics.lco.Hardware_Retrack.Hardware_RetrackPage;
import mobiotics.lco.commonPage.HomePage;
import mobiotics.lco.constatnts.BaseTest;

public class TC_RetrackServices extends BaseTest{
	
	@Test 
	public void retrackServicesTestMethod() throws Exception
	{
		preCondition();
		Hardware_RetrackPage hrp = new HomePage().navigateToRetrackServicesPage();
		hrp.testRetackServices();
		
	}

}
