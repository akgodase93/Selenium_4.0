package datepickers;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;



public class HandleDatePickers {

	private static WebDriver driver=new EdgeDriver();
	private static String currentMonth;
	private static String currentYear;
	private static By frameLocator=By.xpath("//iframe");
	private static By datePickerLocator=By.xpath("//input[@id='datepicker']");
	private static By monthLocator=By.xpath("//div[contains(@class,'ui-datepicker-title')]/span[1]");
	private static By yearLocator=By.xpath("//div[contains(@class,'ui-datepicker-title')]/span[2]");
	private static By dateLocator=By.xpath("//table[contains(@class,'ui-datepicker-calendar')]/tbody/tr/td");
	private static By nextLocator=By.xpath("//a[contains(@class, 'ui-datepicker-next ui-corner-all')]");
	private static By previousLocator=By.xpath("//a[contains(@class, 'ui-datepicker-prev ui-corner-all')]");
	
	final static String ANSI_BOLD = "\u001B[1m" + "\u001B[32m";
	final static String ANSI_RESET = "\u001B[0m";
	
	public  void launchBrowser()
	{
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void switchToFrame()
	{
		WebElement frame=driver.findElement(frameLocator);
		driver.switchTo().frame(frame);
		driver.findElement(datePickerLocator).click();
	}
	
	public static void futureDate(WebDriver driver, String date, String month, String year)
	{
		while(true)
		{
			driver.findElement(nextLocator).click();
			currentMonth=driver.findElement(monthLocator).getText();
			currentYear=driver.findElement(yearLocator).getText();
			
			System.out.println(currentMonth+"\t"+currentYear);
			
			if(currentMonth.equalsIgnoreCase(month) && currentYear.equalsIgnoreCase(year))
			{
				break;
			}
			
		}
		
		selectDate(driver, date);
	}
	
	
	
	public static void pastDatePicker(WebDriver driver, String date, String month, String year)
	{
		while(true)
		{
			driver.findElement(previousLocator).click();
			currentMonth=driver.findElement(monthLocator).getText();
			currentYear=driver.findElement(yearLocator).getText();
			
			if(currentMonth.equalsIgnoreCase(month) && currentYear.equalsIgnoreCase(year))
			{
				break;
			}
		}
		
		selectDate(driver, date);
	}
	
	
	public static void selectDate(WebDriver driver, String date)
	{
		//selecting date
				List<WebElement> allDates=driver.findElements(dateLocator);
				
				for(WebElement currentDate: allDates)
				{
					if(currentDate.getText().equalsIgnoreCase(date))
					{
						currentDate.click();
						break;
					}
				}
		
	}
	public static String dateChecker(String date)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate inputDate = LocalDate.parse(date, formatter);
        LocalDate today = LocalDate.now();

        if (inputDate.isBefore(today)) 
        {
            System.out.println("Past Date");
            return "pastDate";
        }
        else if (inputDate.isAfter(today)) 
        {
            System.out.println("Future Date");
            return "futureDate";
        }
        else
        {
            System.out.println("Today's Date");
            return "todaysDate";
        }
	}
	
	public static String[] extractDateParts(String dateStr) {

	    DateTimeFormatter inPutformatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    LocalDate date = LocalDate.parse(dateStr, inPutformatter);

	    DateTimeFormatter outputFormatter =
	            DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);
	    date.format(outputFormatter).toUpperCase();
	    
	    return new String[] {
	        String.valueOf(date.getDayOfMonth()),
	        String.valueOf(date.getMonthValue()),
	        String.valueOf(date.getYear())
	    };
	}	
	public static void main(String[] args) throws InterruptedException {
		
		HandleDatePickers hdp=new HandleDatePickers();
		
		hdp.launchBrowser();
		hdp.switchToFrame();
		
		String year="2027";
		String month="MAY";
		String date="18";
		
		futureDate(driver, date, month, year);
		//pastDatePicker(driver, date, month, year);
		
//		String[] parts = extractDateParts("11-03-2026");
//		
//		System.out.println("Day: " + parts[0]);
//		System.out.println("Month: " + parts[1]);
//		System.out.println("Year: " + parts[2]);
//		
//		String s=dateChecker("11-03-2026");
//		
//		
//		String year=parts[2];
//		String month=parts[1];
//		String date=parts[0];
//		
//		if(s.equalsIgnoreCase("pastDate"))
//		{
//			pastDatePicker(driver, date, month, year);
//		}
//		else if(s.equalsIgnoreCase("futureDate"))
//		{
//			futureDate(driver, date, month, year);
//		}
//		else
//		{
//			System.out.println("Code is yet to be written");
//		}
		
		Thread.sleep(Duration.ofSeconds(5));
	    System.out.println(ANSI_BOLD+"\nClosing all the browser windows...!"+ANSI_RESET);
	    driver.quit();
	}
}
