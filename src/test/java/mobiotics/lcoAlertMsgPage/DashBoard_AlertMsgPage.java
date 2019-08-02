package mobiotics.lcoAlertMsgPage;



import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import mobiotics.lco.commonPage.BasePage;

public class DashBoard_AlertMsgPage extends BasePage {
	
	public DashBoard_AlertMsgPage() {
		PageFactory.initElements(driver, this);
	}
	
	static final Logger logger = Logger.getLogger(DashBoard_AlertMsgPage.class);

	@FindBy(xpath="//th")
	WebElement alertmsgText;
	
	public void AlerPageverification() {
		String alertMsg=alertmsgText.getText();
		if(alertMsg.equals("Alert Messages")) {
			Assert.assertTrue(true);
			logger.info("user is in the alert page");
		}
		
		
		else {
			logger.info("user is not in the alert page");
			/*
			try {
				//captureScreen(driver, "alert Page test");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("unable to take the screenshot "+e);
			}
			*/
			Assert.assertTrue(false);
		}

	}
	
}
