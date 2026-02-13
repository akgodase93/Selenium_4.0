package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropBySlider {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/slider/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		WebElement frame=driver.findElement(By.xpath("//iframe"));
		//switch to frame to handle slider
		driver.switchTo().frame(frame);
		
		WebElement slider=driver.findElement(By.id("slider"));
		
		
		Actions actions=new Actions(driver);
		//moving slider forward horizontally by 50px 
		System.out.println("moving slider forward horizontally by 50px ");
		actions.dragAndDropBy(slider, 50, 0).perform();
		
		Thread.sleep(Duration.ofSeconds(5));
		
		//moving slider backward horizontally by 20px 
		System.out.println("moving slider backward horizontally by 20px");
		actions.dragAndDropBy(slider, -20, 0).perform();
		
		System.out.println("Done!!");
		
		Thread.sleep(Duration.ofSeconds(10));
	    System.out.println("Closing all the browser windows...!");
	    driver.quit();
		
	}
}
