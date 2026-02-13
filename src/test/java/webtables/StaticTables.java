package webtables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTables {

	public static void main(String[] args) throws InterruptedException {
		
		final String ANSI_BOLD="\u001B[1m"+"\u001B[32m";
		final String ANSI_RESET="\u001B[0m";
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//1. No of rows
			int rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
			System.out.println(ANSI_BOLD+"No of Rows: "+ANSI_RESET+rows);
			
		//2. No of columns
			int columns=driver.findElements(By.xpath("//table[@name='BookTable']//tr/th")).size();
			System.out.println(ANSI_BOLD+"No of Rows: "+ANSI_RESET+columns);
			
		//3. Print specific row data 5th row 4th column
			
			String price=driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[4]")).getText();
			System.out.println(ANSI_BOLD+"Price:  "+ANSI_RESET+price);
			
			
		//4. Print all data from table 
			
			System.out.println(ANSI_BOLD+"BookName\tAuthor\tSubject\tPrice"+ANSI_RESET);
			for(int i=2; i<=rows; i++)
			{
				for(int j=1; j<=columns; j++)
				{
					
					String value=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td["+j+"]")).getText();
					System.out.print(value+"\t");
				}
				System.out.println();
			}
			System.out.println();
		//5. Print Book name whose author is Mukesh
			
			for(int i=2; i<=rows; i++)
			{
				String authorName=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[2]")).getText();
					if(authorName.equals("Mukesh"))
					{	
						String book=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[1]")).getText();
						System.out.println(authorName+"\t"+book);
						
					}
				
			}
			
		//6. Find total price of all the books
			List<WebElement> totalPrice=driver.findElements(By.xpath("//table[@name='BookTable']//tr/td[4]"));
			int tp=0;
			for(WebElement wb:totalPrice)
			{
				tp=tp+Integer.parseInt(wb.getText());
			}
			System.out.println(ANSI_BOLD+"Total price of all books is: "+ANSI_RESET+tp);
			
			
			Thread.sleep(Duration.ofSeconds(5));
		    System.out.println(ANSI_BOLD+"\nClosing all the browser windows...!"+ANSI_RESET);
		    driver.quit();
	}
}
