package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

public class MouseHover {
	public static void main(String[] args) throws InterruptedException {
		
		final String ANSI_BOLD = "\u001B[1m" + "\u001B[32m";
		final String ANSI_RESET = "\u001B[0m";
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement computers=driver.findElement(By.xpath("//a[@href='/computers']"));
		WebElement 	notebooks=driver.findElement(By.xpath("//a[@href='/notebooks']"));
		Actions actions=new Actions(driver);
		
		//actions.moveToElement(computers).build().perform();
		//build-->creates or compiles action
		//perform->executes or performs actions
		
		//Mouse hover
		actions.moveToElement(computers).perform();
		
		//lets click on one of option [notebooks] on computers menu
		actions.moveToElement(notebooks).click().perform();
		
		Thread.sleep(Duration.ofSeconds(5));
	    System.out.println(ANSI_BOLD+"\nClosing all the browser windows...!"+ANSI_RESET);
	    driver.quit();
	}
}
