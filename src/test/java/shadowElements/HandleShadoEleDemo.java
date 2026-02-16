package shadowElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleShadoEleDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://books-pwakit.appspot.com/");

		SearchContext shado0=driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
		Thread.sleep(5000);
		shado0.findElement(By.cssSelector("#input")).sendKeys("Welcome");
		
		// cleanup
				Thread.sleep(Duration.ofSeconds(10));
				System.out.println("Closing all the browser windows...!");
				driver.quit();
	}

}
