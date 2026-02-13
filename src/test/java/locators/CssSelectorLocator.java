package locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectorLocator {
	public static void main(String[] args)  throws Exception{
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		//1▪ Tag & ID     (OR) 
		//Syntax: tag#id or #id
			//driver.findElement(By.cssSelector("input#email")).sendKeys("radha@fb.com");
			driver.findElement(By.cssSelector("#email")).sendKeys("radha@fb.com");
			
			driver.navigate().to("https://demo.nopcommerce.com/");
		//2▪ Tag & class   (OR) .class
			System.out.println(driver.findElement(By.cssSelector(".skip")).isDisplayed());
			//driver.findElement(By.cssSelector(".skip")).click();
			
		//<input type="text" class="search-box-text ui-autocomplete-input ui-autocomplete-loading" id="small-searchterms" autocomplete="off" name="q" 
			//placeholder="Search store" aria-label="Search store" data-gtm-form-interact-field-id="0">	
		//3▪ Tag & attribute    (OR) [attribute=value]
			driver.findElement(By.cssSelector("[name='q']")).sendKeys("T-shirts");
			
			driver.navigate().to("https://www.orangehrm.com/");
		//4▪ Tag , class & attribute 
			//<input type="hidden" name="SecurityID" value="96a21ddc852100e229cc196c31c9415ecca674b7" 
			//class="hidden" id="Form_submitForm_SecurityID">
			System.out.println("By using CssSelector: Tag , class & attribute: "+driver.findElement(By.cssSelector(".hidden[name='SecurityID']")).isDisplayed());
			
			Thread.sleep(5000);
			driver.quit();
	}

}
