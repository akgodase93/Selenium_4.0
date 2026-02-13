package webtables;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class PaginationWebTablesDemo2 {
	public static void main(String[] args)throws InterruptedException {
		
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		final String ANSI_BOLD = "\u001B[1m" + "\u001B[32m";
		final String ANSI_RESET = "\u001B[0m";
		
		//Just an header to print table
		System.out.println(ANSI_BOLD+"ID\tName\t\tPrice\t\tCheckbox Selected??"+ANSI_RESET);
		
		int noOfpages=4; //given in webpage max 4 pages
		for(int i=1; i<=noOfpages; i++) //looping through all 4 pages
		{
			if(i>1)
			{
				WebElement pageNo=driver.findElement(By.xpath("//ul[@id='pagination']/li/a[text()='"+i+"']"));
				pageNo.click();
				Thread.sleep(Duration.ofSeconds(5));
			}
			
			
			//calculate no of maximum rows in current page
			List<WebElement> rowElements=driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));
			int rows=rowElements.size();
			
			//print the data row by row
			
			for(int j=1; j<=rows;j++)
			{
				String ID=driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+j+"]/td[1]")).getText();
				String name=driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+j+"]/td[2]")).getText();
				String price=driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+j+"]/td[3]")).getText();
				WebElement checkbox=driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+j+"]/td[4]/input"));
				if(!checkbox.isSelected())
				{
					checkbox.click();
				}
				
				System.out.print(ID+"\t"+name+"\t"+price+"\t"+checkbox.isSelected()+"\n");
				
			}
					
			
			
		}
		
		Thread.sleep(Duration.ofSeconds(10));
		System.out.println(ANSI_BOLD + "\nClosing all the browser windows...!" + ANSI_RESET);
		driver.quit();
		
	}

}
