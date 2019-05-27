package mobiotics.lco.commonPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mobiotics.lco.constatnts.BaseTest;



public class LoginPage extends BaseTest {

	
	public LoginPage()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	@FindBy(xpath="(//input[@name='frcode'])[1]")
	private WebElement userName;
	
	@FindBy(name="password")
	private WebElement txtPassword;
	
	@FindBy(xpath="//button[text()='Proceed']")
	private WebElement btnLogin;
	
	public void setUserName(String UserName)
	{
		userName.sendKeys(UserName);
	}
	
	public void setPassword(String pw)
	{
		txtPassword.sendKeys(pw);
	}
	
	public void clickToProceed() {
		btnLogin.click();
	}
	
	public void login(String un,String pw)
	{
		setUserName(un);
		setPassword(pw);
		clickToProceed();
	}
}
