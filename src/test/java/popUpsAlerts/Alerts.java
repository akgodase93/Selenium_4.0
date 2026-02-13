package popUpsAlerts;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		
		final String ANSI_BOLD="\u001B[1m"+"\u001b[31m";
		final String ANSI_RESET="\u001B[0m";
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//1.Normal Alert with simple OK button
			driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
			Thread.sleep(2000);
			Alert myalert=driver.switchTo().alert();
			System.out.println("Alert Text: "+myalert.getText());
			myalert.accept();
		
			
		//2. Alert with OK and Cancel button
			Wait<WebDriver> fw=new FluentWait<>(driver)
					.withTimeout(Duration.ofSeconds(10))
					.pollingEvery(Duration.ofSeconds(1))
					.ignoring(NoAlertPresentException.class);
					
					
			WebElement al=fw.until(webDriver->webDriver
									.findElement(By.xpath("//button[text()='Click for JS Confirm']"))
					);
			al.click();			
			
			//driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
			Alert myalert2 = driver.switchTo().alert();
			System.out.println("Alert2 Text: "+myalert2.getText());
			
			Thread.sleep(Duration.ofSeconds(3));
			//myalert2.accept();
			myalert2.dismiss();
						
			
			//3. Authentication Alert with Textbox, OK and Cancel Button
						
			WebElement al3=fw.until(webDriver->webDriver
							.findElement(By.xpath("//button[text()='Click for JS Prompt']")));
			al3.click();
			Alert myalert3 = driver.switchTo().alert();
			
			System.out.println("Alert3 Text: "+myalert3.getText());
			Thread.sleep(Duration.ofSeconds(3));
			
			String text="No Thanks!!";
			myalert3.sendKeys(text);
			Thread.sleep(Duration.ofSeconds(2));
			
			//myalert3.dismiss();
			myalert3.accept();
			
			
			//String text = "one,two,three";
			//String[] words = text.split(",");
			// Result: ["one", "two", "three"]

			String actText=driver.findElement(By.cssSelector("p#result")).getText();
			System.out.println("Actual text I am getting from webpage is having static value plus value sent"
					+ "\nin Alert text boxso need to trim that value: "+actText);
			String[] actTxt=actText.split(":");
			actText=actTxt[1].trim();
			System.out.println(ANSI_BOLD+"Actual text post trim: "+ANSI_RESET+actText);
			
			
			System.out.println(ANSI_BOLD+"Actual text: "+ANSI_RESET+actText+ANSI_BOLD+"\nAnd Expected text is: "+ANSI_RESET+text);
			if(text.contains(actText))
			{
				System.out.println("test passed");
			}
			else
			{
				System.out.println("test failed!!");
			}
			
			
			
			Thread.sleep(Duration.ofSeconds(5));
		    System.out.println(ANSI_BOLD+"\nClosing all the browser windows...!"+ANSI_RESET);
		    driver.quit();
	}
	

}
