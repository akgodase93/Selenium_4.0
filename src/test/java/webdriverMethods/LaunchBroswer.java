package webdriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBroswer {

	public static void main(String[] args)
	{
		//Depreciated in Selenium 4.0 onwards it will be handled by Selenium Manager automatically with currently installed browser versions
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver-win64\\chromedriver.exe");
		
		//WebDriver is a remote control interface that enables introspection and control of browsers
		//Control of the browser itself
		//Selection of WebElements
		//Debugging aids
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.navigate().to("https://www.fb.com/"); 
		System.out.println("Get Title of Webpage: "+driver.getTitle());
		System.out.println("Get Current URL: "+driver.getCurrentUrl());
		//driver.close();
		driver.quit();
	}

}
