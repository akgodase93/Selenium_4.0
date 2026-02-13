package webtables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class DynamicWebTablesPagination {

	public static void main(String[] args) throws InterruptedException {
		final String ANSI_BOLD = "\u001B[1m" + "\u001B[32m";
		final String ANSI_RESET = "\u001B[0m";

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo3x.opencartreports.com/admin/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//Enter Username
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.clear();
		username.sendKeys("demo");

		//Enter Password
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.clear();
		password.sendKeys("demo");

		//Click on login button
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// Parent Sale menu click
		driver.findElement(By.xpath("//li[@id='menu-sale']/a")).click();
		// child sale menu click
		driver.findElement(By.xpath("//ul[@id='collapse4']/li[1]/a")).click();

		String s = driver.findElement(By.xpath("//div[contains(@class,'col-sm-6 text-right')]")).getText();
		// Showing 1 to 20 of 25 (2 Pages)

		// getting the no of total pagination in Integer format
		int noOfPages = Integer.parseInt(s.substring(s.indexOf("(") + 1, s.indexOf("Pages") - 1));
		System.out.println(ANSI_BOLD + "No of pages: " + ANSI_RESET + noOfPages);

		System.out.println(ANSI_BOLD + "OrderID\tCustomer Name\tOrder Status\tTotal Price" + ANSI_RESET);
		// repeating the no of pages
		for (int i = 1; i <= noOfPages; i++) {

			// click on next page
			if (i > 1) {
				WebElement currentPage = driver
						.findElement(By.xpath("//ul[@class='pagination']//*[text()='" + i + "']"));
				currentPage.click();
				Thread.sleep(Duration.ofSeconds(5));
			}

			// print the data from current page
			List<WebElement> maxRowsOnPage = driver
					.findElements(By.xpath("//table[contains(@class,'table ')]/tbody/tr"));

			// maximum rows in the current page table
			int maxrows = maxRowsOnPage.size();
			System.out.println(ANSI_BOLD + "No of rows in currrent page no " + i + " is :" + ANSI_RESET + maxrows);

			// reading all the rows of the current page
			for (int j = 1; j <= maxrows; j++) {

				WebElement checkBox = driver
						.findElement(By.xpath("//table[contains(@class,'table ')]/tbody/tr[" + j + "]/td[1]/input"));
				if (!checkBox.isSelected()) // click on checkbox only if its not checked already
				{
					checkBox.click();
				}

				String orderId = driver
						.findElement(By.xpath("//table[contains(@class,'table ')]/tbody/tr[" + j + "]/td[2]"))
						.getText();
				String custName = driver
						.findElement(By.xpath("//table[contains(@class,'table ')]/tbody/tr[" + j + "]/td[3]"))
						.getText();
				String status = driver
						.findElement(By.xpath("//table[contains(@class,'table ')]/tbody/tr[" + j + "]/td[4]"))
						.getText();
				String total = driver
						.findElement(By.xpath("//table[contains(@class,'table ')]/tbody/tr[" + j + "]/td[5]"))
						.getText();

				System.out.print(orderId + "\t" + custName + "\t" + status + "\t\t" + total + "\n");
			}

		}

		Thread.sleep(Duration.ofSeconds(10));
		System.out.println(ANSI_BOLD + "\nClosing all the browser windows...!" + ANSI_RESET);
		driver.quit();
	}
}
