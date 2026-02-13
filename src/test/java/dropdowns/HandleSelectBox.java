package dropdowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleSelectBox {

	public static void main(String[] args) throws InterruptedException {
		final String ANSI_BOLD="\u001B[1m"+"\u001b[32m";
		final String ANSI_RESET="\u001B[0m";;
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");  
		//steps to handle select box
		
		//1. Identify the list box and store it in reference variable
			
			WebElement list=driver.findElement(By.xpath("//select[@id='country']"));
			
		//2. Create an object of Select class which accepts WebElement as a argument
			Select select=new Select(list);
			
		//3. Use Select class  methods to select option from the list
			//3.1 selectByIndex(int index)
				select.selectByIndex(1); //Canada
				System.out.println("Selcted option is: "+select.getFirstSelectedOption().getAccessibleName());
				Thread.sleep(Duration.ofSeconds(2));
			//3.2 selectByVisibleText(String Text)
				select.selectByVisibleText("India");
				System.out.println("Selcted option is: "+select.getFirstSelectedOption().getAccessibleName());
				
				
				Thread.sleep(Duration.ofSeconds(2));
			//3.3 selectByValue(String Value)
				select.selectByValue("uk");
				System.out.println("Selcted option is: "+select.getFirstSelectedOption().getAccessibleName());
		
		//4. Print the size of listbox
				System.out.println(ANSI_BOLD+"Size of list Box: "+ANSI_RESET+(select.getOptions().size()));
				
				
		//5. Print all the options from list
				System.out.println(ANSI_BOLD+"Prinitng all the select box options: "+ANSI_RESET);
				for(WebElement option:select.getOptions())
				{
					System.out.println(option.getAccessibleName());
					
				}
				
		//6. Check if list is multi-selectabel or not
				System.out.println("List is multiselectable? "+select.isMultiple());
				
				
				Thread.sleep(Duration.ofSeconds(5));
			    System.out.println(ANSI_BOLD+"\nClosing all the browser windows...!"+ANSI_RESET);
			    driver.quit();
	}
}
