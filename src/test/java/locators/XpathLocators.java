package locators;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathLocators {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		//Types of Xpath 
		//1. Absolute xpath-->using single slash(/) and starts from root node
			String fbText = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[1]/h2")).getText();
			System.out.println("Priniting text using Absoulte Xpath:\n"+fbText);
			
		//2. Relative xpath -->Starts with any node and double forward slash '//' used
			//A. Xpath by attributes
			//Syntax: //tagname[@attribute='value']
				
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys("akshay@fb.com");
			
			//B. Xpath by text()
			//syntax: //tagname[text()='value']
				
				driver.findElement(By.xpath("//a[text()='Forgotten password?']")).click();
				
			//C. Xpath by contains()
			//C.1 Contains with text()
				//syntax: //tagname[contains(text(), 'value')]
				
				driver.findElement(By.xpath("//a[contains(text(),'ance')]")).click();
				
			//C.2 Contains with attributes
				//syntax: //tagname[contains(text(), 'value')]
				
				driver.findElement(By.xpath("//a[contains(@class,'7w5')]")).click();
				
			//D. Xpath by index
				//syntax: //(xpath expression)[index]
				
				driver.findElement(By.xpath("//input[@type='text'][1]")).sendKeys("Arjun");
				
			//E. Xpath by starts-with()
				//E.1 starts-with using attribute
				//syntax: //tagname[starts-with(@attribute, 'value')]
				
				driver.findElement(By.xpath("//input[starts-with(@aria-label, 'Sur')]")).sendKeys("Yadav");
				
				//E.1 starts-with using text
				//syntax: //tagname[starts-with(text(), 'value')]
				
				String SignUpHeader=driver.findElement(By.xpath("//div[starts-with(text(), 'Create')]")).getText();
				System.out.println("Printing SignUp Page Header: "+SignUpHeader);
			
			//F. Xpath by OR
				//Syntax: //tagname[exp1 or exp2]
				
				driver.findElement(By.xpath("//input[@name='reg_email__' or @id='u_0_h_cP']")).sendKeys("9890999900");
				
			//G. Xpath by AND
				//Syntax: //tagname[exp1 and exp2]
				
				driver.findElement(By.xpath("//input[@name='reg_passwd__' and @type='password']")).sendKeys("989@ArjuYada");
			
			//H. Xpath Axis
				//H.1 self
				//H.2 parent
				//Syntax: //<xpath expression>/parent ::tagname
				//String radioText=driver.findElement(By.xpath("//input[@id='sex']/parent :: label")).getText();
				
				String radioText=driver.findElement(By.xpath("//input[@id='sex']/parent::*")).getText();
				System.out.println("Radio button text is: "+radioText);
				
				//H.3 child
				//Syntax: //<xpath expression>/child ::tagname
				//Syntax: //<xpath expression>/tagname --> / to represent child 
				//String footerLinktext=driver.findElement(By.xpath("//ul[contains(@class,'uiList pageFooterLinkList ')]/child :: li[1]")).getText();
				
				String footerLinktext=driver.findElement(By.xpath("//ul[contains(@class,'uiList pageFooterLinkList ')]/li[1]")).getText();
				System.out.println("Foother link text: "+footerLinktext);
				
				//H.4 ancestor
				//Syntax: //<xpath expression>/ancestor ::tagname
				
				//List<WebElement> ancestors=driver.findElements(By.xpath("//a[text()='Video']/ancestor :: *"));
				List<WebElement> ancestors=driver.findElements(By.xpath("//div[@id='pageFooterChildren']/ancestor::div"));
				System.out.println("Ancestors count: "+ancestors.size());
				
				//H.5 descendant
				//Syntax: //<xpath expression>/descendant ::tagname
				List<WebElement> desc=driver.findElements(By.xpath("//div[@id='pageFooterChildren']/descendant::ul"));
				
				//List<WebElement> desc=driver.findElements(By.xpath("//ul[contains(@class,'pageFooterLinkList _509- _4ki _703 _6-i')] //li"));
				System.out.println("Descendants count: "+desc.size());
				
				//H.6 following
				//Syntax: //<xpath expression>/following ::tagname
				List<WebElement> following=driver.findElements(By.xpath("//ul[contains(@class,'pageFooterLinkList _509- _4ki _703 _6-i')] //following :: li"));
				System.out.println("Following count: "+following.size());
				
				//H.7 preceding
				//Syntax: //<xpath expression>/preceding ::tagname
				List<WebElement> preceding=driver.findElements(By.xpath("//ul[contains(@class,'pageFooterLinkList _509- _4ki _703 _6-i')] //preceding :: li"));
				System.out.println("Preceding count: "+preceding.size());
				
				//H.8 following-sibling
				//Syntax: //<xpath expression>/following-sibling ::tagname
				List<WebElement> followingSib=driver.findElements(By.xpath("//a[text()='Sign up']/parent :: li//following-sibling::li"));
				System.out.println("following-sibling count: "+followingSib.size());
				
				
				//H.9 preceding-sibling
				//Syntax: //<xpath expression>/preceding-sibling ::tagname
				
				List<WebElement> PrecedingSib=driver.findElements(By.xpath("//a[text()='Log in']/parent :: li//preceding-sibling::li"));
				System.out.println("Preceding-sibling count: "+PrecedingSib.size());
				
				
			Thread.sleep(5000);
			System.out.println("Closing all the opened windows...!");
			driver.quit();
	}

}
