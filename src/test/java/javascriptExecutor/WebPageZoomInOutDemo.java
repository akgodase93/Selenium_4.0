package javascriptExecutor;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebPageZoomInOutDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Thread.sleep(5000);
		//Zoom 20% level
			js.executeScript("document.body.style.zoom='50%'");
		
		Thread.sleep(5000);
		//Zoom 80% level
			js.executeScript("document.body.style.zoom='80%'");
				
		
		// cleanup
		Thread.sleep(Duration.ofSeconds(10));
	    System.out.println("Closing all the browser windows...!");
	    driver.quit();
	}
}
