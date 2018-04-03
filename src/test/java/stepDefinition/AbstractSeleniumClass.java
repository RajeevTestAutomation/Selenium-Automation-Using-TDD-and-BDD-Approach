package stepDefinition;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public abstract class AbstractSeleniumClass {
	
	public static FirefoxBinary firefoxBinary = new FirefoxBinary(new File("C:\\Users\\c724917\\AppData\\Local\\Mozilla Firefox\\firefox.exe"));
	public static FirefoxProfile firefoxProfile = new FirefoxProfile();
	
	
	// Create the fireFox driver to drive the browser
	
	//public	static WebDriver driver = new FirefoxDriver(firefoxBinary, firefoxProfile);
	
	public	static WebDriver driver;
	
	protected WebDriver getDriver(){
		
		if (driver==null){
			
			
			driver=new FirefoxDriver(firefoxBinary, firefoxProfile);
		}
		return driver;
						
	}

	// for multiple browser:
	
	public void OpenBrowser( String browsertype){
		
		if(browsertype.equals("Firefox"))
		{
			
			//driver= new FirefoxDriver();
			
			driver=new FirefoxDriver(firefoxBinary, firefoxProfile);
			
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
	//#########################
	
}
