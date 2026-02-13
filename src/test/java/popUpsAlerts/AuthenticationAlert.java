package popUpsAlerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationAlert {

	public static void main(String[] args)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		String username="admin",password="admin";
		
		driver.get("https://"+username+":"+password+"@the-internet.herokuapp.com/basic_auth");
		
		String welcomeText=driver.findElement(By.xpath("//h3")).getText();
		if(welcomeText.equals("Basic Auth"))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failed");
		}
	}

}
	