package mobiotics.lco.testCases;

import org.testng.annotations.Test;

import mobiotics.lco.Subscriber_Refund_Request.RefundRequestPage;
import mobiotics.lco.commonPage.HomePage;
import mobiotics.lco.constatnts.BaseTest;

public class TC_Subscriber_RefundRequest extends BaseTest{

	@Test
	public void refundReqestTestMethod() throws Exception
	{
	preCondition();
	RefundRequestPage sr = new HomePage().navigateToRefundRequest();
	sr.testRefundRequest();

	}



}
