package webdriverMethods;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public class WebdriverMethods {
	public static void main(String[] args) throws  InterruptedException{
		
		WebDriver driver=new ChromeDriver(); //launch browser
		
		//Maximizes the current window if it is not already maximized
		driver.manage().window().maximize(); 
		
		//Load a new web page in the current browser window
		driver.get("https://www.google.com/"); 
		
		//An abstraction allowing the driver to access the browser's history and to navigate to a given URL
		driver.navigate().to("https://www.fb.com/");  
		
		//Move back a single "item" in the browser's history.
		driver.navigate().back(); 
		
		//Move a single "item" forward in the browser's history.
		driver.navigate().forward();
		Thread.sleep(5000);
		
		
		System.out.println("Get Title of Webpage: "+driver.getTitle()); //Get the title of the current page.
		System.out.println("Get Current URL: "+driver.getCurrentUrl()); //Get a string representing the current URL that the browser is looking at.
		
		Dimension d=new Dimension(100,200);
		
		//Set the size of the current window. This will change the outer window dimension, not just the view port
		driver.manage().window().setSize(d);
		
		Point p=new Point(500,500);
		//Set the position of the current window. This is relative to the upper left corner of the screen
		driver.manage().window().setPosition(p);
		//driver.close(); //Close the current window, quitting the browser if it's the last window currently open.
		driver.quit(); //Quits this driver, closing every associated window.
	}

}
