package radioButtons;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RadioButtonDemo {

	public static void main(String[] args) throws InterruptedException {
		
		final String ANSI_BOLD="\u001B[1m" + "\u001B[32m";
		final String ANSI_RESET="\u001B[0m";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/radio-buttons");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement r=driver.findElement(By.cssSelector("#red"));
		//WebElement r=driver.findElement(By.xpath("//input[@id='red']")); //not working as expected so changed to css selector
		System.out.println(ANSI_BOLD+"Before Selecting Red Radio Button: "+ANSI_RESET+r.isSelected());
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		try 
		{
			//ExpectedConditions.elementToBeClickable(By.cssSelector("#red") 
			WebElement red=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#red")));
			//WebElement red=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("red")));
			red.click();
			//r.click();
			System.out.println("After Selecting Red Radio Button: "+r.isSelected());
		
			
		}
		catch(ElementClickInterceptedException e)
		{
			System.out.println("WebElement is not clickable");
			e.printStackTrace();
		}

		List<WebElement> radioButtons=driver.findElements(By.xpath("//input[@type='radio' and @name='color']"));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@type='radio' and @name='color']")));
		System.out.println(ANSI_BOLD+"Count of Radio Buttons: "+ANSI_RESET+radioButtons.size());
		
		for(WebElement rb: radioButtons)
		{
			if(rb.isSelected())
			{
				System.out.println("Selected color button is: "+rb.getAccessibleName());
			}
		}
		
		Thread.sleep(Duration.ofSeconds(5));
	    System.out.println(ANSI_BOLD+"\nClosing all the browser windows...!"+ANSI_RESET);
	    driver.quit();
		
	}
}
