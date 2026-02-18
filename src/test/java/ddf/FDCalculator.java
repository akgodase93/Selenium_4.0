package ddf;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import utils.ExcelUtils;

public class FDCalculator {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.findElement(By.cssSelector("#wzrk-cancel")).click(); //click on no thanks pop-up
		String filePath="src/test/resources/InputFiles/Excel/caldata.xlsx";
		
		FileInputStream file=new FileInputStream(filePath);
		XSSFWorkbook workbook=new XSSFWorkbook();

		String sheetName="Sheet1";
		int noOfRows=ExcelUtils.getRowCount(filePath, "Sheet1");
		for(int i=0; i<noOfRows; i++)
		{
			//1. read data from excel
				String principle=ExcelUtils.getCellData(filePath, sheetName, i, 0);
				String roi=ExcelUtils.getCellData(filePath, sheetName, i, 1);
				String period=ExcelUtils.getCellData(filePath, sheetName, i, 2);
				String pType=ExcelUtils.getCellData(filePath, sheetName, i, 3);
				String frequency=ExcelUtils.getCellData(filePath, sheetName, i, 4);
				String maturity=ExcelUtils.getCellData(filePath, sheetName, i, 5);
				
				@SuppressWarnings("unused")
				String expected=ExcelUtils.getCellData(filePath, sheetName, i, 6);
				@SuppressWarnings("unused")
				String result=ExcelUtils.getCellData(filePath, sheetName, i, 7);
				
				if(i==0)//To print excel header & skip header validation 
				{
					System.out.println();
					continue;
					
				}
				workbook.close();
				file.close();
				
			//2 pass above data into application
				
				driver.findElement(By.cssSelector("#principal")).sendKeys(principle);
				driver.findElement(By.cssSelector("#interest")).sendKeys(roi);
				driver.findElement(By.cssSelector("#tenure")).sendKeys(period);
				
				
				Select periodType=new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
				periodType.selectByVisibleText(pType);
				
				
				Select freq=new Select(driver.findElement(By.cssSelector("#frequency")));
				freq.selectByVisibleText(frequency);
				
				WebElement calculate=driver.findElement(By.xpath("//div[@class='CTR PT15']/a[1]"));
				
				Wait<WebDriver> wait=new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20))
															 .pollingEvery(Duration.ofSeconds(2))
															 .ignoring(ElementClickInterceptedException.class);
				wait.until(ExpectedConditions.elementToBeClickable(calculate));
				calculate.click();
				
				String actualMaturityValue=driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();
				
			//3. validation
				if((Double.parseDouble(actualMaturityValue))== Double.parseDouble(maturity))
						{
							//System.out.println("Test Passed");
							ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Pass");
							ExcelUtils.fillGreenColor(filePath, "Sheet1", i, 7);
						}
				
				else
					{
							//System.out.println("Test Passed");
							ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Fail");
							ExcelUtils.fillRedColor(filePath, "Sheet1", i, 7);
					}
				
			//4. Clear the appdata for next iteration
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@class='CTR PT15']/a[2]")).click();
		}
		System.out.println("Excel sheet updated with test status...!");
		
		//cleanup
		Thread.sleep(Duration.ofSeconds(10));
	    System.out.println("Closing all the browser windows...!");
	    driver.quit();
	}

}
