package week4.day4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro ", Keys.ENTER);
	
		//Print the price of the first matching entry
		System.out.println("Price: "+driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText());
		System.out.println("No. of ratings: "+driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText());
		System.out.println("Phone Description text"+driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).getText());
		driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows=new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//span[@id='submit.add-to-cart']")).click();
		driver.findElement(By.xpath("//span[@id='attach-sidesheet-view-cart-button']")).click();
		String cartSubTotal=driver.findElement(By.xpath("//span[@id='sc-subtotal-label-buybox']")).getText();
		if(cartSubTotal.contains("1 item"))
			System.out.println("Item is added properly to the cart");
		driver.quit();
	
	}

}