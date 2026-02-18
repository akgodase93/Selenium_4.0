package ddf;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testUtils.BrowserUtils;
import utils.ExcelUtils;

public class CITBankCDCalculator {
	
	public static void main(String[] args) throws InterruptedException, IOException  {
		
		String url="https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator";
		WebDriver driver=new ChromeDriver();
		BrowserUtils.launchBrowser(driver, url);
		
		//closing cookies pop-up
		driver.findElement(By.xpath("//div[@id='onetrust-close-btn-container']/button")).click();
		
		String filePath="src/test/resources/InputFiles/Excel/";
		String fileName="caldata_citbank_2.xlsx";
		
		FileInputStream file=new FileInputStream(filePath+fileName);
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		String  sheet=workbook.getSheetName(0);
		
		WebElement amountText=driver.findElement(By.id("mat-input-0"));
		WebElement months=driver.findElement(By.id("mat-input-1"));
		//WebElement apy=driver.findElement(By.id("mat-input-2"));
		
		
		String sheet1=sheet.toString();
		int noOfRows=ExcelUtils.getRowCount(filePath+fileName, "Sheet1");
		
		for(int i=1; i<noOfRows; i++)
		{
			String initialDepositAmount=ExcelUtils.getCellData(filePath+fileName, sheet1, i, 0);
			String periodInMonths=ExcelUtils.getCellData(filePath+fileName, sheet1, i, 2);
			String interestRate=ExcelUtils.getCellData(filePath+fileName, sheet1, i, 1);
			String compounding_Type=ExcelUtils.getCellData(filePath+fileName, sheet1, i, 3);
			String total_amount=ExcelUtils.getCellData(filePath+fileName, sheet1, i, 4);
			
			@SuppressWarnings("unused")
			String expected=ExcelUtils.getCellData(filePath+fileName, sheet1, i, 5);
			@SuppressWarnings("unused")
			String result=ExcelUtils.getCellData(filePath+fileName, sheet1, i, 6);
			
			if(i==0)
			{
				System.out.println();
				continue;
			}
			
			workbook.close();
			file.close();
			Thread.sleep(3000);
			
			Actions act=new Actions(driver);
			
			amountText.clear();
			amountText.sendKeys(initialDepositAmount);
			
			months.clear();
			months.sendKeys(periodInMonths);
			
			act.sendKeys(Keys.TAB).perform();
			Thread.sleep(3000);
			//apy.clear();
			//apy.sendKeys(interestRate);
			//apy.sendKeys(String.valueOf(interestRate)); //this will not work as field accepts only numeric values
															//We cant send numeric values to sendKeys method without converting it to String
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("arguments[0].value='2';", apy);
			//js.executeScript("arguments[0].value='"+interestRate+"';", apy);
			act.sendKeys(interestRate).perform();
			//act.sendKeys(Keys.TAB).perform();
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='mat-select-value-1']")).click();
			
			
			List<WebElement> compoundings = driver.findElements(By.xpath("//div[@role='listbox']/mat-option/span[normalize-space(text()='Compounded Quarterly')]"));
			for(WebElement compound: compoundings)
			{
				//System.out.print("element text"+compound.getText());
				if(compound.getText().equals(compounding_Type))
				{
					compound.click();
					break;
				}
			}
			
			WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10));
			mywait.until(ExpectedConditions.elementToBeClickable(By.id("CIT-chart-submit"))).click(); 
			String totalValue=driver.findElement(By.id("displayTotalValue")).getText();
			
			
			String cleaned = total_amount.replaceAll("[^0-9.-]", "");
			double amount = Double.parseDouble(cleaned);
			//System.out.print("Total Displayed Value: "+amount);
			
			cleaned=totalValue.replaceAll("[^0-9.-]", "");
			//System.out.println("total amount"+amount+"\t total_displayed_amount: "+Double.parseDouble(cleaned));
			if(amount==Double.parseDouble(cleaned))
			{
				//System.out.println("Test passed..!");
				ExcelUtils.setCellData(filePath+fileName, sheet1, i, 6, "Pass");
				ExcelUtils.fillGreenColor(filePath+fileName, sheet1, i,6);
				
			}
			else
			{
				//System.out.println("Test failed..!");
				ExcelUtils.setCellData(filePath+fileName, sheet1, i, 6, "Fail");
				ExcelUtils.fillRedColor(filePath+fileName, sheet1, i,6);
				
			}
			
			Thread.sleep(Duration.ofSeconds(2));
		}
		Thread.sleep(Duration.ofSeconds(10));
		BrowserUtils.quitBrowser(driver);

	}

	
}
