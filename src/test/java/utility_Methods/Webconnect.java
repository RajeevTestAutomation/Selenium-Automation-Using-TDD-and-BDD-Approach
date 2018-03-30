package utility_Methods;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Webconnect {
	
	Properties OR= null;
	
	Properties CONFIG=null;
	WebDriver driver=null;
	
	
	public Webconnect(){
		
		if(OR==null)
		{
			try{
				
				// Initialize OR
				
				OR=new Properties();
				
				
				FileInputStream fs= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\config\\OR.properties");
				
				OR.load(fs);
				
				// INITIALIZE CONFIG TO CROSSPONDING ENVIRMENT
				
				CONFIG= new Properties();
				
				fs= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\config\\"+OR.getProperty("testEnv")+"_Config.properties");
				
				CONFIG.load(fs);
				
				//System.out.println(OR.getProperty("emailAddressID"));
				
			//	System.out.println(OR.getProperty("passwordID"));
				
				
				
				
			} catch(Exception e)
			{
				
				System.out.println("Error while initializing is : ");
				
				
			}
			
		}
		
	}

	
	public void OpenBrowser( String browsertype){
				
		if(browsertype.equals("Firefox"))
		{
			
			driver= new FirefoxDriver();
			
		}
		else if(browsertype.equals("Chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Chrome//chromedriver.exe");
		} 
		else if(browsertype.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//IE//IEDriverServer.exe");
			
					}
		
		// Maximize Browser
		
		driver.manage().window().maximize();
		// Implicit Wait
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
			}
	
	// Navigate to a URL
	public void NavigateUrl( String URL){
		
		driver.get(CONFIG.getProperty(URL));
		
		}
	
	// Click on any object
	
	public void Click( String ObjectName){
		
		driver.findElement(By.xpath(OR.getProperty(ObjectName))).click();
		
	}
	
	// Type any value in any inputbox
	
	public void Type( String text, String ObjectName){
		
		driver.findElement(By.xpath(OR.getProperty(ObjectName))).sendKeys(text);
		
	}
	
	// To Get Any Text for Validating 
	
	public String GetText( String ObjectName){
		
		String ElementText=driver.findElement(By.xpath(OR.getProperty(ObjectName))).getText();
		
		return(ElementText);
	}
	
	// Quitting Browser
	
	public void QuitBrowser()
	{
		
		driver.quit();
		
		
	}
	
	
}
