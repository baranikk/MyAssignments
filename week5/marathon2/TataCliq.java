package week5.marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TataCliq {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(opt);
		driver.get("https://www.tatacliq.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Mouse Hover on Brands
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("//div[text()='Brands']"))).perform();
		driver.findElement(By.xpath("//div[text()='Watches & Accessories']")).click();

		// Choosing the first option from the Brands display
		driver.findElement(By.xpath("//img[@class='Image__actual']")).click();

		// Click on Sort By:New Arrivals

		Select options = new Select(driver.findElement(By.xpath("//select[@class='SelectBoxDesktop__hideSelect']")));
		options.selectByVisibleText("New Arrivals");

		// Clicking 'Men' checkbox
		driver.findElement(By.xpath("//div[text()='Men']")).click();
		Thread.sleep(5000);
		List<WebElement> pricelist = driver
				.findElements(By.xpath("//div[contains(@class,'ProductDescription__priceHolder')]"));
		System.out.println("Price of " + pricelist.size() + " watches:");
		for (int i = 0; i < pricelist.size(); i++)
			System.out.println(pricelist.get(i).getText().replaceAll("[^0-9]", ""));

		String price1 = pricelist.get(1).getText().replaceAll("[^0-9]", "");

		// Opening Second match
		driver.findElement(By.xpath("(//div[@class='ProductModule__base'])[2]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		String price2 = driver.findElement(By.xpath("//div[@class='ProductDetailsMainCard__price']")).getText()
				.replaceAll("[^0-9]", "");
		System.out.println("Price of second match" + price2);
		if (price1.equalsIgnoreCase(price2))
			System.out.println("Prices of watch is the same in both the screens");

		// Click on Add to Bag
		driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
		Thread.sleep(5000);

		// click the cart count
		System.out.println("No. of items in the cart:"
				+ driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']")).getText());

		// Click the Cart Bag
		driver.findElement(By.xpath("//div[@class='DesktopHeader__myBagShow']")).click();
		Thread.sleep(5000);
		// Take snapshot
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./snap/TataCliq.png");
		FileUtils.copyFile(source, target);

		driver.close();
		driver.quit();

	}

}