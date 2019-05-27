package mobiotics.lco.testCases;

import org.testng.annotations.Test;

import mobiotics.lco.Profile.ProfilePage;
import mobiotics.lco.commonPage.HomePage;
import mobiotics.lco.constatnts.BaseTest;

public class Tc_Profile extends BaseTest{
	
	@Test
	public void profileTestMethod() throws Exception
	{
		preCondition();
		ProfilePage profile = new HomePage().navigateToProfilePage();
		profile.updateLCOProfile();
	}

}
