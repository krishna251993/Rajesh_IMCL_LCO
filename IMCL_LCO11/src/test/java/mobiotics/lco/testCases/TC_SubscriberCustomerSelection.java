package mobiotics.lco.testCases;

import org.testng.annotations.Test;

import mobiotics.lco.Subscribers_CustomerSelection.Subscribers_CustomerSelectionPage;
import mobiotics.lco.commonPage.HomePage;
import mobiotics.lco.constatnts.BaseTest;

public class TC_SubscriberCustomerSelection extends BaseTest{
	
	@Test
	public void customerSelectionTestMethod() throws Exception
	{
		preCondition();
		Subscribers_CustomerSelectionPage scp = new HomePage().navigateToCustomerSelectionPage();
		scp.testCustomerSelection();
	}

}
