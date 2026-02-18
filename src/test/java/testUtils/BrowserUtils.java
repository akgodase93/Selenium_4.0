package testUtils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class BrowserUtils {

	private static WebDriver driver;
	
	
	public static void launchBrowser(WebDriver driver1, String url)
	{
		
		driver=driver1;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		System.out.println("Browser launched with URL: "+url);
	}
	
	public static void quitBrowser(WebDriver driver1) throws InterruptedException
	{
				
			//cleanup
				driver=driver1;
				Thread.sleep(Duration.ofSeconds(10));
			    System.out.println("Closing all the browser windows...!");
			    driver.quit();
	}
	
	public static void closeBrowser(WebDriver driver1) 
	{
		//cleanup
				driver=driver1;
				//Thread.sleep(Duration.ofSeconds(10));
			    System.out.println("Closing all the browser windows...!");
			    driver.close();
	}
	
	
}
