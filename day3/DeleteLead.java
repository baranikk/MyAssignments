package week2.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {
	public static void main(String[] args) throws InterruptedException {

		// Launch the browser
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Enter the username and password
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demoSalesManager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");

		// Click Login
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		// Click crm/sfa link
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();

		// Click Leads link
		driver.findElement(By.xpath("//a[text()='Leads']")).click();

		// Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();

		// Click on Phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();

		// Enter phone number
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9876598765");

		// Click find leads button and Capture lead ID of First Resulting lead
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		String firstLeadResult = driver
				.findElement(
						By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]//a[@class='linktext']"))
				.getText();
		System.out.println("FirstLeadID: " + firstLeadResult);

		// Click First Resulting lead
		driver.findElement(By.linkText(firstLeadResult)).click();

		// Click Delete
		driver.findElement(By.xpath("//a[text()='Delete']")).click();

		// Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();

		// Enter captured lead ID
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(firstLeadResult);

		// Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		// Verify message "No records to display" in the Lead List. This message
		// confirms the successful deletion
		String expectedDisplayRecords = "No records to display";
		String actualDisplayRecords = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		if (expectedDisplayRecords.equals(actualDisplayRecords)) {
			System.out.println("Passed. No records to display");
		}
		// Close the browser (Do not log out)

		driver.close();

	}

}