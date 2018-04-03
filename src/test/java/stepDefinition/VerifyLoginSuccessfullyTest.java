package stepDefinition;

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
		
		driver.get("https://www.flipkart.com/?affid=clickonikfk&affExtParam1=1000&affExtParam2=10279f9d11b3f0aee2869b5e0e357a");
		//driver.get(URL);
		String title_text=driver.getTitle();
		
		System.out.println(title_text);
		 	 Thread.sleep(2000);
	   
	}

	@When("^I entered valid \"([^\"]*)\" and valid \"([^\"]*)\"$")
	public void i_entered_valid_user_name_and_valid_password(String userid, String password) throws Throwable {
		
		
		 driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).clear();
	 	       Thread.sleep(2000);
	 	           
	 	        driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys(userid);
	 	        
	 	               
	 	    
	 	        driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")).clear();
		 	   
	 	      Thread.sleep(2000);
	 	    
	 	      driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys(password);
	 	     Thread.sleep(2000);
	 	     
	 	     // Click on Sign in
	 	     
	 	    driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button")).click();
	 		     
	 		     Thread.sleep(2000);
	   
	 		  
	}

	@Then("^User should be able to login successfully$")
	public void user_should_be_able_to_login_successfully() throws Throwable {
		Thread.sleep(5000);
		String SignText=driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/span[2]/span")).getText();
		
		assertEquals("Please enter valid Email ID/Mobile number", SignText);
						
		
		
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
