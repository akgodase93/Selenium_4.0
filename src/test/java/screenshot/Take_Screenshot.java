package screenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Take_Screenshot {
	static String screenshotFolderpath="src/test/resources/Screenshots/";
	static String tag;
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		
		
		String timestamp = LocalDateTime.now()
		        .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

		
		//full page screenshot
			//step 1: Type cast driver object into driver object 
					//here if we are creating object of browsers class directly
					//then we dont need to type cast as its directly TakescreenShot interface can be directly object of
					//browsers class directly
					
					//implemented by ChromeDriver class
					//eg. ChromeDriver driver=new ChromeDriver()
					//TakesScreenshot ts=driver;  //only for directly created browser class objects
			
				//here as we have used WebDriver interface to initialize driver object of chrome class so casting needed
			
				TakesScreenshot ts=(TakesScreenshot)driver; 
							
			//step 2: Use method GetScreenshotAs() method of TakesScreentshot interface which accepts OutputType as file type
				File source=ts.getScreenshotAs(OutputType.FILE);
				   
				
			//step 3: Screenshot taken in step2 is now available inside memory, so copy it to target location using File class methods
				File target=new File("src/test/resources/Screenshots/screenshot_fullpage_"+timestamp+".png");
				//Way1: source.renameTo(target);
				
				//Way2:
				FileHandler.copy(source, target);
				
			
		
		//Element level screenshot
		WebElement section=driver.findElement(By.xpath("//section[@class='product-grid home-page-product-grid']"));
		
		tag = "screenshot_"+section.getTagName();
		source=section.getScreenshotAs(OutputType.FILE);
		File target1=new File(screenshotFolderpath+tag+"_"+timestamp+".png");
		source.renameTo(target1);
		
		System.out.println("Screenshot is taken and copied to specified path!!!");
		
		// cleanup
				Thread.sleep(Duration.ofSeconds(10));
			    System.out.println("Closing all the browser windows...!");
			    driver.quit();
		
	}
}
