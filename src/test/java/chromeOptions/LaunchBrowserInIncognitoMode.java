package chromeOptions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchBrowserInIncognitoMode {

	
public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options=new ChromeOptions();

		//To open browser in incognito/private mode
		options.addArguments("--incognito");
		
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("Browser launched with OrangeHRM login page open");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// cleanup
				Thread.sleep(Duration.ofSeconds(10));
			    System.out.println("Closing all the browser windows...!");
			    driver.quit();
	}
}
