package chromeOptions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DisableAutomationMsgChromeOptions {

public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options=new ChromeOptions();
		
		//Just to disable the message in browser  called "Chrome is being controlled by automated Test software"
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("Browser launched with OrangeHRM login page open");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Username : Admin
		//Password : admin123
		
		//entering username
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String text=driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
		
		if(text.equals("Dashboard"))
		{
			System.out.println("Login successful!!");
		}
		else
		{
			System.out.println("Login failed!!");
		}
		
		// cleanup
				Thread.sleep(Duration.ofSeconds(10));
			    System.out.println("Closing all the browser windows...!");
			    driver.quit();
	}
}
