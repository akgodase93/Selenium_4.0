package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderMoveByOffsetClickAndHold {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/slider/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		WebElement frame=driver.findElement(By.xpath("//iframe"));
		//switch to frame to handle slider
		driver.switchTo().frame(frame);
		
		WebElement slider=driver.findElement(By.id("slider"));
		Actions actions=new Actions(driver);
		
		//slide forward 50px
		actions.clickAndHold(slider)
				.moveByOffset(50, 0)
				.release()
				.perform();

		Thread.sleep(Duration.ofSeconds(5));
		
		//slide backward 20px
		actions.clickAndHold(slider)
				.moveByOffset(-20, 0)
				.release()
				.perform();
		
		Thread.sleep(Duration.ofSeconds(10));
	    System.out.println("Closing all the browser windows...!");
	    driver.quit();
		
	}

}
