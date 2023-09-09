package week5.marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MakeMyTrip {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(opt);
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(3000);
		driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
		driver.findElement(By.xpath("//a[@class='close']")).click();
		Thread.sleep(3000);

		Actions build = new Actions(driver);
		build.moveByOffset(0, 0).click().build().perform();

		driver.findElement(By.xpath("//span[text()='Holiday Packages']")).click();

		// Choose Chennai as the departure city
		driver.findElement(By.id("fromCity")).click();
		driver.findElement(By.xpath("//div[@class='citypicker_list']//li[text()='Chennai']")).click();
		// Goa as the destination city
		driver.findElement(By.id("toCity")).click();
		driver.findElement(By.xpath("//div[@class='dest-city-container']//div[text()='Goa']")).click();
		driver.findElement(By.xpath("//div[@class='DayPicker-Day']")).click();
		driver.findElement(By.xpath("//div[@class='pointer plus-sign-wrapper']")).click();
		driver.findElement(By.xpath("//button[@class='applyBtn']")).click();
		// JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement Slider = driver.findElement(By.xpath("//div[@class='rc-slider-handle rc-slider-handle-1']"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(Slider, 50, 0).perform();

		WebElement Slider2 = driver.findElement(By.xpath("//div[@class='rc-slider-handle rc-slider-handle-2']"));
		action.dragAndDropBy(Slider2, -200, 0).perform();
		WebElement apply = driver.findElement(By.xpath("//button[text()='APPLY']"));
		driver.executeScript("arguments[0].click();", apply);

		driver.findElement(By.id("search_button")).click();
		driver.findElement(By.xpath("//button[text()='SKIP']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='close closeIcon']")).click();

		// Thread.sleep(3000);
		WebElement ele = driver.findElement(By.xpath("//div[@class='slideItem relative']"));
		driver.executeScript("arguments[0].scrollIntoView();", ele);
		File source = ele.getScreenshotAs(OutputType.FILE);
		File target = new File("./snap/makemytrip.png");
		FileUtils.copyFile(source, target);

		System.out.println("Page Title:" + driver.getTitle());
	}

}