package dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartAutoSuggestion {

	public static void main(String[] args) throws InterruptedException {
		
		final String ANSI_BOLD="\u001B[1m"+"\u001b[32m";
		final String ANSI_RESET="\u001B[0m";
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@name='q'][1]")).sendKeys("Vivo");
		List<WebElement> options=driver.findElements(By.xpath("//ul/li/div/a/div[2]"));
		
		
		String option="vivo t4 5g";
		for(WebElement wb:options)
		{
			System.out.println(wb.getText());
			if(wb.getText().equals(option))
			{
				wait.until(ExpectedConditions.elementToBeClickable(wb)).click();
				//wb.click();
				break;
			}
		}
		
		Thread.sleep(Duration.ofSeconds(5));
	    System.out.println(ANSI_BOLD+"\nClosing all the browser windows...!"+ANSI_RESET);
	    driver.quit();
	}
}
