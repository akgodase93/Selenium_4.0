package keyboardActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://text-compare.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//type in text box
		WebElement inputText1=driver.findElement(By.id("inputText1"));
				inputText1.sendKeys("Welcome to selenium automation");
			
		Actions actions=new Actions(driver);		
		//CTRL+A -->select all
				actions.click(inputText1).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
				
		//CTRL+C -->copy
				actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
				
		//Navigate to Next text box
				actions.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
				
				//actions.sendKeys(Keys.TAB);
				
		//CTRL+V -->paste
				actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
			
				
				Thread.sleep(Duration.ofSeconds(10));
			    System.out.println("Closing all the browser windows...!");
			    driver.quit();
	}
	
}
