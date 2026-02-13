package dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		final String ANSI_BOLD="\u001B[1m"+"\u001b[32m";
		final String ANSI_RESET="\u001B[0m";;
		
		//launch browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//login steps
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//click on PIM menu
		driver.findElement(By.xpath("//span[contains(@class,'oxd-text') and text()='PIM']")).click();
		
		//click on list box
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[6]/div/div[2]/div/div")).click();
		
		List<WebElement> options=driver.findElements(By.xpath("//div[@role='listbox']//span"));
		//List<WebElement> options=driver.findElements(By.cssSelector("div[class='oxd-select-option'] span"));
		System.out.println("Options in listbox: "+options.size());
		
		System.out.println(ANSI_BOLD+"print all list options: "+ANSI_RESET);
		for(WebElement option: options)
		{
			System.out.println(option.getText());
		}
		
		//select option from list
		driver.findElement(By.xpath("//div[@class='oxd-select-option']/span[text()='Chief Technical Officer']")).click();
				
		Thread.sleep(Duration.ofSeconds(5));
	    System.out.println(ANSI_BOLD+"\nClosing all the browser windows...!"+ANSI_RESET);
	    driver.quit();
		
	}
}
