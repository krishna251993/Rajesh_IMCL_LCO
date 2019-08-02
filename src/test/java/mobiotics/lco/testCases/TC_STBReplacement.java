package mobiotics.lco.testCases;

import org.testng.annotations.Test;

import mobiotics.lco.commonPage.HomePage;
import mobiotics.lco.constatnts.BaseTest;
import mobiotics.lco.hardwareSTBReplacement.HardwareSTBReplacementPage;

public class TC_STBReplacement extends BaseTest{
	
	@Test
	public void stbReplacementTestMethod() throws Exception
	{
		preCondition();
		HardwareSTBReplacementPage hsb = new HomePage().navigateToSTBReplacement();
		hsb.testSTBReplacement();
		
	}

}
