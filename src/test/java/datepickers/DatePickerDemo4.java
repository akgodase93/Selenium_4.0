package datepickers;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo4 {
	
	public static WebDriver driver;
	static String inputDate;
	public static String day;
	public static String month;
	public static String year;
	final static String ANSI_BOLD = "\u001B[1m" + "\u001B[32m";
	final static String ANSI_RESET = "\u001B[0m";
	
	public void launchBrowser()
	{
		driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
	}
	
	String getDate()
	{
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter date in format dd-MM-yyyy : ");
        inputDate = sc.nextLine();
        sc.close();
		return inputDate;
	}
	
	public static List<Object> parseUserDate() {
		
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate targetDate = LocalDate.parse(inputDate, inputFormatter);

        String day = String.valueOf(targetDate.getDayOfMonth());
        String month = targetDate.getMonth()
                .getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        String year = String.valueOf(targetDate.getYear());
		
	    return Arrays.asList(day, month, year, targetDate);
	}
	
	void selectDate(LocalDate targetDate )
	{
		while (true) {

            String currentMonth = driver.findElement(By.xpath("ui-datepicker-month")).getText();
            String currentYear = driver.findElement(By.className("ui-datepicker-year")).getText();

            if (currentMonth.equals(month) && currentYear.equals(year)) {
                break;
            }

            // Decide navigation direction
            LocalDate currentDisplayedDate = LocalDate.parse(
                    "01-" + currentMonth + "-" + currentYear,
                    DateTimeFormatter.ofPattern("dd-MMMM-yyyy", Locale.ENGLISH));

            if (targetDate.isAfter(currentDisplayedDate)) {
                driver.findElement(By.xpath("//a[@title='Next']")).click();
            } else {
                driver.findElement(By.xpath("//a[@title='Prev']")).click();
            }
        }
		
		  // Select day
        //driver.findElement(By.xpath("//td[not(contains(@class,'ui-datepicker-other-month'))]/a[text()='"+ day + "']")).click();
		
		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='"+day+"']")).click();
	}
	
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(Duration.ofSeconds(5));
	    System.out.println(ANSI_BOLD+"\nClosing all the browser windows...!"+ANSI_RESET);
	    driver.quit();
	}
	
	
	
	public static void main(String[] args) throws InterruptedException
	{

		DatePickerDemo4 dp4=new DatePickerDemo4();
		dp4.launchBrowser();
		inputDate=dp4.getDate();
		
		List<Object> details = parseUserDate();
		day=(String) details.get(0);
		month=(String) details.get(1);
		year=(String) details.get(2);
		LocalDate targetDate=(LocalDate) details.get(3);
		
		//for console purpose only
		System.out.println(details.get(0));
		System.out.println(details.get(1));
		System.out.println(details.get(2));
		 
		 // Open Date Picker 2
        driver.findElement(By.id("datepicker")).click();
        
		dp4.selectDate(targetDate);

		System.out.println(ANSI_BOLD+"Date Selected Successfully!!"+ANSI_RESET);
		
		dp4.tearDown();
		// driver.quit();  // Uncomment if you want browser to close automatically
		
	}
		
}
