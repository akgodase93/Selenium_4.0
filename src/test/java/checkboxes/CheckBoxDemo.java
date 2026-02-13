package checkboxes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxDemo {
	public static void main(String[] args) throws InterruptedException {
		
		final String ANSI_BOLD="\u001B[1m" + "\u001B[32m";
		final String ANSI_RESET="\u001B[0m";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practicesoftwaretesting.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//List<WebElement> checkboxes=driver.findElements(By.xpath("//label[text()=' Hammer ']/parent:: div/parent::fieldset/child::div"));
		List<WebElement> checkboxes=driver.findElements(By.xpath("//label[text()=' Hammer ']/parent:: div/parent::fieldset//input"));
		System.out.println(ANSI_BOLD+"Hand Tools Child checkbox size: "+ANSI_RESET+checkboxes.size());
		
		System.out.println(ANSI_BOLD+"Selecting all the Hand Tools Child checkboxes: "+ANSI_RESET);
		for(WebElement wb: checkboxes)
		{
			wb.click();
			System.out.println("Checked Checkbox"+wb.getAccessibleName());
		}
		
		Thread.sleep(Duration.ofSeconds(2));
		List<WebElement> mybrandChk=driver.findElements(By.xpath("//label[text()=' ForgeFlex Tools']/parent::div/parent::fieldset//input"));
		System.out.println(ANSI_BOLD+"Selecting the second checkbox from By brand checkboxes: "+ANSI_RESET);
		for(WebElement wb: mybrandChk)
		{
			if(wb.getAccessibleName().contains(" MightyCraft Hardware"))
			{
				wb.click();
				System.out.println("Checked Checkbox"+wb.getAccessibleName());
			}
			else
			{
				System.out.println("Not Found!");
			}
			
		}
		
		
		Thread.sleep(Duration.ofSeconds(5));
	    System.out.println(ANSI_BOLD+"\nClosing all the browser windows...!"+ANSI_RESET);
	    driver.quit();
	}

}
