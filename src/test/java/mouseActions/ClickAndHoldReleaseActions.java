package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickAndHoldReleaseActions {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://codepen.io/EpsilonDeltaCriterion/pen/jLoPgE");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.switchTo().frame("result");
		Actions actions=new Actions(driver);
		
		//oslo to norway drag and drop
			WebElement oslo=driver.findElement(By.id("box1"));
			WebElement norway=driver.findElement(By.id("box101"));
			
			actions.clickAndHold(oslo)
					.moveToElement(norway)
					.release()
					.perform();
			
			Thread.sleep(Duration.ofSeconds(10));
		    System.out.println("Closing all the browser windows...!");
		    driver.quit();
			
	}
}
