package utility_Methods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HiglightElement {
	
	
	
public static void HiglightElementHelper(WebDriver driver, WebElement element ){
	
	 JavascriptExecutor jse = (JavascriptExecutor)driver;
	 
		jse.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", element);
		
				try{
			
			Thread.sleep(500);
			
		} catch(InterruptedException e){
			
			System.out.println(e.getMessage());
								
		}
		
		
				jse.executeScript("arguments[0].setAttribute('style',' border: 2px solid red;');", element);
	
	
}

}
