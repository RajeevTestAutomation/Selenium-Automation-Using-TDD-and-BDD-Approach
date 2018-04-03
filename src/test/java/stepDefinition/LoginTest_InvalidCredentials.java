package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.cucumber.listener.Reporter;


import static org.junit.Assert.assertEquals;

import java.io.File;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import utility_Methods.CaptureScreenshots;
import utility_Methods.HiglightElement;

public class LoginTest_InvalidCredentials extends AbstractSeleniumClass{
	
	WebDriver driver=getDriver();
	
	Scenario scenario;
	@Before("@selenium")
	public void LaunchBrowser(Scenario scenario){
		
		this.scenario=scenario;
	//	WebDriver driver=getDriver();
		System.out.println("Executing Scenario "+ scenario.getName());
		
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
	
	
	
	@Given("^Open firefox and start application$")
	public void open_firefox_and_start_application() throws Throwable {
	    
		driver.get("https://www.flipkart.com/?affid=clickonikfk&affExtParam1=1000&affExtParam2=10279f9d11b3f0aee2869b5e0e357a");
		//driver.get(URL);
		String title_text=driver.getTitle();
		
		System.out.println(title_text);
		 	 Thread.sleep(2000);
	}

	@When("^I entered invalid \"([^\"]*)\" and valid \"([^\"]*)\"$")
	public void i_entered_invalid_and_valid(String userid, String password) throws Throwable {
	   
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
		     
		     Thread.sleep(2000);
		     
	}

	@Then("^User should get Incorrect username or password message$")
	public void user_should_get_Incorrect_username_or_password_message() throws Throwable {
	   
		 String ActualError_Text = driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/span[2]/span")).getText();
 		    
	 		   System.out.println("Error on Sign page due to invalid credentials is:"+ActualError_Text);
	 		   
	 		// Taking ScreenShots for invalid user name.
	   		   
			   CaptureScreenshots.CaptureScreenshots(driver, "LoginscreenforInvalidUsername");
	 		   
	 		  assertEquals("Please enter valid Email ID/Mobile number", ActualError_Text);
		
	}

	@When("^I entered valid \"([^\"]*)\" and Invalid \"([^\"]*)\"$")
	public void i_entered_valid_and_Invalid(String userid, String password) throws Throwable {
	    
		
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
		     
		     Thread.sleep(2000);
		     
		     
		     Thread.sleep(2000);
	}

	@Then("^User should get incorrect username or password message$")
	public void user_should_get_incorrect_username_or_password_message() throws Throwable {
		
		//  Reporter.getExtentReport().getClass();
		  	
		 			
		  
		 // Reporter.getExtentReport().createTest("Rajeev", "description");
		
		String ActualError_Text = driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/span[2]/span")).getText();
		    
		   System.out.println("Error on Sign page due to invalid credentials is:"+ActualError_Text);
		   
		 // Taking ScreenShots for invalid  password.
		   		   
		   CaptureScreenshots.CaptureScreenshots(driver, "LoginscreenforInvalidPassword");
		   
		//  assertEquals("Incorrect username or password.",ActualError_Text);
		  
		//  Reporter.getExtentReport().createTest("Rajeev", "description").log(Status.FAIL, "details");
		  
		  // driver.quit();
		  
	}

	
	
	
}
