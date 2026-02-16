package chromeOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DisableBrowserNotfications {

	 public static void main(String[] args) {

	        ChromeOptions options = new ChromeOptions();

	        options.addArguments("--disable-notifications");
	        options.addArguments("--disable-infobars");
	        options.addArguments("--disable-save-password-bubble");

	        WebDriver driver = new ChromeDriver(options);
	        driver.get("https://google.com");
	    }
}
