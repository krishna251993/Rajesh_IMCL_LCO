package mobiotics.lco.testCases;






import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;

public class TestClass {
	
	@Test
	public void AlertCheck() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		
		WebDriver driver= new  ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://lcoportal.incablenet.net/activations");
		driver.findElement(By.xpath("//input[@placeholder='FR CODE']")).sendKeys("fr5125");
		driver.findElement(By.xpath("//input[@placeholder='password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		//driver.findElement(By.id("close")).click();
		driver.findElement(By.xpath("//a[text()='Renew  ']")).click();
		driver.findElement(By.xpath("//a[text()='Renew Plans']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter CAN/SMC/STB']")).sendKeys("CAN26281281");
		driver.findElement(By.id("subscriberid")).click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		String a=js.executeScript(" return $('.plan-list tr').length;").toString();
		int a1=Integer.parseInt(a);
	    System.out.println(a1);
	    
	    List<WebElement> allRadio=driver.findElements(By.xpath("//input[@type='checkbox']"));
	    int size=allRadio.size();
	    
	    
	    for (int i = 0; i < size; i++) {
	    	WebElement radioButton=allRadio.get(i);
			if(radioButton.isEnabled()==true) {
				radioButton.click();
			}
			
		}
	    driver.findElement(By.id("confirm-subscribe")).click();
	    
	    
	    
	    
	    
	   // System.out.println(js.executeScript(" return $('.plan-list tr').length;"));
	   //System.out.println(js.executeScript("return $(\".copyright\").text();"));

	    
	   //Document document = Jsoup.parse(data, "",  Parser.xmlParser());
	  //// Elements element = document.select("tr.row");
	   //System.out.println("Number of Rows are : "+element.size()); 
		//System.out.println(js.executeScript("$('.plan-list tr').length"));
		
		/*
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Subscribe  ']")).click();
		
		driver.findElement(By.xpath("//a[@href='lcoaddindigital'  and text()='Add Indigital Pay Bouquet']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Enter CAN/STB/SMC']")).sendKeys("can24755723");
		driver.findElement(By.id("subscriberid")).click();
		Thread.sleep(2000);
		WebElement select_1=driver.findElement(By.xpath("(//select)[6]"));
		Select ssel1=new Select(select_1);
		Thread.sleep(2000);
		ssel1.selectByValue("rzdVWqlC");
		Thread.sleep(2000);
		
		
		
		 Elements element = document.select("tr.plan-list");
   System.out.println("Number of Rows are : "+element.size())
		
		*/
	}
	
	

}
