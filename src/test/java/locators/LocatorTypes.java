package locators;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LocatorTypes {
	public static void main(String[] args) throws InterruptedException 
	{
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		//Locators Type
		//1. id
		//<input type="text" class="inputtext _55r1 _6luy" name="email" id="email" data-testid="royal-email" 
		//placeholder="Email address or phone number" autofocus="1" 
		//autocomplete="username webauthn" aria-label="Email address or phone number">
			driver.findElement(By.id("email")).sendKeys("rocky@fb.com");
		
		Thread.sleep(5000);
		//2. name
			driver.findElement(By.name("email")).clear();
			
		//3. class name//class="_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy"
			driver.findElement(By.className("_42ft")).click();
			//driver.findElement(By.className("img sp_GPvE0syHYuh sx_8e0301")).click();
			
			
		//4. tag name
			//<button value="1" class="_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy" 
			//name="login" data-testid="royal-login-button" type="submit" id="u_0_5_qQ">Log in</button>
			driver.findElement(By.tagName("button")).click();
			
		//5. linkText
			//<a href="https://www.facebook.com/recover/initiate/?privacy_mutation_token=eyJ0eXBlIjowLCJjcm
			//VhdGlvbl90aW1lIjoxNzcwMTM2NTgyLCJjYWxsc2l0ZV9pZCI6MzgxMjI5MDc5NTc1OTQ2fQ%3D%3D&amp;ars=facebook_login&amp;
			//next" id="u_0_6_PN">Forgotten password?</a>
			
			System.out.println("Forgotten password:  displayed?"+driver.findElement(By.linkText("Forgotten password?")).isDisplayed());
			
	
		//6. partialLinkText
			driver.findElement(By.partialLinkText("Forgotten pas")).click();
		//7. cssSelector-->check another class created
		//8. xpath-->check another class created
			Thread.sleep(5000);
			driver.quit();
	}

}
