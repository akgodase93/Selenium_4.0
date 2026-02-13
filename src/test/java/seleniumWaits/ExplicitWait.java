package seleniumWaits;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ExplicitWait {

	public static void main(String[] args) throws InterruptedException  
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//1. Declaration of Explicit wait
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10)); //applies at element level
		
		//2. Usage 
		WebElement username=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
		username.sendKeys("Admin");
		
		
		
		Thread.sleep(Duration.ofSeconds(5));
		driver.quit();
	}

}
