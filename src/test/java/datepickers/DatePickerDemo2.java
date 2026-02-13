package datepickers;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo2 {

	private static WebDriver driver;
	private static By datePickerLocator =By.xpath("//input[@id='datepicker']");
	private static By monthLocator =By.xpath("//div[@class='ui-datepicker-title']/span[1]");
	private static By yearLocator =By.xpath("//div[@class='ui-datepicker-title']/span[2]");
	private static By nextLocator =By.xpath("//a[@class='ui-datepicker-next ui-corner-all']");
	private static By previousLocator =By.xpath("//a[@class='ui-datepicker-prev ui-corner-all']");
	private static By dateLocator=By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td");
	
	
	public void launchBrowser(WebDriver driver)
	{
		
		
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
	}
	public void method1(WebDriver driver)
	{
		//driver.findElement(datePickerLocator).click();
		driver.findElement(datePickerLocator).sendKeys("01/07/2023");
	}
	
//	//user defined method for converting month from string--->Month
//    static Month convertMonth(String month) {
//    	HashMap<String, Month> monthMap = new HashMap<String, Month>();
//
//        monthMap.put("January", Month.JANUARY);
//        monthMap.put("February", Month.FEBRUARY);
//        monthMap.put("March", Month.MARCH);
//        monthMap.put("April", Month.APRIL);
//        monthMap.put("May", Month.MAY);
//        monthMap.put("June", Month.JUNE);
//        monthMap.put("July", Month.JULY);
//        monthMap.put("August", Month.AUGUST);
//        monthMap.put("September", Month.SEPTEMBER);
//        monthMap.put("October", Month.OCTOBER);
//        monthMap.put("November", Month.NOVEMBER);
//        monthMap.put("December", Month.DECEMBER);
//        
//        Month vmonth = monthMap.get(month);
//
//        if (vmonth == null) {
//            System.out.println("Invalid Month...");
//        }
//
//        return vmonth;
//    }
    
   
    
	public void method2(WebDriver driver, String date, String month, String year)
	{
		//select year and month
		while(true)
		{
			driver.findElement(datePickerLocator).clear();
			driver.findElement(datePickerLocator).click();
			
			String displayedMonth=driver.findElement(monthLocator).getText();
			String displayedYear=driver.findElement(yearLocator).getText();
			
			System.out.println("displayedMonth: "+displayedMonth);
			System.out.println("displayedYear: "+displayedYear);
			
			System.out.println("Actual Month: "+month);
			System.out.println("Actual Year: "+year);
			
//			
//			//convert requiredMonth & displayMonth in to Month Objects
//			Month expectedMonth=convertMonth(month);
//			Month currentMonth=convertMonth(displayedMonth);
//	
//			
//			//compare
//			int result=expectedMonth.compareTo(currentMonth);
//			System.out.println("result post convert: "+result);
//			// 0   months are equal
//			//>0   future month
//			//<0   past
			
			int currentYear=2025;
			int result1=Integer.parseInt(displayedYear);
			System.out.println("result1 post convert: "+result1);
			
			if(result1<currentYear) //future
			{
				System.out.println("I am future");
				driver.findElement(nextLocator).click();
				
				if(displayedMonth.equalsIgnoreCase(month) && displayedYear.equalsIgnoreCase(year))
				{
					break;
				}
					
			}
			else if(result1>currentYear) //past
			{
				System.out.println("I am past");
				driver.findElement(previousLocator).click();
				if(displayedMonth.equalsIgnoreCase(month) && displayedYear.equalsIgnoreCase(year))
				{
						break;
				}
				
			}
			else
			{
				break;
			}
		}
		
		//select date
		List<WebElement> allDates=driver.findElements(dateLocator);
		for(WebElement dt: allDates)
		{
			if(dt.isEnabled() && dt.getText().equalsIgnoreCase(date))
			{
				dt.click();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		DatePickerDemo2 dp2=new DatePickerDemo2();
		driver=new ChromeDriver();
		dp2.launchBrowser(driver);
		dp2.method1(driver);
		Thread.sleep(Duration.ofSeconds(4));
		
		
		String requiredYear = "2025";
		String requiredMonth = "June";
		String requiredDate = "15";
		
		dp2.method2(driver,requiredDate,requiredMonth,requiredYear);
		
	}
}
