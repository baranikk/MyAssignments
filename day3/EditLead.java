package week2.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {

		// Launch the browser

		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Enter the username and the password
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
		// Enter first name
		driver.findElement(By.xpath("//input[@id='ext-gen248']")).sendKeys("Barani");
		// Click Find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		// Click on first resulting lead and Verify title of the page
		String previousCompanyName = driver
				.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-companyName'])[1]")).getText();
		driver.findElement(
				By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]//a[@class='linktext']")).click();
		String expectedTitle = "View Lead | opentaps CRM";
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Passed. Title is verified:" + actualTitle);
		} else {
			System.out.println("Failed. Title is not matched:");
		}
		// Click Edit
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		System.out.println("PreviousCompanyName:" + previousCompanyName);
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();

		// Change the company name
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys("NTT DATA");

		// Click Update
		driver.findElement(By.xpath("//input[@value='Update']")).click();

		// Confirm the changed name appears
		String updatedCompanyName = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		System.out.println("UpdatedCompanyName: " + updatedCompanyName);
		// Close the browser (Do not log out)
		driver.close();
	}

}
