package week3.marathon1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/ ");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Type Bags in the Search box
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags ");
	
		driver.findElement(By.xpath("//div[@aria-label='bags for boys']")).click();
		System.out.println("Total no of results");
		System.out.print(driver.findElement(By.xpath("//span[contains(text(),'results for')]")).getText());
		System.out.println(driver.findElement(By.xpath("//span[contains(text(),'results for')]/following::span[2]")).getText());
		
		//Click on the checkboxes Skybags and American Tourister
		driver.findElement(By.xpath("//li[@id='p_89/Skybags']//a")).click();
		driver.findElement(By.xpath("//li[@id='p_89/American Tourister']//a")).click();

		// Choose New Arrivals (Sort)
		driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']")).click();
		driver.findElement(By.linkText("Newest Arrivals")).click();
		
		//Print the first resulting bag info (name, discounted price) 
		String bagName=driver.findElement(By.xpath("//div[@data-component-type='s-search-result']//a/span")).getText();
		System.out.println("Bag Details:");
		System.out.println("Bag Name:"+bagName);
		String price=driver.findElement(By.xpath("//div[@class='a-row a-size-base a-color-base']")).getText();
		System.out.println("Price:Rs. "+price);
		
		System.out.println("Page Title: "+driver.getTitle());
		driver.close();
		
		}

}