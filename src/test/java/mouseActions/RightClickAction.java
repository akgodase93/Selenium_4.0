package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickAction {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement button=driver.findElement(By.xpath("//span[contains(@class,'context-menu')]"));
		WebElement copy=driver.findElement(By.xpath("//span[text()='Copy']"));
		Actions actions= new Actions(driver);
		
		//perform right click or contextClick()
		actions.contextClick(button).perform();
	
		//click on copy
		//1.normal click method
		//	driver.findElement(By.xpath("//span[text()='Copy']")).click();

		//2. Using actions class click() method
		actions.moveToElement(copy).click().perform();
		
		//handling the alert post copy element click
		//Get Text present on alert
		String getAlertText=driver.switchTo().alert().getText();
		System.out.println("Alert text: "+getAlertText);
		
		//click on OK button on alert
		driver.switchTo().alert().accept();
		
		Thread.sleep(Duration.ofSeconds(5));
	    System.out.println("Closing all the browser windows...!");
	    driver.quit();
		
	}
}
