package checkboxes;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class HandlingCheckboxes {

	public static void main(String[] args) throws InterruptedException {
		
		final String ANSI_BOLD = "\u001B[1m"+"\u001B[32m";
		final String ANSI_RESET = "\u001B[0m";
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//select the checkbox
		WebElement checkbox=driver.findElement(By.xpath("//input[@id='monday']"));
		System.out.println("Before selecting: "+checkbox.isSelected());
		checkbox.click();
		System.out.println("Before selecting: "+checkbox.isSelected());
		
			
		//uncheck check box safely
		System.out.println(ANSI_BOLD+"\nUncheck check box safely"+ANSI_RESET);
		if(checkbox.isSelected())
		{
			checkbox.click();
			System.out.println("Monday checkbox unchecked..");
		}
		
		//capturing all the checkboxes
		 List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		 System.out.println("\nCheckbox Count: "+checkboxes.size());
		 for(int i=0;i<checkboxes.size(); i++)
		 {
			checkboxes.get(i).click();
		 }
		 
		 Thread.sleep(2000);
		 //Uncheck all the selected checkboxes using for..each loop
		 System.out.println(ANSI_BOLD+"\nUncheck all the selected checkboxes using for..each loop"+ANSI_RESET);
		 for(WebElement cb: checkboxes)
		 {
			 cb.click();
			 System.out.println("Checkbox "+cb.getAccessibleName()+" Unchecked");
		 }
		
		 Thread.sleep(2000);
		 System.out.println(ANSI_BOLD+"\nCheck last 3 checkboxes: "+ANSI_RESET );
		 
		 int startIndex=checkboxes.size()-3; //7-3=4
		 
		 for(int i=startIndex; i< checkboxes.size();i++)
		 {
			 checkboxes.get(i).click();
			 System.out.println("Checked "+checkboxes.get(i).getAccessibleName()+" checkbox");
		 }
		 System.out.println(ANSI_BOLD+"Checked last 3 checkboxes"+ANSI_RESET);
		 
		 Thread.sleep(Duration.ofSeconds(5));
		//uncheck all check box safely only if selected already 
		 System.out.println(ANSI_BOLD+"\nUncheck all check box safely only if selected already or select if already unchecked:"+ANSI_RESET);
			for(WebElement cb: checkboxes)
			{
				if(cb.isSelected())
				{
					cb.click();
					System.out.println("Selected checkbox "+cb.getAccessibleName()+" unchecked..");
				}
				
				else
				{
					cb.click();
					System.out.println("Un-checked checkbox "+cb.getAccessibleName()+" checked..");
				}	
			}
		 
		 Thread.sleep(Duration.ofSeconds(5));
	     System.out.println(ANSI_BOLD+"\nClosing all the browser windows...!"+ANSI_RESET);
	     driver.quit();
	}
}
