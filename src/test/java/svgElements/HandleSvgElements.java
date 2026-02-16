package svgElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleSvgElements {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.tagName("button")).click();
		
		//driver.findElement(By.xpath("//a[normalize-space()='']//*[name()='svg']")).click();
		//driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/svg")).click();
		//driver.findElement(By.xpath("//*[name()='svg'][@role='presentation'])[3]")).click();
		
		//driver.findElement(By.xpath("//button[@title='Timesheets']//*[name()='svg']")).click();
		
		//driver.findElement(By.xpath("(//a[contains(@href,'viewLeaveModule')] //*[name()='svg']")).click();
		
		Thread.sleep(5000);
		
		//driver.findElement(By.xpath("//*[name()='svg' and contains(@class,'oxd-main-menu-item--icon')]")).click();
		
		
		
		//driver.findElement(By.xpath("//a[contains(@href,'viewLeaveModule')]//*[name()='svg' and contains(@class,'oxd-main-menu-item--icon')]")).click();
		
		driver.findElement(By.xpath("//a[contains(@href,'viewTimeModule')]//*[name()='svg']")).click();
		
		
		// cleanup
				Thread.sleep(Duration.ofSeconds(10));
				System.out.println("Closing all the browser windows...!");
				driver.quit();
	}
}
