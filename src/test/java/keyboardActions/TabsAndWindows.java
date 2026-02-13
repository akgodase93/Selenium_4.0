package keyboardActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabsAndWindows {

	public static void main(String[] args)
	{
			 WebDriver driver=new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.get("https://www.opencart.com/");
			 
			 driver.switchTo().newWindow(WindowType.TAB);//open new browser tab
			 //driver.switchTo().newWindow(WindowType.WINDOW); //open new browser window
			 
			 driver.get("https://opensource-demo.orangehrmlive.com/");
			 driver.manage().window().fullscreen();
	}
}
