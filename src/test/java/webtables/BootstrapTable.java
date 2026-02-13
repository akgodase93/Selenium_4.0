package webtables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BootstrapTable {

	public static void main(String[] args) throws InterruptedException {
		
		final String ANSI_BOLD = "\u001B[1m" + "\u001B[32m";
		final String ANSI_RESET = "\u001B[0m";
		
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Thread.sleep(3000);
		WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
		username.clear();
		username.sendKeys("Admin");
		
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		password.clear();
		password.sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Row locator
		By rowsLocator = By.xpath("//div[@class='oxd-table-body']/div");

		// Checkbox locator per row
		By checkboxLocator = By.xpath(".//label");

		// Username column locator
		By userLocator = By.xpath(".//div[@class='oxd-table-cell oxd-padding-cell'][2]");
		
		
		// User Role column locator
		By userRole = By.xpath(".//div[@class='oxd-table-cell oxd-padding-cell'][3]");
		
		// Employee Name locator
		By ename = By.xpath(".//div[@class='oxd-table-cell oxd-padding-cell'][4]");
		
		// Status locator
		By status = By.xpath(".//div[@class='oxd-table-cell oxd-padding-cell'][5]");
				
		

		// Fetch rows
		List<WebElement> rows = wait.until(
		        ExpectedConditions.presenceOfAllElementsLocatedBy(rowsLocator)
		);

		System.out.println(ANSI_BOLD+"Checkbox is Selcted?\tUsername\tUser Role\tEmployee Name"
				+ "\tStatus"+ANSI_RESET);
		for (WebElement row : rows) {

		    // Click checkbox
		    WebElement checkbox = row.findElement(checkboxLocator);
		    if (checkbox.isDisplayed() && checkbox.isEnabled()) {
		        wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
		        //System.out.print(checkbox.isSelected()+"\t");
		    }

		    // Get username
		    WebElement user = row.findElement(userLocator);
		    //System.out.print(user.getText()+"\t");
			    
			 // Get Role
			    WebElement role = row.findElement(userRole);
			    //System.out.print(role.getText()+"\t");
			    
			 // Get Name
			    WebElement name = row.findElement(ename);
			    //System.out.print(name.getText()+"\t");
			    
			 // Get status
			    WebElement stat = row.findElement(status);
			    //System.out.print(stat.getText()+"\n");
		    
			    System.out.print(checkbox.isSelected()+"\t\t\t"+user.getText()+"\t"+role.getText()+"\t"+name.getText()+"\t"+stat.getText()+"\n");
		}
		
		Thread.sleep(Duration.ofSeconds(5));
	    System.out.println(ANSI_BOLD+"\nClosing all the browser windows...!"+ANSI_RESET);
	    driver.quit();
	}
}