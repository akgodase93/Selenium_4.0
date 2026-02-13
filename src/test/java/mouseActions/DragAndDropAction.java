package mouseActions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DragAndDropAction {
	static WebDriver driver;
	
	
	public static void main(String[] args) throws InterruptedException {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://codepen.io/EpsilonDeltaCriterion/pen/jLoPgE");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.switchTo().frame("result");
		Actions actions=new Actions(driver);
		
		//oslo to norway drag and drop
			WebElement oslo=driver.findElement(By.id("box1"));
			WebElement norway=driver.findElement(By.id("box101"));
			
			actions.dragAndDrop(oslo, norway).perform();
		
		//Thread.sleep(Duration.ofSeconds(5));
		
		//oslo to norway drag and drop
			WebElement washington=driver.findElement(By.id("box3"));
			WebElement usa=driver.findElement(By.id("box103"));
			
			actions.dragAndDrop(washington, usa).perform();
		
			System.out.println("Drag and Drop scucessfull..!");
			
			Thread.sleep(Duration.ofSeconds(5));
		    System.out.println("Closing all the browser windows...!");
		    driver.quit();
	}

}
