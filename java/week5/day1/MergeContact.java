package week5.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MergeContact {

	public static void main(String[] args) {
		// Launch URL "http://leaftaps.com/opentaps/control/login"
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Enter UserName and Password Using Id Locator

		driver.findElement(By.id("username")).sendKeys("demosalesmanager");

		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Click on contacts Button
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		// Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

		// Click on Widget of From Contact
		driver.findElement(By.xpath("//span[text()='From Contact']/following::a[1]/img")).click();
		// window handling
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lstwindow = new ArrayList<String>(windowHandles);
		driver.switchTo().window(lstwindow.get(1));
		System.out.println("Title of From contact: " + driver.getTitle());
		// Add wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		// Click on First Resulting Contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
		// switch driver back to main window
		driver.switchTo().window(lstwindow.get(0));

		// Click on Widget of To Contact
		driver.findElement(By.xpath("//span[text()='To Contact']/following::a/img")).click();
		// window handling
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> lstwindow1 = new ArrayList<String>(windowHandles1);
		driver.switchTo().window(lstwindow1.get(1));
		System.out.println("Title of To contact: " + driver.getTitle());

		// Click on Second Resulting Contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
		// switch driver back to main window
		driver.switchTo().window(lstwindow1.get(0));
		// Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		// Accept the Alert
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert :\n" + alert.getText());
		alert.accept();

		// Verify the title of the page
		driver.getTitle();
		driver.close();

	}

}
