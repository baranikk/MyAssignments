package week4.day3;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintValuesinTheTable {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
		WebElement tableHead=driver.findElement(By.xpath("//div[@class='render']/table/thead"));
		WebElement tableBody=driver.findElement(By.xpath("//div[@class='render']/table/tbody"));
		List<WebElement> rows=tableBody.findElements(By.tagName("tr"));
		List<WebElement> cols=tableHead.findElements(By.tagName("th"));
		
		//Printing the table header
		for (int j = 1; j <= cols.size(); j++) 
			System.out.print(driver
						.findElement(By.xpath("//div[@class='render']/table/thead/tr[1]/th[" + j + "]")).getText()+"\t\t");
		//Printing the table body
		for (int i = 1; i <= rows.size(); i++) {
			System.out.println();
			for (int j = 1; j <= cols.size(); j++) {
				System.out.print(driver
						.findElement(By.xpath("//div[@class='render']/table/tbody/tr[" + i + "]/td[" + j + "]")).getText()+"\t\t");
			}
		}
	}
}