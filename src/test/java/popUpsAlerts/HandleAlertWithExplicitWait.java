package popUpsAlerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlertWithExplicitWait
{
	public static void main(String[] args) throws InterruptedException {
		
		final String ANSI_BOLD="\u001B[1m"+"\u001b[31m";
		final String ANSI_RESET="\u001B[0m";
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//Normal Alert with simple OK button
			driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
			System.out.println("clicked on alert button");
			Thread.sleep(2000);
			
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		Alert myalert=wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("waiting for alert to appear on page: ");
		myalert.accept();
		System.out.println("Clicked on OK button");
		
		
		
		Thread.sleep(Duration.ofSeconds(5));
	    System.out.println(ANSI_BOLD+"\nClosing all the browser windows...!"+ANSI_RESET);
	    driver.quit();
	}
}
