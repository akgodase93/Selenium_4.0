package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickAction {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.switchTo().frame("iframeResult");
		WebElement box1=driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement box2=driver.findElement(By.xpath("//input[@id='field2']"));
		WebElement button=driver.findElement(By.xpath("//button[text()='Copy Text']"));
		
		box1.clear();
		box1.sendKeys("Welcome!");
		
		Thread.sleep(Duration.ofSeconds(5));
		
		String text1=box1.getAttribute("value");
		
		Actions actions= new Actions(driver);
		
		//Double click on button
		actions.doubleClick(button).perform();
		
		//String text2=box2.getText(); //text is not inner text in this element so it will be empty
		
		String text2=box2.getAttribute("value");
		
		
		System.out.println("Text1: "+text1+"\nText2: "+text2);
		if(text1.equals(text2))
		{
			System.out.println("Text Copied: "+text2);
		}
		else
		{
			System.out.println("Text not copied..");
		}
		
		Thread.sleep(Duration.ofSeconds(5));
	    System.out.println("Closing all the browser windows...!");
	    driver.quit();
	}

}
