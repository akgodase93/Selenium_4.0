package chromeOptions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleSSL {

public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options=new ChromeOptions();

		//To handle SSL certs
		options.setAcceptInsecureCerts(true);
		
		
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://expired.badssl.com/");
		System.out.println("Browser launched with OrangeHRM login page open");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// cleanup
				Thread.sleep(Duration.ofSeconds(10));
			    System.out.println("Closing all the browser windows...!");
			    driver.quit();
	}
}
