package brokenLinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * 
 
1) Link    href="https://xyz.com"
2) https://xyz.com ---> server ---> status code
3)  status code>=400   broken link
 	status code <400   not a broken link
 
 * 
 */
public class HandleBrokenLinks {
	
	static final String ANSI_BOLD="\u001B[1m"+"\u001B[32m";
	static final String ANSI_RESET="\u001B[0m";
	static final String red="\u001B[31m";
	
//	final String ANSI_BOLD="\u001B[1m" + "\u001B[32m";
//	final String ANSI_RESET="\u001B[0m";
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.deadlinkcity.com/");
		
		//capture all the links from website
		List<WebElement> allLinks=driver.findElements(By.tagName("a"));
		System.out.println(ANSI_BOLD+"No of links on pgae: "+ANSI_RESET+allLinks.size());
		
		//iterating through all links for validation
		int noOfBrokenLinks=0;
		for(WebElement link: allLinks)
		{
			String href=link.getAttribute("href");
			
			
			if(href.isEmpty() || href==null)
			{
				System.out.println("Not possible to handle link or href value in link is not available");
				continue;
			}
			
			//hit url to the server
			try {
				
				@SuppressWarnings("deprecation")
				URL url=new URL(href); //convert String to URL object
				HttpURLConnection con=(HttpURLConnection) url.openConnection(); // open connection to the server
				int responce = con.getResponseCode();
				
				if(responce>400)
				{
					System.out.println(ANSI_BOLD+"Link is broken =>"+ANSI_RESET+href);
					noOfBrokenLinks++;
				}
				else
				{
					System.out.println(ANSI_BOLD+"Link is not broken =>"+ANSI_RESET+href);
				}
			
			}
			catch(Exception e)
			{
				System.out.println(red +"Something went wrong: "+e.getMessage()+ANSI_RESET);
			}
			
		}
		System.out.println(ANSI_BOLD+"Total No of broken links on pagre are: "+ANSI_RESET+noOfBrokenLinks);
		
		// cleanup
		Thread.sleep(Duration.ofSeconds(10));
	    System.out.println(ANSI_BOLD+"Closing all the browser windows...!"+ANSI_RESET);
	    driver.quit();
	}
	
}
