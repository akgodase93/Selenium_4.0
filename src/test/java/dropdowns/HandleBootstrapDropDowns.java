package dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class HandleBootstrapDropDowns {

	public static void main(String[] args) throws InterruptedException {
		
		final String ANSI_BOLD="\u001B[1m"+"\u001b[32m";
		final String ANSI_RESET="\u001B[0m";;
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/"); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(driver.findElement(By.xpath("//h1")).getText());
		//driver.findElement(By.id("comboTree665745ArrowBtn")).click();
		driver.findElement(By.cssSelector("button#comboTree23262ArrowBtn span")).click();
		
		//driver.findElement(By.xpath("//button[@id='comboTree480292ArrowBtn']//span[@class='comboTreeArrowBtnImg']")).click();
		//List<WebElement> dropdown=driver.findElements(By.xpath("//div[@id='comboTree943209DropDownContainer']"));
		List<WebElement> dropdown=driver.findElements(By.xpath("//div[@id='comboTree665745DropDownContainer']/ul/li[1]"));
	
		System.out.println(dropdown.size());
		
		driver.findElement(By.xpath("//button[@id='comboTree665745ArrowBtn']")).click();		
		Thread.sleep(Duration.ofSeconds(5));
	    System.out.println(ANSI_BOLD+"\nClosing all the browser windows...!"+ANSI_RESET);
	    driver.quit();
		
	}
}
