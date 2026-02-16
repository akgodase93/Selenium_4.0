package shadowElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleShadoElements {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev.automationtesting.in/shadow-dom");

		// Shadow element
		SearchContext shadow_root = driver.findElement(By.id("shadow-root")).getShadowRoot();
		String text = shadow_root.findElement(By.cssSelector("#shadow-element")).getText();
		System.out.println("Shadow Element text: " + text);

		// nested shadow element
		SearchContext shado0 = driver.findElement(By.id("shadow-root")).getShadowRoot();

		SearchContext shadow1 = shado0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		String innerShadowText = shadow1.findElement(By.cssSelector("#nested-shadow-element")).getText();
		System.out.println("Inner Shadow Text: " + innerShadowText);

		// multi-nested shadow element
		SearchContext shado11 = driver.findElement(By.id("shadow-root")).getShadowRoot();
		SearchContext shado2 = shado11.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		SearchContext shado3 = shado2.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();

		String multi_nested_shadow_element = shado3.findElement(By.cssSelector("#multi-nested-shadow-element"))
				.getText();
		System.out.println("multi nested shadow element: " + multi_nested_shadow_element);

		// cleanup
		Thread.sleep(Duration.ofSeconds(10));
		System.out.println("Closing all the browser windows...!");
		driver.quit();
	}
}
