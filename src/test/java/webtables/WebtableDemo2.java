package webtables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WebtableDemo2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://blazedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement depCity=driver.findElement(By.xpath("//select[@name='fromPort']"));
		Select sel=new Select(depCity);
		sel.selectByVisibleText("Mexico City");
		
		WebElement destCity=driver.findElement(By.xpath("//select[@name='toPort']"));
		sel=new Select(destCity);
		sel.selectByVisibleText("London");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//LinkedList<WebElement> allPrices=(LinkedList<WebElement>) driver.findElements(By.xpath("//table/tbody/tr/td[6]"));
		
		List<WebElement> columnValues = driver.findElements(By.xpath("//table/tbody/tr"));
		Double min = Double.MAX_VALUE;
		
		int index=-1;
		
		for(int i=1; i<=columnValues.size(); i++)
		{
			//String price=columnValues.get(i).getText().trim();
			
			String price=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText();
			//System.out.println(price);
			price=price.replace("$", "");
			Double val=Double.parseDouble(price);
			if (val < min) {
				 min = val;
				 index=i;
				 		 
			}
		}
		Thread.sleep(Duration.ofSeconds(3));
		driver.findElement(By.xpath("//table/tbody/tr["+index+"]/td[1]/input")).click();
		System.out.println(index);
		System.out.println("Minimum value: " + min);
		
		driver.quit();
	}

}
