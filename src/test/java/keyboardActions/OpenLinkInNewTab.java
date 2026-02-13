package keyboardActions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpenLinkInNewTab {

	static WebDriver driver;
	static String url="https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/";
	static By regLinkLocator=By.xpath("//a[@href='/about/' and @class='testimonial-icon']");
	static By subscribeEmailLocator=By.xpath("//input[@id='subscribe_email']");
	static By searchBoxLocator =By.xpath("//input[@name='q']");
	
	
	public static void main(String[] args) throws InterruptedException {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Control+Reglink
			WebElement regLink=driver.findElement(regLinkLocator);
			Actions actions=new Actions(driver);
			
		// Just to hover over registration link and not mandatory
			actions.moveToElement(regLink).perform();
			Thread.sleep(3000);
			
		//press control button +click on web element
			actions.keyDown(Keys.CONTROL).click(regLink).keyUp(Keys.CONTROL).perform();
		
		//switching to registration page
			List<String> allHandles=new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(allHandles.get(1));
		
		
		//Send values to email box on about page
			WebElement subscribeEmail=driver.findElement(subscribeEmailLocator);
			subscribeEmail.sendKeys("max@phppot.com");
			
			Thread.sleep(5000);
		//Return back to Home page
			driver.switchTo().window(allHandles.get(0));
		
		//search in search box with item called PHP
			WebElement serachBox=driver.findElement(searchBoxLocator);
			serachBox.clear();
			serachBox.sendKeys("PHP");
			
		//hit Enter using Actions class methods
			actions.sendKeys(Keys.ENTER).perform();
			
		//clean up operations	
			Thread.sleep(Duration.ofSeconds(10));
		    System.out.println("Closing all the browser windows...!");
		    driver.quit();
	
		  
		    
	}
}
