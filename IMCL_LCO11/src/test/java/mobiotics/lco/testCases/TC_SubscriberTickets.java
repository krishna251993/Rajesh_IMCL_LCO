package mobiotics.lco.testCases;

import javax.xml.ws.Holder;

import org.testng.annotations.Test;

import mobiotics.lco.commonPage.HomePage;
import mobiotics.lco.constatnts.BaseTest;
import mobiotics.lco.subscriber_Tickets.Subscriber_TicketsPage;

public class TC_SubscriberTickets extends BaseTest{
	
	@Test
	public void subscriberTicketsTestMethod() throws Exception
	{
		preCondition();
		Subscriber_TicketsPage sbt = new HomePage().navigateToTicketsPage();
		sbt.testTickets();
	}

}
