package mobiotics.lco.testCases;

import org.testng.annotations.Test;

import mobiotics.lco.commonPage.HomePage;
import mobiotics.lco.constatnts.BaseTest;
import mobiotics.lco.modifyCustomer.Subscriber_ModifyCustomerPage;

public class TC_ModifyCustomer extends BaseTest{
	
	@Test
	public void modifyCustomerTestMethod() throws Exception
	{
		preCondition();
		Subscriber_ModifyCustomerPage smc = new HomePage().navigateToModifyCustomer();
		smc.testModifyCustomer();
	}

}
