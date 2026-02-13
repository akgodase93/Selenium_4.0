package datepickers;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePickerDemo5 {

	public static void main(String[] args) throws InterruptedException {
		
		final String ANSI_BOLD = "\u001B[1m" + "\u001B[32m";
		final String ANSI_RESET = "\u001B[0m";
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Scanner sc=new Scanner(System.in);
		
		
		System.out.println("Enter the date in dd-MM-yyyy format: ");
		String inputDate=sc.nextLine();
		
		//parse the input date
		
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate targetDate = LocalDate.parse(inputDate, inputFormatter);

        System.out.println("targetDate: "+targetDate);
        String day = String.valueOf(targetDate.getDayOfMonth());
        String month = targetDate.getMonth()
                .getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        String year = String.valueOf(targetDate.getYear());
		
        System.out.println("Parsed Input Date: "+day+"\t"+month+"\t"+year);
        
        
		//open datepicker
		driver.findElement(By.id("txtDate")).click();
		
		//select month and year
		while(true)
		{
			String currentMonth=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']/option[@selected='selected']")).getText();
			String currentYear=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']/option[@selected='selected']")).getText();
			
			System.out.println("Current Month & Year: "+currentMonth+"\t"+currentYear);
			
			WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(30));
			if(currentMonth.equalsIgnoreCase(month) && currentYear.equalsIgnoreCase(year))
			{
				break;
			}
			 			
			 LocalDate currentDisplayedDate = LocalDate.parse(
	                    "01-" + currentMonth + "-" + currentYear,
	                    DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH));
			 
			 System.out.println("currentDisplayedDate: \t"+currentDisplayedDate);
			
			 
			//decide navigation(Prev/Next) 
			if(targetDate.isAfter(currentDisplayedDate))
			{
				//forward direction(click on next button)
				if(currentDisplayedDate.getMonth().equals(targetDate.getMonth()) && currentDisplayedDate.getYear()==targetDate.getYear())
				{
					break;
				}
				else
				{
					mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']"))).click();
					//driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']")).click();
				}
			}
			else
			{
				//forward direction(click on previous button)
				if(currentDisplayedDate.getMonth().equals(targetDate.getMonth()) && currentDisplayedDate.getYear()==targetDate.getYear())
				{
					break;
				}
				else
				{
					//driver.findElement(By.xpath("//a[@class='ui-datepicker-prev ui-corner-all']")).click();
					mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='ui-datepicker-prev ui-corner-all']"))).click();
				}
			}
		}
		//Select day
		
		List<WebElement> allDate=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		for(WebElement dt: allDate)
		{
			if(dt.getText().equalsIgnoreCase(day))
			{
				dt.click();
			}
		}
		
		
		sc.close();
		Thread.sleep(Duration.ofSeconds(5));
	    System.out.println(ANSI_BOLD+"\nClosing all the browser windows...!"+ANSI_RESET);
	    driver.quit();
	    
	}
}
