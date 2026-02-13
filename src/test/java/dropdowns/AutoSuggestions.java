package dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoSuggestions {
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("Selenium");
		List<WebElement> options=driver.findElements(By.xpath("//ul[@role='listbox']//div/div/div/span"));
		
		String choice="selenium";
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		for(WebElement wb: options)
		{
			if(wb.getText().equalsIgnoreCase(choice))
			{
				wait.until(ExpectedConditions.elementToBeClickable(wb)).click();
				
				//wb.click();
			}
			else
			{
				System.out.println("Choice not found!!");
			}
		}
	}

}
