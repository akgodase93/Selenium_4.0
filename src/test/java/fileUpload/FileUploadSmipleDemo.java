package fileUpload;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadSmipleDemo {

	public static void main(String[] args) throws InterruptedException {
		
		String filePath=System.getProperty("user.dir")+"\\src\\test\\resources\\InputFiles\\";
		String file1="test2.txt";
		String file2="test2.txt";
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		
		//selecting one or single file
		driver.findElement(By.id("filesToUpload")).sendKeys(filePath+file1);
		Thread.sleep(5000);
		
		if(driver.findElement(By.xpath("//ul[@id='fileList']/li")).getText().equals(file1))
		{
			System.out.println("Single File uploaded successfuly!!!");
		}
		else
		{
			System.out.println("File uploading failed..!!!");
		}
		
		Thread.sleep(5000);
		driver.findElement(By.id("filesToUpload")).clear();
		
		//Selecting multiple files
		
		driver.findElement(By.id("filesToUpload")).sendKeys(filePath+file1+"\n"+filePath+file2);
		
		if(driver.findElements(By.xpath("//ul[@id='fileList']/li")).size()==2)
		{
			System.out.println("Both Files uploaded successful!!! and file count is matching");
		}
		else
		{
			System.out.println("File uploading failed..!!!");
		}
		
		if(driver.findElement(By.xpath("//ul[@id='fileList']/li[1]")).getText().equals(file1) && driver.findElement(By.xpath("//ul[@id='fileList']/li[2]")).getText().equals(file2) )
		{
			System.out.println("file names are matching");
		}
		else
		{
			System.out.println("file names are not matching..!!!");
		}
		
		
		// cleanup
		Thread.sleep(Duration.ofSeconds(10));
	    System.out.println("Closing all the browser windows...!");
	    driver.quit();
	}
}
