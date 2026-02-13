package javascriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSPageScroll {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		//1. scroll by pixel
			js.executeScript("window.scrollBy(0, 1000);");
			
			Thread.sleep(5000);
			
		//2. scroll till WebElement found
			WebElement newsElement=driver.findElement(By.xpath("//h2[@class='title' and text()='News']"));
			js.executeScript("arguments[0].scrollIntoView(true);", newsElement);
			Thread.sleep(3000);
			
		//3. scroll at the bottom of page			
			//Approach 1: Using scrollTo() method of JavaScript
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			Thread.sleep(3000);
			
			//Approach 2: Using scrollBy() method of JavaScript
			
		//4. scroll back to top of the page or previous location
			//Approach 2: Using scrollBy() method of JavaScript
			js.executeScript("window.scrollBy(0, -document.body.scrollHeight);");
			
		
		//5. cleanup
			Thread.sleep(Duration.ofSeconds(10));
		    System.out.println("Closing all the browser windows...!");
		    driver.quit();
	}
}
