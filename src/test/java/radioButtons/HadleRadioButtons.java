package radioButtons;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class HadleRadioButtons {

	public static void main(String[] args) throws InterruptedException {
		final String ANSI_BOLD = "\u001B[1m"+"\u001B[31m";
		final String ANSI_RESET = "\u001B[0m";
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement male=driver.findElement(By.xpath("//input[@id='male']"));
		WebElement female=driver.findElement(By.xpath("//input[@id='female']"));
		
		System.out.println(ANSI_BOLD+"Before selecting male radio buttons: "+ANSI_RESET);
		System.out.println("Male Radio Button: "+male.isSelected());
		System.out.println("Male Radio Button: "+female.isSelected());
		
		male.click();
		
		System.out.println(ANSI_BOLD+"\nAfter selecting male radio buttons: "+ANSI_RESET);
		System.out.println("Male Radio Button: "+male.isSelected());
		System.out.println("Male Radio Button: "+female.isSelected());
		
		Thread.sleep(Duration.ofSeconds(5));
	     System.out.println(ANSI_BOLD+"\nClosing all the browser windows...!"+ANSI_RESET);
	     driver.quit();
	}
}

