package mobiotics.lco.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import mobiotics.lco.commonPage.HomePage;
import mobiotics.lco.constatnts.BaseTest;

public class TC_Logout extends BaseTest{
	
	@Test
	public void testLogout() throws Exception
	{
		preCondition();
		HomePage hp = new HomePage();
		hp.logout();
		Thread.sleep(4000);
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "LCO Self Care Portal");
	}

}
