package seleniumWaits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaits {

    public static void main(String[] args) throws InterruptedException {

    	System.out.println("Programming Started...");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement password=fluentWait.until(webDriver->webDriver
        		.findElement(By.xpath("//input[@name='password']"))
        		
        							);
        
        /*WebElement password = fluentWait.until(webDriver -> {
            try {
                WebElement element =
                        webDriver.findElement(By.xpath("//input[@name='password']"));
                return element.isDisplayed() ? element : null;
            } catch (NoSuchElementException e) {
                return null; // 🔑 allows FluentWait retry
            }
        });*/

        password.sendKeys("admin123");

        Thread.sleep(5000);
        System.out.println("Closing all the browser windows...!");
        driver.quit();
    }
}
