package week4.day3;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chittorgarh {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[text()='STOCK MARKET ']")).click();
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
		WebElement tableBody = driver.findElement(By.xpath("//div[@class='table-responsive']/table/tbody"));
		List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
	   System.out.println("Rows Count: " + rows.size());
		Set<String> secName = new TreeSet<String>();
		Set<String> dupName = new TreeSet<String>();
		for (int i = 1; i < rows.size(); i++) {
			String name = driver
					.findElement(By.xpath("//div[@class='table-responsive']/table/tbody/tr[" + i + "]/td[1]"))
					.getText();
			if (!secName.add(name))
				dupName.add(name);
		}
		
		System.out.println("Security Names:");
		for (String s:secName)
			System.out.println(s);
		System.out.println("Duplicate Security Names:");
		System.out.println(dupName);

	}
}