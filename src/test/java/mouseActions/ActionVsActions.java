package mouseActions;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionVsActions {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement button=driver.findElement(By.xpath("//span[contains(text(),'right click')]"));
		
		Actions actions=new Actions(driver);			//Actions is a class where as Action is interface
		Action rightClick=actions.contextClick(button)	//build() method builds /creates or compiles the actions and
				.build(); 								//store in reference variable of type Action interface
																
		rightClick.perform();  //performs or executes the action
		
		Thread.sleep(Duration.ofSeconds(5));
	    System.out.println("Closing all the browser windows...!");
	    driver.quit();
		
	}
}
