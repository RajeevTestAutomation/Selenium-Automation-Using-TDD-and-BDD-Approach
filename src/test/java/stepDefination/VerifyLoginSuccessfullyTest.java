package stepDefination;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;
import java.util.Map;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import utility_Methods.CaptureScreenshots;
import utility_Methods.Webconnect;

public class VerifyLoginSuccessfullyTest extends AbstractSeleniumClass{
	
	// Creating Object for Webconnect 
	
	Webconnect selenium= new Webconnect();
	
	WebDriver driver=getDriver();
	Scenario scenario;
	
	
	@Before("@selenium")
	public void LaunchBrowser(Scenario scenario){
		
		this.scenario=scenario;
	//	WebDriver driver=getDriver();
		System.out.println("Executing Scenario "+ scenario.getName());
		
			
		
	}
	
	
	
	@Given("^Open \"([^\"]*)\" on \"([^\"]*)\"$")
	public void open_on(String url, String browser, DataTable table) throws Throwable {
	
			
		driver.manage().window().maximize();
		
		List<Map<String, String>> data= table.asMaps(String.class, String.class);
		
		
		//System.out.println( " I am Opening URL"+url+"on"+browser+" working in state "+ data.get(0).get("State")+ "at"+ data.get(0).get("City")+" ");
		//System.out.println( " I am Opening URL"+url+"on"+browser+" working in state "+ data.get(1).get("State")+ "at"+ data.get(1).get("City")+" ");
		
		System.out.println( " I am Opening "+url+" on "+browser +" ");
		
		//OpenBrowser( browser);
		
		//selenium.OpenBrowser(browser);
		//selenium.NavigateUrl(url);
		
		driver.get("https://login.yahoo.com/config/login?.src=fpctx&.intl=za&.lang=en-ZA&.done=https%3A%2F%2Fza.yahoo.com");
		//driver.get(URL);
		String title_text=driver.getTitle();
		
		System.out.println(title_text);
		 	 Thread.sleep(5000);
	   
	}

	@When("^I entered valid \"([^\"]*)\" and valid \"([^\"]*)\"$")
	public void i_entered_valid_user_name_and_valid_password(String userid, String password) throws Throwable {
		
		
		 driver.findElement(By.id(".//*[@id='login-username']")).clear();
	 	       Thread.sleep(2000);
	 	           
	 	        driver.findElement(By.id(".//*[@id='login-username']")).sendKeys(userid);
	 	        
	 	        // unchecked staysigned in:
	 	        
	 	        driver.findElement(By.xpath(".//*[@id='login-username-form']/p[2]/span[1]/label")).click();
	 	        
          // Click next in:
	 	        
	 	        driver.findElement(By.xpath(".//*[@id='login-signin']")).click();
	 	        
	 	    Thread.sleep(2000);
	 	    
	 	        driver.findElement(By.id(".//*[@id='login-passwd']")).clear();
		 	   
	 	      Thread.sleep(2000);
	 	    
	 	      driver.findElement(By.id(".//*[@id='login-passwd']")).sendKeys(password);
	 	     Thread.sleep(2000);
	 	     
	 	     // Click on Sign in
	 	     
	 	    driver.findElement(By.xpath(".//*[@id='login-signin']")).click();
	 		     
	 		     Thread.sleep(2000);
	   
	 		  
	}

	@Then("^User should be able to login successfully$")
	public void user_should_be_able_to_login_successfully() throws Throwable {
		Thread.sleep(5000);
		String SignText=driver.findElement(By.xpath(".//*[@id='yui_3_18_0_3_1522414212663_1043']")).getText();
		
		assertEquals("Rajeev", SignText);
						
		
		
	//	Assert.assertTrue(logOut_text, false);
		
		// Taking screen for successful Login:
		
		CaptureScreenshots.CaptureScreenshots(driver, "loginSuccessfully");
	//	selenium.QuitBrowser();
		
	   driver.quit();
	   
	   
	}
	
	
	/*
	@After("@selenium")
	public void CloseBrowser(){
		
		scenario.write("Finished Scenario");
		
		if(scenario.isFailed()){
			
			scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
			
		}
		
		driver.close();
        driver.quit();
	}
	
	*/
}
