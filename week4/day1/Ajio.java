package week4.day1;

import java.time.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Ajio {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.ajio.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.name("searchVal")).sendKeys("bags", Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='Men']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='Men - Fashion Bags']")).click();
		List<WebElement> brand = driver.findElements(By.xpath("//div[@class='brand']"));
		System.out.println("No. of results:" + brand.size());
		System.out.println("\n\nBrands:");
		for (int i = 0; i < brand.size(); i++)
			System.out.println(brand.get(i).getText());
		// Getting the names of the bags
		List<WebElement> bagname = driver.findElements(By.xpath("//div[@class='nameCls']"));

		System.out.println("\n\nBag Names:");
		for (int i = 0; i < bagname.size(); i++)
			System.out.println(bagname.get(i).getText());

		// Getting the price and sorting the array
		List<WebElement> pricelist = driver.findElements(By.xpath("//span[@class='price  ']"));
		List<Integer> prices = new ArrayList<Integer>();
		for (int i = 0; i < pricelist.size(); i++) {
			String text = pricelist.get(i).getText();

			prices.add(Integer.parseInt(text.replaceAll("[^0-9]", "")));
		}
		Collections.sort(prices);
		System.out.println("Sorted Pricelist:");
		for (int i = 0; i < prices.size(); i++)
			System.out.print(prices.get(i) + " ");

	}

}