package week4.day3;

import java.util.List;
import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RowColCount {
	public static void main(String args[]) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement tableHead = driver.findElement(By.xpath("//div[@class='render']/table/thead"));
		WebElement tableBody = driver.findElement(By.xpath("//div[@class='render']/table/tbody"));
		List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
		List<WebElement> cols = tableHead.findElements(By.tagName("th"));
		System.out.println("Rows Count: " + rows.size());
		System.out.println("Columns Count: " + cols.size());
	}

}