package framess;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class FramesDemo {

	public static void main(String[] args) throws InterruptedException 
	{
		final String ANSI_BOLD="\u001B[1m" + "\u001B[32m";
		final String ANSI_RESET="\u001B[0u";
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ui.vision/demo/webtest/frames/");
		
		WebElement frame1=driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		
		//switch to frame1
		//There are 4 ways to switch to frame
		//1.Switch By frame id
		//2.Switch by frame name
		//3.Switch by index[Not reliable so not recommended]
		//4.Switch by WebElement[Recommended]
		driver.switchTo().frame(frame1); //here frame1 is WebElement
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Welcome");
		driver.switchTo().defaultContent();
		
		WebElement frame2=driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Automation");
		driver.switchTo().defaultContent();
		
		WebElement frame3=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Programming");
		
		//Switching to nested/Inner frame
		driver.switchTo().frame(0);  //here 0 is index
		driver.findElement(By.xpath("//span[contains(text(),'I am a human')]")).click();
		
		
		Thread.sleep(Duration.ofSeconds(5));
	    System.out.println(ANSI_BOLD+"\nClosing all the browser windows...!"+ANSI_RESET);
	    driver.quit();
		
	}
}
