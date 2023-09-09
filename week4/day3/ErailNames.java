package week4.day3;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ErailNames {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("MAS", Keys.ENTER);
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("CBE", Keys.ENTER);

		driver.findElement(By.id("buttonFromTo")).click();
		driver.findElement(By.xpath("//label[text()='Sort on Date']")).click();
		WebElement table = driver
				.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']"));
		List<WebElement> rowcount = table.findElements(By.tagName("tr"));

		System.out.println("RowCount: " + rowcount.size());
		Set<String> trainNames = new TreeSet<String>();

		for (int i = 2; i < rowcount.size(); i++) {

			String xpath = "//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']//tr[" + i
					+ "]/td[2]";

			trainNames.add(driver.findElement(By.xpath(xpath)).getText());

		}
		System.out.println(trainNames);
	}

}