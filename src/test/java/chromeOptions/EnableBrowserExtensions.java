package chromeOptions;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EnableBrowserExtensions 
{
public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("src/test/resources/CRX_Files/CRX-Downloader.crx"));

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com");
		
		// cleanup
				Thread.sleep(Duration.ofSeconds(30));
			    System.out.println("Closing all the browser windows...!");
			    driver.quit();
	}
}
