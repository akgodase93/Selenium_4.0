package javascriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorDemo {

		public static void main(String[] args) throws InterruptedException {
			
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://testautomationpractice.blogspot.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			WebElement name=driver.findElement(By.id("name"));
			WebElement email=driver.findElement(By.id("email"));
			WebElement male=driver.findElement(By.id("male"));
			
			JavascriptExecutor js=(JavascriptExecutor)driver;
			//1. Sending or entering text into text box
			//Alternate method to sendKey()
			
			//Approach 1:
			js.executeScript("arguments[0].setAttribute('value','Glenn Maxwell');", name);
			
			//Approach 2:
			js.executeScript("arguments[0].value='glenn@maxwellfoundation.com';", email);
			
			//2. Clicking on WebElement /Alternate to Selenium click()
			
			js.executeScript("arguments[0].click();", male);
			
			//clean up operations	
			Thread.sleep(Duration.ofSeconds(10));
		    System.out.println("Closing all the browser windows...!");
		    driver.quit();
	
		}
}
